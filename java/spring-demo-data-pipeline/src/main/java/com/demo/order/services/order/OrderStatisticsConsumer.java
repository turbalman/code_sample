package com.demo.order.services.order;


import com.demo.order.model.order.OrderStatisticsSummary;
import com.demo.order.model.protobuf.generated.OrderStatistics;
import com.demo.order.repository.mysql.OrderStatisticsRepository;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * The type Order statistics consumer.
 */
@Component
@Log4j2
public class OrderStatisticsConsumer {
    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderStatisticsConsumer.class);


    /**
     * The Order statistics repository.
     */
    @Autowired
    private OrderStatisticsRepository orderStatisticsRepository;

    /**
     * On pojo log registered.
     *
     * @param orderStatistics the order statistics
     * @throws IOException the io exception
     */
    @Async
    @KafkaListener(topics = "${OrderStatistics.topic.name}", groupId = "${OrderStatistics.consumer.group_id}",
            containerFactory = "orderStatisticsFlinkProtobufListenerContainerFactory",
            concurrency = "${OrderStatistics.consumer.concurrency}")
    public void onPojoLogRegistered(final OrderStatistics orderStatistics) throws IOException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registered OrderStatistics: {}", orderStatistics);
        }
        orderStatisticsRepository.save(new OrderStatisticsSummary(orderStatistics));
    }
}
