package com.demo.order.services.order;

import com.demo.order.model.protobuf.generated.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * The type Order producer.
 */
@Service
public class OrderProducer {
    /**
     * The Topic name.
     */
    @Value(value = "${Order.topic.name}")
    private String topicName;
    /**
     * The Partition number.
     */
    @Value(value = "${Order.partition.number}")
    private int partitionNumber;
    /**
     * The Kafka template.
     */
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    /**
     * Send message order.
     *
     * @param order the order
     * @return the order
     */
    public Order sendMessage(final Order order) {
        ListenableFuture<SendResult<String, Order>> future = kafkaTemplate.send(topicName, order);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Order>>() {
            @Override
            public void onSuccess(@NonNull final SendResult<String, Order> result) {
            }

            @Override
            public void onFailure(@NonNull final Throwable ex) {
            }
        });
        return order;
    }
}
