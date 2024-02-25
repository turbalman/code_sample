package com.demo.order.services.order;

import com.demo.order.model.order.OrderSkuSummary;
import com.demo.order.model.protobuf.generated.OrderSku;
import com.demo.order.repository.mysql.OrderSkuSummaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * The type Order sku consumer.
 */
@Component
public class OrderSkuConsumer {
    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderSkuConsumer.class);
    /**
     * The Order sku summary repository.
     */
    @Autowired
    private OrderSkuSummaryRepository orderSkuSummaryRepository;

    /**
     * On order sku registered.
     *
     * @param orderSku the order sku
     */
    @Async
    @KafkaListener(topics = "${OrderSku.topic.name}", groupId = "${OrderSku.consumer.group_id}",
            containerFactory = "orderSkuKafkaListenerContainerFactory",
            concurrency = "${OrderSku.consumer.concurrency}")
    public void onOrderSkuRegistered(final OrderSku orderSku) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registered OrderSku: {}", orderSku);
        }
        orderSkuSummaryRepository.save(new OrderSkuSummary(orderSku));
    }
}
