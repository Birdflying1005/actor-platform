package im.actor.core.api;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import im.actor.runtime.bser.BserObject;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;
import im.actor.runtime.collections.SparseArray;

public class ApiContactRecord extends BserObject {

    private ApiContactType type;
    private String typeSpec;
    private String stringValue;
    private Long longValue;
    private String title;
    private String subtitle;

    public ApiContactRecord(@NotNull ApiContactType type, @Nullable String typeSpec, @Nullable String stringValue, @Nullable Long longValue, @Nullable String title, @Nullable String subtitle) {
        this.type = type;
        this.typeSpec = typeSpec;
        this.stringValue = stringValue;
        this.longValue = longValue;
        this.title = title;
        this.subtitle = subtitle;
    }

    public ApiContactRecord() {

    }

    @NotNull
    public ApiContactType getType() {
        return this.type;
    }

    @Nullable
    public String getTypeSpec() {
        return this.typeSpec;
    }

    @Nullable
    public String getStringValue() {
        return this.stringValue;
    }

    @Nullable
    public Long getLongValue() {
        return this.longValue;
    }

    @Nullable
    public String getTitle() {
        return this.title;
    }

    @Nullable
    public String getSubtitle() {
        return this.subtitle;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.type = ApiContactType.parse(values.getInt(1));
        this.typeSpec = values.optString(6);
        this.stringValue = values.optString(2);
        this.longValue = values.optLong(3);
        this.title = values.optString(4);
        this.subtitle = values.optString(5);
        if (values.hasRemaining()) {
            setUnmappedObjects(values.buildRemaining());
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.type == null) {
            throw new IOException();
        }
        writer.writeInt(1, this.type.getValue());
        if (this.typeSpec != null) {
            writer.writeString(6, this.typeSpec);
        }
        if (this.stringValue != null) {
            writer.writeString(2, this.stringValue);
        }
        if (this.longValue != null) {
            writer.writeLong(3, this.longValue);
        }
        if (this.title != null) {
            writer.writeString(4, this.title);
        }
        if (this.subtitle != null) {
            writer.writeString(5, this.subtitle);
        }
        if (this.getUnmappedObjects() != null) {
            SparseArray<Object> unmapped = this.getUnmappedObjects();
            for (int i = 0; i < unmapped.size(); i++) {
                int key = unmapped.keyAt(i);
                writer.writeUnmapped(key, unmapped.get(key));
            }
        }
    }

    @Override
    public String toString() {
        String res = "struct ContactRecord{";
        res += "type=" + this.type;
        res += ", stringValue=" + this.stringValue;
        res += ", longValue=" + this.longValue;
        res += ", title=" + this.title;
        res += "}";
        return res;
    }

}
