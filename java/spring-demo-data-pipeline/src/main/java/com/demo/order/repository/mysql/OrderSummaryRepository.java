package com.demo.order.repository.mysql;

import com.demo.order.model.order.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * The interface Order summary repository.
 */
@Repository
@Transactional
public interface OrderSummaryRepository extends JpaRepository<OrderSummary, UUID> {
}
