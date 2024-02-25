package com.demo.order.serialization;

import com.demo.order.model.protobuf.generated.OrderStatistics;
import com.demo.order.util.ProtobufUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * The type Order statistics serialization schema.
 */
@Component
@RequiredArgsConstructor
@Log4j2
public class OrderStatisticsSerializationSchema implements SerializationSchema<OrderStatistics> {
    /**
     * Serialize byte [ ].
     *
     * @param orderStatistics the order statistics
     * @return the byte [ ]
     */
    @Override
    public byte[] serialize(final OrderStatistics orderStatistics) {
        try {
            return ProtobufUtil.toJson(orderStatistics).getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}