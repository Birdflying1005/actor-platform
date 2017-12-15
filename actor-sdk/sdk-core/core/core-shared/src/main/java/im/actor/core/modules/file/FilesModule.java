/*
 * Copyright (C) 2015 Actor LLC. <https://actor.im>
 */

package im.actor.core.modules.file;

import java.io.IOException;

import im.actor.core.entity.FileReference;
import im.actor.core.modules.AbsModule;
import im.actor.core.modules.ModuleContext;
import im.actor.core.modules.file.entity.Downloaded;
import im.actor.core.util.BaseKeyValueEngine;
import im.actor.core.viewmodel.CompressVideoCallback;
import im.actor.core.viewmodel.FileCallback;
import im.actor.core.viewmodel.FileEventCallback;
import im.actor.core.viewmodel.UploadFileCallback;
import im.actor.runtime.Log;
import im.actor.runtime.Storage;
import im.actor.runtime.actors.ActorRef;
import im.actor.runtime.actors.Props;
import im.actor.runtime.files.FileSystemReference;
import im.actor.runtime.storage.KeyValueEngine;

import static im.actor.runtime.actors.ActorSystem.system;

public class FilesModule extends AbsModule {

    private static final String TAG = FilesModule.class.getName();

    private KeyValueEngine<Downloaded> downloadedEngine;
    private ActorRef downloadManager;
    private ActorRef uploadManager;
    private FileUrlInt fileUrlInt;
    private ActorRef compressVideoManager;

    public FilesModule(final ModuleContext context) {
        super(context);

        downloadedEngine = new BaseKeyValueEngine<Downloaded>(Storage.createKeyValue(STORAGE_DOWNLOADS)) {
            @Override
            protected byte[] serialize(Downloaded value) {
                return value.toByteArray();
            }

            @Override
            protected Downloaded deserialize(byte[] data) {
                try {
                    return Downloaded.fromBytes(data);
                } catch (IOException e) {
                    Log.e(TAG, e);
                    return null;
                }
            }
        };
    }

    public void run() {
        fileUrlInt = new FileUrlInt(system().actorOf("actor/download/urls", () -> new FileUrlLoader(context())));
        downloadManager = system().actorOf(Props.create(() -> new DownloadManager(context())).changeDispatcher("heavy"), "actor/download/manager");
        uploadManager = system().actorOf(Props.create(() -> new UploadManager(context())).changeDispatcher("heavy"), "actor/upload/manager");
        compressVideoManager = system().actorOf(Props.create(() -> new CompressVideoManager(context())).changeDispatcher("heavy"), "actor/compressVideo/manager");
    }

    public KeyValueEngine<Downloaded> getDownloadedEngine() {
        return downloadedEngine;
    }

    public FileUrlInt getFileUrlInt() {
        return fileUrlInt;
    }

    public void subscribe(FileEventCallback callback) {
        downloadManager.send(new DownloadManager.SubscribeToDownloads(callback));
    }

    public void unsubscribe(FileEventCallback callback) {
        downloadManager.send(new DownloadManager.UnsubscribeToDownloads(callback));
    }

    public void bindFile(FileReference fileReference, boolean isAutostart, FileCallback callback) {
        downloadManager.send(new DownloadManager.BindDownload(fileReference, isAutostart, callback));
    }

    public void unbindFile(long fileId, FileCallback callback, boolean cancel) {
        downloadManager.send(new DownloadManager.UnbindDownload(fileId, cancel, callback));
    }

    public void requestState(long fileId, final FileCallback callback) {
        downloadManager.send(new DownloadManager.RequestState(fileId, new FileCallback() {
            @Override
            public void onNotDownloaded() {
                runOnUiThread(() -> callback.onNotDownloaded());
            }

            @Override
            public void onDownloading(final float progress) {
                runOnUiThread(() -> callback.onDownloading(progress));
            }

            @Override
            public void onDownloaded(final FileSystemReference reference) {
                runOnUiThread(() -> callback.onDownloaded(reference));
            }
        }));
    }

    public void startDownloading(final FileReference location) {
        im.actor.runtime.Runtime.dispatch(() -> downloadManager.send(new DownloadManager.StartDownload(location)));
    }

    public void cancelDownloading(long fileId) {
        downloadManager.send(new DownloadManager.CancelDownload(fileId));
    }

    // Upload

    public void bindUploadFile(long rid, UploadFileCallback uploadFileCallback) {
        uploadManager.send(new UploadManager.BindUpload(rid, uploadFileCallback));
    }

    public void unbindUploadFile(long rid, UploadFileCallback callback) {
        uploadManager.send(new UploadManager.UnbindUpload(rid, callback));
    }

    public void requestUpload(long rid, String descriptor, String fileName, ActorRef requester) {
        uploadManager.send(new UploadManager.StartUpload(rid, descriptor, fileName), requester);
    }

    public void bindCompressVideo(long rid, CompressVideoCallback uploadFileCallback) {
        compressVideoManager.send(new CompressVideoManager.BindCompress(rid, uploadFileCallback));
    }

    public void unbindCompressVideo(long rid, CompressVideoCallback callback) {
        compressVideoManager.send(new CompressVideoManager.UnbindCompress(rid, callback));
    }

    public void requestCompressVideo(long rid, String fileName, String originalVideoPath, ActorRef requester) {
        compressVideoManager.send(new CompressVideoManager.StartCompression(rid, fileName, originalVideoPath), requester);
    }

    public void cancelUpload(long rid) {
        uploadManager.send(new UploadManager.StopUpload(rid));
    }

    public void requestUploadState(long rid, UploadFileCallback callback) {
        uploadManager.send(new UploadManager.RequestState(rid, callback));
    }

    public void requestVideoCompressState(long rid, CompressVideoCallback callback) {
        uploadManager.send(new CompressVideoManager.RequestState(rid, callback));
    }

    public void resumeUpload(long rid) {
        uploadManager.send(new UploadManager.ResumeUpload(rid));
    }

    public void resumeVideoCompressing(long rid) {
        compressVideoManager.send(new CompressVideoManager.ResumeCompressing(rid));
    }


    public void pauseUpload(long rid) {
        uploadManager.send(new UploadManager.PauseUpload(rid));
    }

    public String getDownloadedDescriptor(long fileId) {
        Downloaded downloaded = downloadedEngine.getValue(fileId);
        if (downloaded == null) {
            return null;
        } else {
            return downloaded.getDescriptor();
        }
    }

    public void resetModule() {
        // TODO: Implement
    }
}