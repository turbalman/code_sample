package com.demo.util;

import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;

import java.io.IOException;

/**
 * The type Protobuf util.
 */
public final class ProtobufUtil {
    /**
     * Instantiates a new Protobuf util.
     */
    private ProtobufUtil() {
    }

    /**
     * To json string.
     *
     * @param messageOrBuilder the message or builder
     * @return the string
     * @throws IOException the io exception
     */
    public static String toJson(final MessageOrBuilder messageOrBuilder) throws IOException {
        return JsonFormat.printer().print(messageOrBuilder);
    }

    /**
     * From json t.
     *
     * @param <T>   the type parameter
     * @param json  the json
     * @param clazz the clazz
     * @return the t
     * @throws IOException the io exception
     */
    public static <T extends Message> T fromJson(final String json, final Class<T> clazz) throws IOException {
        try {
            Builder<?> builder = (Builder<?>) clazz.getMethod("newBuilder").invoke(null);
            JsonFormat.parser().ignoringUnknownFields().merge(json, builder);
            return (T) builder.build();
        } catch (Exception e) {
            return null;
        }
    }
}
