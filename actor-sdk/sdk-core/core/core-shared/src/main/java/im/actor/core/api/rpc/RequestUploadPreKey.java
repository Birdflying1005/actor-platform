package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import im.actor.core.api.ApiEncryptionKey;
import im.actor.core.api.ApiEncryptionKeySignature;
import im.actor.core.network.parser.Request;
import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class RequestUploadPreKey extends Request<ResponseVoid> {

    public static final int HEADER = 0xa34;

    public static RequestUploadPreKey fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestUploadPreKey(), data);
    }

    private int keyGroupId;
    private List<ApiEncryptionKey> keys;
    private List<ApiEncryptionKeySignature> signatures;

    public RequestUploadPreKey(int keyGroupId, @NotNull List<ApiEncryptionKey> keys, @NotNull List<ApiEncryptionKeySignature> signatures) {
        this.keyGroupId = keyGroupId;
        this.keys = keys;
        this.signatures = signatures;
    }

    public RequestUploadPreKey() {

    }

    public int getKeyGroupId() {
        return this.keyGroupId;
    }

    @NotNull
    public List<ApiEncryptionKey> getKeys() {
        return this.keys;
    }

    @NotNull
    public List<ApiEncryptionKeySignature> getSignatures() {
        return this.signatures;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.keyGroupId = values.getInt(1);
        List<ApiEncryptionKey> _keys = new ArrayList<ApiEncryptionKey>();
        for (int i = 0; i < values.getRepeatedCount(2); i++) {
            _keys.add(new ApiEncryptionKey());
        }
        this.keys = values.getRepeatedObj(2, _keys);
        List<ApiEncryptionKeySignature> _signatures = new ArrayList<ApiEncryptionKeySignature>();
        for (int i = 0; i < values.getRepeatedCount(3); i++) {
            _signatures.add(new ApiEncryptionKeySignature());
        }
        this.signatures = values.getRepeatedObj(3, _signatures);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.keyGroupId);
        writer.writeRepeatedObj(2, this.keys);
        writer.writeRepeatedObj(3, this.signatures);
    }

    @Override
    public String toString() {
        String res = "rpc UploadPreKey{";
        res += "keyGroupId=" + this.keyGroupId;
        res += ", keys=" + this.keys.size();
        res += ", signatures=" + this.signatures.size();
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
