package im.actor.core.api.updates;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import im.actor.core.api.ApiEncryptionKeyGroup;
import im.actor.core.network.parser.Update;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class UpdatePublicKeyGroupChanged extends Update {

    public static final int HEADER = 0x67;

    public static UpdatePublicKeyGroupChanged fromBytes(byte[] data) throws IOException {
        return Bser.parse(new UpdatePublicKeyGroupChanged(), data);
    }

    private int uid;
    private ApiEncryptionKeyGroup keyGroup;

    public UpdatePublicKeyGroupChanged(int uid, @NotNull ApiEncryptionKeyGroup keyGroup) {
        this.uid = uid;
        this.keyGroup = keyGroup;
    }

    public UpdatePublicKeyGroupChanged() {

    }

    public int getUid() {
        return this.uid;
    }

    @NotNull
    public ApiEncryptionKeyGroup getKeyGroup() {
        return this.keyGroup;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.uid = values.getInt(1);
        this.keyGroup = values.getObj(2, new ApiEncryptionKeyGroup());
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.uid);
        if (this.keyGroup == null) {
            throw new IOException();
        }
        writer.writeObject(2, this.keyGroup);
    }

    @Override
    public String toString() {
        String res = "update PublicKeyGroupChanged{";
        res += "uid=" + this.uid;
        res += ", keyGroup=" + this.keyGroup;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
