package com.demo.order.converter;

import com.demo.order.model.protobuf.generated.OrderSku;
import com.demo.order.util.ProtobufUtil;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

/**
 * The type Order sku converter.
 */
@Converter
public class OrderSkuConverter implements
        AttributeConverter<OrderSku, String> {
    /**
     * Convert to database column string.
     *
     * @param order the order
     * @return the string
     */
    @Override
    public String convertToDatabaseColumn(final OrderSku order) {
        try {
            return ProtobufUtil.toJson(order);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert to entity attribute order sku.
     *
     * @param jsonStr the json str
     * @return the order sku
     */
    @Override
    public OrderSku convertToEntityAttribute(final String jsonStr) {
        try {
            return ProtobufUtil.fromJson(jsonStr, OrderSku.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}