package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import java.io.IOException;

import im.actor.core.network.parser.Response;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class ResponseUploadSharedBlob extends Response {

    public static final int HEADER = 0xa65;

    public static ResponseUploadSharedBlob fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseUploadSharedBlob(), data);
    }

    private int sharedObjectId;

    public ResponseUploadSharedBlob(int sharedObjectId) {
        this.sharedObjectId = sharedObjectId;
    }

    public ResponseUploadSharedBlob() {

    }

    public int getSharedObjectId() {
        return this.sharedObjectId;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.sharedObjectId = values.getInt(1);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.sharedObjectId);
    }

    @Override
    public String toString() {
        String res = "tuple UploadSharedBlob{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
