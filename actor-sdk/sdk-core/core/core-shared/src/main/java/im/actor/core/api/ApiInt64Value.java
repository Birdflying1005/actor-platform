package im.actor.core.api;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import java.io.IOException;

import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class ApiInt64Value extends ApiRawValue {

    private long value;

    public ApiInt64Value(long value) {
        this.value = value;
    }

    public ApiInt64Value() {

    }

    public int getHeader() {
        return 3;
    }

    public long getValue() {
        return this.value;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.value = values.getLong(1);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeLong(1, this.value);
    }

    @Override
    public String toString() {
        String res = "struct Int64Value{";
        res += "}";
        return res;
    }

}
