package im.actor.core.api;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import java.io.IOException;

import im.actor.runtime.bser.Bser;
import im.actor.runtime.bser.BserObject;
import im.actor.runtime.bser.BserParser;
import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;
import im.actor.runtime.bser.DataInput;
import im.actor.runtime.bser.DataOutput;

public abstract class ApiColor extends BserObject {
    public static ApiColor fromBytes(byte[] src) throws IOException {
        BserValues values = new BserValues(BserParser.deserialize(new DataInput(src, 0, src.length)));
        int key = values.getInt(1);
        byte[] content = values.getBytes(2);
        switch (key) {
            case 1:
                return Bser.parse(new ApiRgbColor(), content);
            case 2:
                return Bser.parse(new ApiPredefinedColor(), content);
            default:
                return new ApiColorUnsupported(key, content);
        }
    }

    public abstract int getHeader();

    public byte[] buildContainer() throws IOException {
        DataOutput res = new DataOutput();
        BserWriter writer = new BserWriter(res);
        writer.writeInt(1, getHeader());
        writer.writeBytes(2, toByteArray());
        return res.toByteArray();
    }

}
