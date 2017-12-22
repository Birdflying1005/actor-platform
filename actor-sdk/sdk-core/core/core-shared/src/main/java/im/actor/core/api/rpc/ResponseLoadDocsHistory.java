package im.actor.core.api.rpc;
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
import im.actor.core.api.*;

public class ResponseLoadDocsHistory extends Response {

    public static final int HEADER = 0x107;
    public static ResponseLoadDocsHistory fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseLoadDocsHistory(), data);
    }

    private List<ApiMessageContainer> history;

    public ResponseLoadDocsHistory(@NotNull List<ApiMessageContainer> history) {
        this.history = history;
    }

    public ResponseLoadDocsHistory() {

    }

    @NotNull
    public List<ApiMessageContainer> getHistory() {
        return this.history;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<ApiMessageContainer> _history = new ArrayList<ApiMessageContainer>();
        for (int i = 0; i < values.getRepeatedCount(1); i ++) {
            _history.add(new ApiMessageContainer());
        }
        this.history = values.getRepeatedObj(1, _history);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.history);
    }

    @Override
    public String toString() {
        String res = "tuple LoadDocsHistory{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}