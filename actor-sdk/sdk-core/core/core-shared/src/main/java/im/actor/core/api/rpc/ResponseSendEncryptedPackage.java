package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import im.actor.core.api.ApiKeyGroupHolder;
import im.actor.core.api.ApiKeyGroupId;
import im.actor.core.network.parser.Response;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class ResponseSendEncryptedPackage extends Response {

    public static final int HEADER = 0xa68;

    public static ResponseSendEncryptedPackage fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseSendEncryptedPackage(), data);
    }

    private Long date;
    private List<ApiKeyGroupId> obsoleteKeyGroups;
    private List<ApiKeyGroupHolder> missedKeyGroups;

    public ResponseSendEncryptedPackage(@Nullable Long date, @NotNull List<ApiKeyGroupId> obsoleteKeyGroups, @NotNull List<ApiKeyGroupHolder> missedKeyGroups) {
        this.date = date;
        this.obsoleteKeyGroups = obsoleteKeyGroups;
        this.missedKeyGroups = missedKeyGroups;
    }

    public ResponseSendEncryptedPackage() {

    }

    @Nullable
    public Long getDate() {
        return this.date;
    }

    @NotNull
    public List<ApiKeyGroupId> getObsoleteKeyGroups() {
        return this.obsoleteKeyGroups;
    }

    @NotNull
    public List<ApiKeyGroupHolder> getMissedKeyGroups() {
        return this.missedKeyGroups;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.date = values.optLong(1);
        List<ApiKeyGroupId> _obsoleteKeyGroups = new ArrayList<ApiKeyGroupId>();
        for (int i = 0; i < values.getRepeatedCount(2); i++) {
            _obsoleteKeyGroups.add(new ApiKeyGroupId());
        }
        this.obsoleteKeyGroups = values.getRepeatedObj(2, _obsoleteKeyGroups);
        List<ApiKeyGroupHolder> _missedKeyGroups = new ArrayList<ApiKeyGroupHolder>();
        for (int i = 0; i < values.getRepeatedCount(3); i++) {
            _missedKeyGroups.add(new ApiKeyGroupHolder());
        }
        this.missedKeyGroups = values.getRepeatedObj(3, _missedKeyGroups);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.date != null) {
            writer.writeLong(1, this.date);
        }
        writer.writeRepeatedObj(2, this.obsoleteKeyGroups);
        writer.writeRepeatedObj(3, this.missedKeyGroups);
    }

    @Override
    public String toString() {
        String res = "tuple SendEncryptedPackage{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
