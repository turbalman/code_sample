package com.demo.order.converter;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type Uuid list type converter.
 */
@Converter
public class UuidListTypeConverter implements
        AttributeConverter<List<UUID>, String> {
    /**
     * Convert to database column string.
     *
     * @param ids the ids
     * @return the string
     */
    @Override
    public String convertToDatabaseColumn(final List<UUID> ids) {
        return new Gson().toJson(ids);
    }

    /**
     * Convert to entity attribute list.
     *
     * @param ids the ids
     * @return the list
     */
    @Override
    public List<UUID> convertToEntityAttribute(final String ids) {
        return new Gson().fromJson(ids, new TypeToken<ArrayList<UUID>>() {
        }.getType());
    }
}