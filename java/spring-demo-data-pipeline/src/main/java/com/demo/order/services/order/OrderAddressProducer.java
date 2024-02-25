package com.demo.order.services.order;

import com.demo.order.model.protobuf.generated.OrderAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.io.IOException;

/**
 * The type Order address producer.
 */
@Service
public class OrderAddressProducer {
    /**
     * The Topic name.
     */
    @Value(value = "${OrderAddress.topic.name}")
    private String topicName;
    /**
     * The Partition number.
     */
    @Value(value = "${OrderAddress.partition.number}")
    private int partitionNumber;
    /**
     * The Kafka template.
     */
    @Autowired
    private KafkaTemplate<String, OrderAddress> kafkaTemplate;

    /**
     * Send message order address.
     *
     * @param orderAddress the order address
     * @return the order address
     * @throws IOException the io exception
     */
    public OrderAddress sendMessage(final OrderAddress orderAddress) throws IOException {
        ListenableFuture<SendResult<String, OrderAddress>> future = kafkaTemplate
                .send(topicName, orderAddress);
        future.addCallback(new ListenableFutureCallback<SendResult<String, OrderAddress>>() {
            @Override
            public void onSuccess(@NonNull final SendResult<String, OrderAddress> result) {
            }

            @Override
            public void onFailure(@NonNull final Throwable ex) {
            }
        });
        return orderAddress;
    }
}
