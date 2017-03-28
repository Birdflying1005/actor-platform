package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import im.actor.core.api.ApiFileLocation;
import im.actor.core.network.parser.Request;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class RequestGetFileUrl extends Request<ResponseGetFileUrl> {

    public static final int HEADER = 0x4d;

    public static RequestGetFileUrl fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestGetFileUrl(), data);
    }

    private ApiFileLocation file;

    public RequestGetFileUrl(@NotNull ApiFileLocation file) {
        this.file = file;
    }

    public RequestGetFileUrl() {

    }

    @NotNull
    public ApiFileLocation getFile() {
        return this.file;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.file = values.getObj(1, new ApiFileLocation());
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.file == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.file);
    }

    @Override
    public String toString() {
        String res = "rpc GetFileUrl{";
        res += "file=" + this.file;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
