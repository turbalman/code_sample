package com.demo.order.converter;

import com.demo.order.model.protobuf.generated.OrderStatistics;
import com.demo.order.util.ProtobufUtil;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

/**
 * The type Order statistics converter.
 */
@Converter
public class OrderStatisticsConverter implements
        AttributeConverter<OrderStatistics, String> {
    /**
     * Convert to database column string.
     *
     * @param order the order
     * @return the string
     */
    @Override
    public String convertToDatabaseColumn(final OrderStatistics order) {
        try {
            return ProtobufUtil.toJson(order);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert to entity attribute order statistics.
     *
     * @param jsonStr the json str
     * @return the order statistics
     */
    @Override
    public OrderStatistics convertToEntityAttribute(final String jsonStr) {
        try {
            return ProtobufUtil.fromJson(jsonStr, OrderStatistics.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}