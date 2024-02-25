package com.demo.order.converter;

import com.demo.order.model.protobuf.generated.Order;
import com.demo.order.util.ProtobufUtil;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

/**
 * The type Order converter.
 */
@Converter
public class OrderConverter implements
        AttributeConverter<Order, String> {
    /**
     * Convert to database column string.
     *
     * @param order the order
     * @return the string
     */
    @Override
    public String convertToDatabaseColumn(final Order order) {
        try {
            return ProtobufUtil.toJson(order);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert to entity attribute order.
     *
     * @param jsonStr the json str
     * @return the order
     */
    @Override
    public Order convertToEntityAttribute(final String jsonStr) {
        try {
            return ProtobufUtil.fromJson(jsonStr, Order.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}