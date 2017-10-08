package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import im.actor.core.api.ApiGroupOutPeer;
import im.actor.core.api.ApiUserOutPeer;
import im.actor.core.network.parser.Request;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class RequestMakeUserAdmin extends Request<ResponseSeqDate> {

    public static final int HEADER = 0xae0;

    public static RequestMakeUserAdmin fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestMakeUserAdmin(), data);
    }

    private ApiGroupOutPeer groupPeer;
    private ApiUserOutPeer userPeer;

    public RequestMakeUserAdmin(@NotNull ApiGroupOutPeer groupPeer, @NotNull ApiUserOutPeer userPeer) {
        this.groupPeer = groupPeer;
        this.userPeer = userPeer;
    }

    public RequestMakeUserAdmin() {

    }

    @NotNull
    public ApiGroupOutPeer getGroupPeer() {
        return this.groupPeer;
    }

    @NotNull
    public ApiUserOutPeer getUserPeer() {
        return this.userPeer;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.groupPeer = values.getObj(1, new ApiGroupOutPeer());
        this.userPeer = values.getObj(2, new ApiUserOutPeer());
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.groupPeer == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.groupPeer);
        if (this.userPeer == null) {
            throw new IOException();
        }
        writer.writeObject(2, this.userPeer);
    }

    @Override
    public String toString() {
        String res = "rpc MakeUserAdmin{";
        res += "groupPeer=" + this.groupPeer;
        res += ", userPeer=" + this.userPeer;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
