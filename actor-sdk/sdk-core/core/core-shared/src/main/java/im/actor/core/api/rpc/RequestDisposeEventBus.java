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

public class RequestDisposeEventBus extends Request<ResponseVoid> {

    public static final int HEADER = 0xa6b;

    public static RequestDisposeEventBus fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestDisposeEventBus(), data);
    }

    private String id;

    public RequestDisposeEventBus(@NotNull String id) {
        this.id = id;
    }

    public RequestDisposeEventBus() {

    }

    @NotNull
    public String getId() {
        return this.id;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.id = values.getString(1);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.id == null) {
            throw new IOException();
        }
        writer.writeString(1, this.id);
    }

    @Override
    public String toString() {
        String res = "rpc DisposeEventBus{";
        res += "id=" + this.id;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
