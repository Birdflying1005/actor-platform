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

import static im.actor.runtime.bser.Utils.byteArrayToString;

public class RequestReJoinEventBus extends Request<ResponseReJoinEventBus> {

    public static final int HEADER = 0xa73;

    public static RequestReJoinEventBus fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestReJoinEventBus(), data);
    }

    private String id;
    private byte[] rejoinToken;

    public RequestReJoinEventBus(@NotNull String id, @NotNull byte[] rejoinToken) {
        this.id = id;
        this.rejoinToken = rejoinToken;
    }

    public RequestReJoinEventBus() {

    }

    @NotNull
    public String getId() {
        return this.id;
    }

    @NotNull
    public byte[] getRejoinToken() {
        return this.rejoinToken;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.id = values.getString(1);
        this.rejoinToken = values.getBytes(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.id == null) {
            throw new IOException();
        }
        writer.writeString(1, this.id);
        if (this.rejoinToken == null) {
            throw new IOException();
        }
        writer.writeBytes(2, this.rejoinToken);
    }

    @Override
    public String toString() {
        String res = "rpc ReJoinEventBus{";
        res += "id=" + this.id;
        res += ", rejoinToken=" + byteArrayToString(this.rejoinToken);
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
