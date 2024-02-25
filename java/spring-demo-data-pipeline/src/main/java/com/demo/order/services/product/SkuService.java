package com.demo.order.services.product;

import com.demo.order.model.product.CachedSku;
import com.demo.order.model.product.Sku;
import com.demo.order.repository.mysql.SkuRepository;
import com.demo.order.repository.redis.CachedSkuRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * The type Sku service.
 */
@Service
public class SkuService {
    /**
     * The Cached sku repository.
     */
    @Autowired
    private CachedSkuRepository cachedSkuRepository;

    /**
     * The Sku repository.
     */
    @Autowired
    private SkuRepository skuRepository;


    /**
     * Upsert cached sku.
     *
     * @param sku the sku
     * @return the cached sku
     */
    public CachedSku upsert(final Sku sku) {
        if (sku == null) {
            throw new IllegalArgumentException("sku is invalid!");
        }
        return initializeCache(skuRepository.save(sku).getId());
    }

    /**
     * Fetch cached sku.
     *
     * @param id the id
     * @return the cached sku
     */
    public CachedSku fetch(final UUID id) {
        CachedSku cachedSku = cachedSkuRepository.findById(id).orElse(null);
        if (cachedSku != null) {
            return cachedSku;
        }
        return initializeCache(id);
    }

    /**
     * Initialize cache cached sku.
     *
     * @param id the id
     * @return the cached sku
     */
    private CachedSku initializeCache(final UUID id) {
        Sku sku = skuRepository.findById(id).orElse(null);
        if (sku == null) {
            throw new ObjectNotFoundException(id, "Sku");
        }
        return cachedSkuRepository.save(new CachedSku(sku));
    }
}
