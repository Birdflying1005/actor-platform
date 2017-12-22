package im.actor.core.api;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ApiGroupPre extends BserObject {

    private int groupId;
    private boolean hasChildrem;
    private long acessHash;
    private int order;
    private Integer parentId;

    public ApiGroupPre(int groupId, boolean hasChildrem, long acessHash, int order, @Nullable Integer parentId) {
        this.groupId = groupId;
        this.hasChildrem = hasChildrem;
        this.acessHash = acessHash;
        this.order = order;
        this.parentId = parentId;
    }

    public ApiGroupPre() {

    }

    public int getGroupId() {
        return this.groupId;
    }

    public boolean hasChildrem() {
        return this.hasChildrem;
    }

    public long getAcessHash() {
        return this.acessHash;
    }

    public int getOrder() {
        return this.order;
    }

    @Nullable
    public Integer getParentId() {
        return this.parentId;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.groupId = values.getInt(1);
        this.hasChildrem = values.getBool(2);
        this.acessHash = values.getLong(3);
        this.order = values.getInt(4);
        this.parentId = values.optInt(5);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.groupId);
        writer.writeBool(2, this.hasChildrem);
        writer.writeLong(3, this.acessHash);
        writer.writeInt(4, this.order);
        if (this.parentId != null) {
            writer.writeInt(5, this.parentId);
        }
    }

    @Override
    public String toString() {
        String res = "struct GroupPre{";
        res += "}";
        return res;
    }

}