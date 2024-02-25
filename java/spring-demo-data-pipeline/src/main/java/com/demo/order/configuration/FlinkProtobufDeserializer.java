package com.demo.order.configuration;

import com.demo.order.util.ProtobufUtil;
import com.google.protobuf.Message;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * The type Flink protobuf deserializer.
 *
 * @param <T> the type parameter
 */
public class FlinkProtobufDeserializer<T extends Message> implements Deserializer<T> {
    /**
     * The Encoding.
     */
    private final String encoding;
    /**
     * The Clazz.
     */
    private final Class<T> clazz;


    /**
     * Instantiates a new Flink protobuf deserializer.
     *
     * @param clazz0 the clazz 0
     */
    public FlinkProtobufDeserializer(final Class<T> clazz0) {
        this.encoding = StandardCharsets.UTF_8.name();
        this.clazz = clazz0;
    }


    /**
     * Deserialize t.
     *
     * @param topic the topic
     * @param data  the data
     * @return the t
     */
    public T deserialize(final String topic, final byte[] data) {
        try {
            return ProtobufUtil.fromJson(new String(data, this.encoding), this.clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
