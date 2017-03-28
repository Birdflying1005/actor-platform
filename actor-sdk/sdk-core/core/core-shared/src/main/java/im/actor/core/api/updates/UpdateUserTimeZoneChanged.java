package im.actor.core.api.updates;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import im.actor.core.network.parser.Update;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class UpdateUserTimeZoneChanged extends Update {

    public static final int HEADER = 0xd8;

    public static UpdateUserTimeZoneChanged fromBytes(byte[] data) throws IOException {
        return Bser.parse(new UpdateUserTimeZoneChanged(), data);
    }

    private int uid;
    private String timeZone;

    public UpdateUserTimeZoneChanged(int uid, @Nullable String timeZone) {
        this.uid = uid;
        this.timeZone = timeZone;
    }

    public UpdateUserTimeZoneChanged() {

    }

    public int getUid() {
        return this.uid;
    }

    @Nullable
    public String getTimeZone() {
        return this.timeZone;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.uid = values.getInt(1);
        this.timeZone = values.optString(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.uid);
        if (this.timeZone != null) {
            writer.writeString(2, this.timeZone);
        }
    }

    @Override
    public String toString() {
        String res = "update UserTimeZoneChanged{";
        res += "uid=" + this.uid;
        res += ", timeZone=" + this.timeZone;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
