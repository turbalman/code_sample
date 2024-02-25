package com.demo.order.services.order;

import com.demo.order.model.order.OrderSummary;
import com.demo.order.model.protobuf.generated.Order;
import com.demo.order.repository.mysql.OrderSummaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * The type Order consumer.
 */
@Component
public class OrderConsumer {
    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    /**
     * The Order summary repository.
     */
    @Autowired
    private OrderSummaryRepository orderSummaryRepository;

    /**
     * On order registered.
     *
     * @param order the order
     */
    @Async
    @KafkaListener(topics = "${Order.topic.name}", groupId = "${Order.consumer.group_id}",
            containerFactory = "orderKafkaListenerContainerFactory",
            concurrency = "${Order.consumer.concurrency}")
    public void onOrderRegistered(final Order order) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registered OrderSku: {}", order);
        }
        orderSummaryRepository.save(new OrderSummary(order));
    }
}
