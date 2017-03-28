package im.actor.core.api;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class ApiSearchPeerContentType extends ApiSearchCondition {

    private ApiSearchContentType contentType;

    public ApiSearchPeerContentType(@NotNull ApiSearchContentType contentType) {
        this.contentType = contentType;
    }

    public ApiSearchPeerContentType() {

    }

    public int getHeader() {
        return 6;
    }

    @NotNull
    public ApiSearchContentType getContentType() {
        return this.contentType;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.contentType = ApiSearchContentType.parse(values.getInt(1));
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.contentType == null) {
            throw new IOException();
        }
        writer.writeInt(1, this.contentType.getValue());
    }

    @Override
    public String toString() {
        String res = "struct SearchPeerContentType{";
        res += "contentType=" + this.contentType;
        res += "}";
        return res;
    }

}
