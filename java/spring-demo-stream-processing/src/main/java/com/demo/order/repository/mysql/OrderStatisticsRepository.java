package com.demo.order.repository.mysql;

import com.demo.order.model.order.OrderStatisticsSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * The interface Order statistics repository.
 */
@Repository
@Transactional
public interface OrderStatisticsRepository extends JpaRepository<OrderStatisticsSummary, UUID> {
}
