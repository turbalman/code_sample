package com.demo.order.repository.redis;

import com.demo.order.model.product.CachedSku;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * The interface Cached sku repository.
 */
@Repository
public interface CachedSkuRepository extends CrudRepository<CachedSku, UUID> {
}
