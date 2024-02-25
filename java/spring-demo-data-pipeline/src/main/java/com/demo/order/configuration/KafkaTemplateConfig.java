package com.demo.order.configuration;

import com.demo.order.model.protobuf.generated.Order;
import com.demo.order.model.protobuf.generated.OrderAddress;
import com.demo.order.model.protobuf.generated.OrderSku;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Kafka template config.
 */
@Configuration
public class KafkaTemplateConfig {
    /**
     * The Bootstrap address.
     */
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    /**
     * Order address kafka template kafka template.
     *
     * @return the kafka template
     */
    @Bean
    public KafkaTemplate<String, OrderAddress> orderAddressKafkaTemplate() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaProtobufSerializer.class);
        configProps.put(KafkaProtobufSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://192.168.2.30:8081");
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(configProps));
    }

    /**
     * Order kafka template kafka template.
     *
     * @return the kafka template
     */
    @Bean
    public KafkaTemplate<String, Order> orderKafkaTemplate() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaProtobufSerializer.class);
        configProps.put(KafkaProtobufSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://192.168.2.30:8081");
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(configProps));
    }

    /**
     * Order sku kafka template kafka template.
     *
     * @return the kafka template
     */
    @Bean
    public KafkaTemplate<String, OrderSku> orderSkuKafkaTemplate() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaProtobufSerializer.class);
        configProps.put(KafkaProtobufSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://192.168.2.30:8081");
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(configProps));
    }
}
