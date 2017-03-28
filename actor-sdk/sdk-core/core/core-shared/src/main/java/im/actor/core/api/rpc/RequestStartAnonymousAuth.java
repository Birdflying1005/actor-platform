package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

import im.actor.core.network.parser.Request;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

import static im.actor.runtime.bser.Utils.byteArrayToString;

public class RequestStartAnonymousAuth extends Request<ResponseAuth> {

    public static final int HEADER = 0xc6;

    public static RequestStartAnonymousAuth fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestStartAnonymousAuth(), data);
    }

    private String name;
    private int appId;
    private String apiKey;
    private byte[] deviceHash;
    private String deviceTitle;
    private String timeZone;
    private List<String> preferredLanguages;

    public RequestStartAnonymousAuth(@NotNull String name, int appId, @NotNull String apiKey, @NotNull byte[] deviceHash, @NotNull String deviceTitle, @Nullable String timeZone, @NotNull List<String> preferredLanguages) {
        this.name = name;
        this.appId = appId;
        this.apiKey = apiKey;
        this.deviceHash = deviceHash;
        this.deviceTitle = deviceTitle;
        this.timeZone = timeZone;
        this.preferredLanguages = preferredLanguages;
    }

    public RequestStartAnonymousAuth() {

    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public int getAppId() {
        return this.appId;
    }

    @NotNull
    public String getApiKey() {
        return this.apiKey;
    }

    @NotNull
    public byte[] getDeviceHash() {
        return this.deviceHash;
    }

    @NotNull
    public String getDeviceTitle() {
        return this.deviceTitle;
    }

    @Nullable
    public String getTimeZone() {
        return this.timeZone;
    }

    @NotNull
    public List<String> getPreferredLanguages() {
        return this.preferredLanguages;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.name = values.getString(1);
        this.appId = values.getInt(2);
        this.apiKey = values.getString(3);
        this.deviceHash = values.getBytes(4);
        this.deviceTitle = values.getString(5);
        this.timeZone = values.optString(6);
        this.preferredLanguages = values.getRepeatedString(7);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.name == null) {
            throw new IOException();
        }
        writer.writeString(1, this.name);
        writer.writeInt(2, this.appId);
        if (this.apiKey == null) {
            throw new IOException();
        }
        writer.writeString(3, this.apiKey);
        if (this.deviceHash == null) {
            throw new IOException();
        }
        writer.writeBytes(4, this.deviceHash);
        if (this.deviceTitle == null) {
            throw new IOException();
        }
        writer.writeString(5, this.deviceTitle);
        if (this.timeZone != null) {
            writer.writeString(6, this.timeZone);
        }
        writer.writeRepeatedString(7, this.preferredLanguages);
    }

    @Override
    public String toString() {
        String res = "rpc StartAnonymousAuth{";
        res += "name=" + this.name;
        res += ", deviceHash=" + byteArrayToString(this.deviceHash);
        res += ", deviceTitle=" + this.deviceTitle;
        res += ", timeZone=" + this.timeZone;
        res += ", preferredLanguages=" + this.preferredLanguages;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
