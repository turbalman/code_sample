package com.demo.order.repository.mysql;

import com.demo.order.model.product.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * The interface Sku repository.
 */
@Repository
public interface SkuRepository extends JpaRepository<Sku, UUID> {
}
