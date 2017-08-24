package im.actor.sdk.util;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import im.actor.runtime.android.AndroidContext;
import im.actor.sdk.BuildConfig;

public class Files {

    public static String getExternalTempFile(String prefix, String postfix) {
        File externalFile = AndroidContext.getContext().getExternalFilesDir(null);
        if (externalFile == null) {
            return null;
        }
        String externalPath = externalFile.getAbsolutePath();

        File dest = new File(externalPath + "/actor/tmp/");
        dest.mkdirs();

        File outputFile = new File(dest, prefix + "_" + Randoms.randomId() + "" + postfix);

        return outputFile.getAbsolutePath();
    }

    public static String getInternalTempFile(String prefix, String postfix) {
        String externalPath;
        File externalFile = AndroidContext.getContext().getFilesDir();

        if (externalFile == null) {
            externalPath = "data/data/".concat(AndroidContext.getContext().getPackageName()).concat("/files");
        } else {
            externalPath = externalFile.getAbsolutePath();
        }

        File dest = new File(externalPath + "/actor/tmp/");
        dest.mkdirs();
        if (!dest.exists()) return null;

        File outputFile = new File(dest, prefix + "_" + Randoms.randomId() + "" + postfix);
        return outputFile.getAbsolutePath();
    }

    public static void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    public static Uri getUri(Context ctx, String filePath){
        return FileProvider.getUriForFile(ctx, ctx.getPackageName()+".provider", new File(filePath));
    }
}
