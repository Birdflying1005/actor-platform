package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import im.actor.core.api.ApiGroupOutPeer;
import im.actor.core.network.parser.Request;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class RequestLoadAdminSettings extends Request<ResponseLoadAdminSettings> {

    public static final int HEADER = 0xae6;

    public static RequestLoadAdminSettings fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestLoadAdminSettings(), data);
    }

    private ApiGroupOutPeer groupPeer;

    public RequestLoadAdminSettings(@NotNull ApiGroupOutPeer groupPeer) {
        this.groupPeer = groupPeer;
    }

    public RequestLoadAdminSettings() {

    }

    @NotNull
    public ApiGroupOutPeer getGroupPeer() {
        return this.groupPeer;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.groupPeer = values.getObj(1, new ApiGroupOutPeer());
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.groupPeer == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.groupPeer);
    }

    @Override
    public String toString() {
        String res = "rpc LoadAdminSettings{";
        res += "groupPeer=" + this.groupPeer;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
