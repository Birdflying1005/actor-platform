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

public class RequestSendAuthCodeObsolete extends Request<ResponseSendAuthCodeObsolete> {

    public static final int HEADER = 0x1;

    public static RequestSendAuthCodeObsolete fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestSendAuthCodeObsolete(), data);
    }

    private long phoneNumber;
    private int appId;
    private String apiKey;

    public RequestSendAuthCodeObsolete(long phoneNumber, int appId, @NotNull String apiKey) {
        this.phoneNumber = phoneNumber;
        this.appId = appId;
        this.apiKey = apiKey;
    }

    public RequestSendAuthCodeObsolete() {

    }

    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    public int getAppId() {
        return this.appId;
    }

    @NotNull
    public String getApiKey() {
        return this.apiKey;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.phoneNumber = values.getLong(1);
        this.appId = values.getInt(2);
        this.apiKey = values.getString(3);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeLong(1, this.phoneNumber);
        writer.writeInt(2, this.appId);
        if (this.apiKey == null) {
            throw new IOException();
        }
        writer.writeString(3, this.apiKey);
    }

    @Override
    public String toString() {
        String res = "rpc SendAuthCodeObsolete{";
        res += "phoneNumber=" + this.phoneNumber;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
