package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import im.actor.core.api.ApiRawValue;
import im.actor.core.network.parser.Response;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class ResponseRawRequest extends Response {

    public static final int HEADER = 0xa0a;

    public static ResponseRawRequest fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseRawRequest(), data);
    }

    private ApiRawValue result;

    public ResponseRawRequest(@NotNull ApiRawValue result) {
        this.result = result;
    }

    public ResponseRawRequest() {

    }

    @NotNull
    public ApiRawValue getResult() {
        return this.result;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.result = ApiRawValue.fromBytes(values.getBytes(1));
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.result == null) {
            throw new IOException();
        }

        writer.writeBytes(1, this.result.buildContainer());
    }

    @Override
    public String toString() {
        String res = "tuple RawRequest{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
