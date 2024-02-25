package com.demo.order.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;

import javax.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentMap;


/**
 * The type Object mappers.
 */
public final class ObjectMappers {

    /**
     * The constant DEFAULT_INSTANCE.
     */
    private static final ObjectMapper DEFAULT_INSTANCE = new ObjectMapper();
    /**
     * The constant PROTOBUF_DEFAULT_INSTANCE_METHOD_CACHE.
     */
    private static final ConcurrentMap<Class<? extends MessageOrBuilder>, Method>
            PROTOBUF_DEFAULT_INSTANCE_METHOD_CACHE = Maps.newConcurrentMap();

    static {
        DEFAULT_INSTANCE.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        DEFAULT_INSTANCE.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        DEFAULT_INSTANCE.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    }

    /**
     * Instantiates a new Object mappers.
     */
    private ObjectMappers() {
    }

    /**
     * Get object mapper.
     *
     * @return the object mapper
     */
    public static ObjectMapper get() {
        return DEFAULT_INSTANCE;
    }

    /**
     * Must read value t.
     *
     * @param <T>   the type parameter
     * @param json  the json
     * @param clazz the clazz
     * @return the t
     */
    public static <T> T mustReadValue(@Nullable final String json, final Class<T> clazz) {
        if (json == null) {
            return null;
        }
        try {
            return DEFAULT_INSTANCE.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Must read value t.
     *
     * @param <T>     the type parameter
     * @param json    the json
     * @param typeRef the type ref
     * @return the t
     */
    public static <T> T mustReadValue(@Nullable final String json, final TypeReference<T> typeRef) {
        if (json == null) {
            return null;
        }
        try {
            return DEFAULT_INSTANCE.readValue(json, typeRef);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Must read proto t.
     *
     * @param <T>   the type parameter
     * @param json  the json
     * @param clazz the clazz
     * @return the t
     */
    @SuppressWarnings("unchecked")
    public static <T extends Message> T mustReadProto(@Nullable final String json, final Class<T> clazz) {
        if (json == null) {
            return null;
        }
        try {
            Method method = PROTOBUF_DEFAULT_INSTANCE_METHOD_CACHE.get(clazz);
            if (method == null) {
                method = clazz.getMethod("getDefaultInstance");
                PROTOBUF_DEFAULT_INSTANCE_METHOD_CACHE.put(clazz, method);
            }
            Message.Builder b = ((T) method.invoke(null)).toBuilder();
            JsonFormat.parser().ignoringUnknownFields().merge(json, b);
            return (T) (b.build());
        } catch (IOException | SecurityException | ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Must write value string.
     *
     * @param o the o
     * @return the string
     */
    public static String mustWriteValue(@Nullable final Object o) {
        if (o == null) {
            return null;
        }
        try {
            if (o instanceof MessageOrBuilder) {
                return JsonFormat.printer().omittingInsignificantWhitespace()
                        .print((MessageOrBuilder) o);
            } else {
                return DEFAULT_INSTANCE.writeValueAsString(o);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Must write value pretty string.
     *
     * @param o the o
     * @return the string
     */
    public static String mustWriteValuePretty(@Nullable final Object o) {
        if (o == null) {
            return null;
        }
        try {
            if (o instanceof MessageOrBuilder) {
                return JsonFormat.printer().print((MessageOrBuilder) o);
            } else {
                return DEFAULT_INSTANCE.writerWithDefaultPrettyPrinter().writeValueAsString(o);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Must read tree json node.
     *
     * @param json the json
     * @return the json node
     */
    public static JsonNode mustReadTree(@Nullable final String json) {
        if (json == null) {
            return null;
        }
        try {
            return DEFAULT_INSTANCE.readTree(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
