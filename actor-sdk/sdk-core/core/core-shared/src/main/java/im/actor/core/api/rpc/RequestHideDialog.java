package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import im.actor.core.api.ApiOutPeer;
import im.actor.core.network.parser.Request;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class RequestHideDialog extends Request<ResponseDialogsOrder> {

    public static final int HEADER = 0xe7;

    public static RequestHideDialog fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestHideDialog(), data);
    }

    private ApiOutPeer peer;

    public RequestHideDialog(@NotNull ApiOutPeer peer) {
        this.peer = peer;
    }

    public RequestHideDialog() {

    }

    @NotNull
    public ApiOutPeer getPeer() {
        return this.peer;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.peer = values.getObj(1, new ApiOutPeer());
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.peer == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.peer);
    }

    @Override
    public String toString() {
        String res = "rpc HideDialog{";
        res += "peer=" + this.peer;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
