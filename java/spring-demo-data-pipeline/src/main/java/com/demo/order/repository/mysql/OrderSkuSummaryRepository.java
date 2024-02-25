package com.demo.order.repository.mysql;

import com.demo.order.model.order.OrderSkuSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * The interface Order sku summary repository.
 */
@Repository
@Transactional
public interface OrderSkuSummaryRepository extends JpaRepository<OrderSkuSummary, UUID> {
}
