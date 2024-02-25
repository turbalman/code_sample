package com.demo.order.configuration;

import com.demo.order.model.protobuf.generated.Order;
import com.demo.order.model.protobuf.generated.OrderSku;
import com.demo.order.model.protobuf.generated.OrderStatistics;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Kafka container factory config.
 */
@EnableKafka
@Configuration
public class KafkaContainerFactoryConfig {
    /**
     * The Bootstrap address.
     */
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    /**
     * The Order consumer group id.
     */
    @Value(value = "${Order.consumer.group_id}")
    private String orderConsumerGroupId;

    /**
     * The Order sku consumer group id.
     */
    @Value(value = "${OrderSku.consumer.group_id}")
    private String orderSkuConsumerGroupId;


    /**
     * The Consumer order statistics group id.
     */
    @Value(value = "${OrderStatistics.consumer.group_id}")
    private String consumerOrderStatisticsGroupId;

//    @Value(value = "${kafka.maxPollInterval}")
//    private int maxPollInterval;
//
//    @Value(value = "${kafka.sessionTimeout}")
//    private int sessionTimeout;
//
//    @Value(value = "${kafka.maxPollRecords}")
//    private int maxPollRecords;
//
//    @Value(value = "${kafka.heartBeatInterval}")
//    private int heartBeatInterval;

    /**
     * Gets kafka protobuf deserializer config.
     *
     * @param groupId           the group id
     * @param protobufClassName the protobuf class name
     * @return the kafka protobuf deserializer config
     */
    private Map<String, Object> getKafkaProtobufDeserializerConfig(final String groupId,
                                                                   final String protobufClassName) {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaProtobufDeserializer.class);
        properties.put(KafkaProtobufDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://192.168.2.30:8081");
        properties.put(KafkaProtobufDeserializerConfig.SPECIFIC_PROTOBUF_VALUE_TYPE, protobufClassName);
        return properties;
    }

    /**
     * Order kafka listener container factory concurrent kafka listener container factory.
     *
     * @return the concurrent kafka listener container factory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Order> orderKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Order> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(
                getKafkaProtobufDeserializerConfig(orderConsumerGroupId, Order.class.getName()), new StringDeserializer(),
                new KafkaProtobufDeserializer()
        ));
        return factory;
    }

    /**
     * Order sku kafka listener container factory concurrent kafka listener container factory.
     *
     * @return the concurrent kafka listener container factory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderSku> orderSkuKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, OrderSku> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(
                getKafkaProtobufDeserializerConfig(orderSkuConsumerGroupId, OrderSku.class.getName()), new StringDeserializer(),
                new KafkaProtobufDeserializer()
        ));
        return factory;
    }

    /**
     * Gets flink protobuf consumer factory config.
     *
     * @param consumerGroupId the consumer group id
     * @return the flink protobuf consumer factory config
     */
    public Map<String, Object> getFlinkProtobufConsumerFactoryConfig(final String consumerGroupId) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, FlinkProtobufDeserializer.class);
        return props;
    }

    /**
     * Order statistics flink protobuf listener container factory concurrent kafka listener container factory.
     *
     * @return the concurrent kafka listener container factory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> orderStatisticsFlinkProtobufListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getFlinkProtobufConsumerFactoryConfig(
                consumerOrderStatisticsGroupId), new StringDeserializer(),
                new FlinkProtobufDeserializer(OrderStatistics.class)));
        return factory;
    }
}
