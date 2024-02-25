package com.demo.order.serialization;

import com.demo.order.model.protobuf.generated.OrderAddress;
import lombok.RequiredArgsConstructor;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

/**
 * The type Order address deserialization schema.
 */
@Component
@RequiredArgsConstructor
public class OrderAddressDeserializationSchema implements DeserializationSchema<OrderAddress> {
    /**
     * The Flink protobuf bytes start.
     */
    @Value("${flink.protobuf.deserialize.bytes.start}")
    private int flinkProtobufBytesStart;

    /**
     * Deserialize order address.
     *
     * @param bytes the bytes
     * @return the order address
     * @throws IOException the io exception
     */
    @Override
    public OrderAddress deserialize(final byte[] bytes) throws IOException {
        return OrderAddress.parseFrom(Arrays.copyOfRange(bytes, flinkProtobufBytesStart, bytes.length));
    }

    /**
     * Is end of stream boolean.
     *
     * @param vehicle the vehicle
     * @return the boolean
     */
    @Override
    public boolean isEndOfStream(final OrderAddress vehicle) {
        return false;
    }

    /**
     * Gets produced type.
     *
     * @return the produced type
     */
    @Override
    public TypeInformation<OrderAddress> getProducedType() {
        return TypeInformation.of(OrderAddress.class);
    }
}
