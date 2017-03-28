package im.actor.core.api;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import im.actor.runtime.bser.BserObject;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class ApiDialogGroup extends BserObject {

    private String title;
    private String key;
    private List<ApiDialogShort> dialogs;

    public ApiDialogGroup(@NotNull String title, @NotNull String key, @NotNull List<ApiDialogShort> dialogs) {
        this.title = title;
        this.key = key;
        this.dialogs = dialogs;
    }

    public ApiDialogGroup() {

    }

    @NotNull
    public String getTitle() {
        return this.title;
    }

    @NotNull
    public String getKey() {
        return this.key;
    }

    @NotNull
    public List<ApiDialogShort> getDialogs() {
        return this.dialogs;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.title = values.getString(1);
        this.key = values.getString(2);
        List<ApiDialogShort> _dialogs = new ArrayList<ApiDialogShort>();
        for (int i = 0; i < values.getRepeatedCount(3); i++) {
            _dialogs.add(new ApiDialogShort());
        }
        this.dialogs = values.getRepeatedObj(3, _dialogs);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.title == null) {
            throw new IOException();
        }
        writer.writeString(1, this.title);
        if (this.key == null) {
            throw new IOException();
        }
        writer.writeString(2, this.key);
        writer.writeRepeatedObj(3, this.dialogs);
    }

    @Override
    public String toString() {
        String res = "struct DialogGroup{";
        res += "title=" + this.title;
        res += ", key=" + this.key;
        res += ", dialogs=" + this.dialogs;
        res += "}";
        return res;
    }

}
