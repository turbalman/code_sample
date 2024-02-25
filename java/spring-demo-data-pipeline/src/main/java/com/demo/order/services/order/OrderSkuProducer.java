package com.demo.order.services.order;


import com.demo.order.model.protobuf.generated.OrderSku;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * The type Order sku producer.
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class OrderSkuProducer {
    /**
     * The Topic name.
     */
    @Value(value = "${OrderSku.topic.name}")
    private String topicName;
    /**
     * The Partition number.
     */
    @Value(value = "${OrderSku.partition.number}")
    private int partitionNumber;
    /**
     * The Kafka template.
     */
    @Autowired
    private KafkaTemplate<String, OrderSku> kafkaTemplate;

    /**
     * Send message.
     *
     * @param orderSku the order sku
     */
    public void sendMessage(final OrderSku orderSku) {
        ListenableFuture<SendResult<String, OrderSku>> future = kafkaTemplate.send(topicName, orderSku);

        future.addCallback(new ListenableFutureCallback<SendResult<String, OrderSku>>() {
            @Override
            public void onSuccess(@NonNull final SendResult<String, OrderSku> result) {
            }

            @Override
            public void onFailure(@NonNull final Throwable ex) {
            }
        });
    }
}
