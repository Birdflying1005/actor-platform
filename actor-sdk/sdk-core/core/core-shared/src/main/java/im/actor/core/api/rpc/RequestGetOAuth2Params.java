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

public class RequestGetOAuth2Params extends Request<ResponseGetOAuth2Params> {

    public static final int HEADER = 0xc2;

    public static RequestGetOAuth2Params fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestGetOAuth2Params(), data);
    }

    private String transactionHash;
    private String redirectUrl;

    public RequestGetOAuth2Params(@NotNull String transactionHash, @NotNull String redirectUrl) {
        this.transactionHash = transactionHash;
        this.redirectUrl = redirectUrl;
    }

    public RequestGetOAuth2Params() {

    }

    @NotNull
    public String getTransactionHash() {
        return this.transactionHash;
    }

    @NotNull
    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.transactionHash = values.getString(1);
        this.redirectUrl = values.getString(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.transactionHash == null) {
            throw new IOException();
        }
        writer.writeString(1, this.transactionHash);
        if (this.redirectUrl == null) {
            throw new IOException();
        }
        writer.writeString(2, this.redirectUrl);
    }

    @Override
    public String toString() {
        String res = "rpc GetOAuth2Params{";
        res += "redirectUrl=" + this.redirectUrl;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
