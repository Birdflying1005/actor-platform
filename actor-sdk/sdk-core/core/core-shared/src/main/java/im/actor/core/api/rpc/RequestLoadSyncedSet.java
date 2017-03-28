package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import im.actor.core.network.parser.Request;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class RequestLoadSyncedSet extends Request<ResponseLoadSyncedSet> {

    public static final int HEADER = 0xa77;

    public static RequestLoadSyncedSet fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestLoadSyncedSet(), data);
    }

    private String setName;

    public RequestLoadSyncedSet(@NotNull String setName) {
        this.setName = setName;
    }

    public RequestLoadSyncedSet() {

    }

    @NotNull
    public String getSetName() {
        return this.setName;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.setName = values.getString(1);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.setName == null) {
            throw new IOException();
        }
        writer.writeString(1, this.setName);
    }

    @Override
    public String toString() {
        String res = "rpc LoadSyncedSet{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
