package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import im.actor.core.api.ApiUpdateOptimization;
import im.actor.core.network.parser.Request;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class RequestSearchContacts extends Request<ResponseSearchContacts> {

    public static final int HEADER = 0x70;

    public static RequestSearchContacts fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestSearchContacts(), data);
    }

    private String request;
    private List<ApiUpdateOptimization> optimizations;

    public RequestSearchContacts(@NotNull String request, @NotNull List<ApiUpdateOptimization> optimizations) {
        this.request = request;
        this.optimizations = optimizations;
    }

    public RequestSearchContacts() {

    }

    @NotNull
    public String getRequest() {
        return this.request;
    }

    @NotNull
    public List<ApiUpdateOptimization> getOptimizations() {
        return this.optimizations;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.request = values.getString(1);
        this.optimizations = new ArrayList<ApiUpdateOptimization>();
        for (int b : values.getRepeatedInt(2)) {
            optimizations.add(ApiUpdateOptimization.parse(b));
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.request == null) {
            throw new IOException();
        }
        writer.writeString(1, this.request);
        for (ApiUpdateOptimization i : this.optimizations) {
            writer.writeInt(2, i.getValue());
        }
    }

    @Override
    public String toString() {
        String res = "rpc SearchContacts{";
        res += "request=" + this.request;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
