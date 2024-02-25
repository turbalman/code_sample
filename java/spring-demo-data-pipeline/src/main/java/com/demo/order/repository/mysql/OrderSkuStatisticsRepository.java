package com.demo.order.repository.mysql;

import com.demo.order.model.order.OrderSkuStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * The interface Order sku statistics repository.
 */
@Repository
@Transactional
public interface OrderSkuStatisticsRepository extends JpaRepository<OrderSkuStatistics, UUID> {
}
