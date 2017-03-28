package br.com.diegosilva.lotericas.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.diegosilva.lotericas.core.api.*;

import static im.actor.runtime.bser.Utils.*;

public class ResponseLoadGroupsPre extends Response {

    public static final int HEADER = 0x14;

    public static ResponseLoadGroupsPre fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseLoadGroupsPre(), data);
    }

    private List<ApiGroupPre> groups;

    public ResponseLoadGroupsPre(@NotNull List<ApiGroupPre> groups) {
        this.groups = groups;
    }

    public ResponseLoadGroupsPre() {

    }

    @NotNull
    public List<ApiGroupPre> getGroups() {
        return this.groups;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<ApiGroupPre> _groups = new ArrayList<ApiGroupPre>();
        for (int i = 0; i < values.getRepeatedCount(1); i++) {
            _groups.add(new ApiGroupPre());
        }
        this.groups = values.getRepeatedObj(1, _groups);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.groups);
    }

    @Override
    public String toString() {
        String res = "tuple LoadGroupsPre{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
