package com.demo.order.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Kafka topic config.
 */
@Configuration
public class KafkaTopicConfig {
    /**
     * The Bootstrap address.
     */
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    /**
     * The Order topic name.
     */
    @Value(value = "${Order.topic.name}")
    private String orderTopicName;

    /**
     * The Order topic number.
     */
    @Value(value = "${Order.partition.number}")
    private int orderTopicNumber;

    /**
     * The Order sku topic name.
     */
    @Value(value = "${OrderSku.topic.name}")
    private String orderSkuTopicName;

    /**
     * The Order sku topic number.
     */
    @Value(value = "${OrderSku.partition.number}")
    private int orderSkuTopicNumber;


    /**
     * The Order address topic name.
     */
    @Value(value = "${OrderAddress.topic.name}")
    private String orderAddressTopicName;

    /**
     * The Order address topic number.
     */
    @Value(value = "${OrderAddress.partition.number}")
    private int orderAddressTopicNumber;

    /**
     * The Order statistics topic name.
     */
    @Value(value = "${OrderStatistics.topic.name}")
    private String orderStatisticsTopicName;

    /**
     * The Order statistics topic number.
     */
    @Value(value = "${OrderStatistics.partition.number}")
    private int orderStatisticsTopicNumber;

    /**
     * Kafka admin kafka admin.
     *
     * @return the kafka admin
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    /**
     * Order address topic new topic.
     *
     * @return the new topic
     */
    @Bean
    public NewTopic orderAddressTopic() {
        NewTopic newTopic = new NewTopic(orderAddressTopicName, orderAddressTopicNumber, (short) 1);
        Map<String, String> configs = new HashMap<>();
        configs.put("max.message.bytes", "20971520");
        newTopic.configs(configs);
        return newTopic;
    }

    /**
     * Order statistics topic new topic.
     *
     * @return the new topic
     */
    @Bean
    public NewTopic orderStatisticsTopic() {
        NewTopic newTopic = new NewTopic(orderStatisticsTopicName, orderStatisticsTopicNumber, (short) 1);
        Map<String, String> configs = new HashMap<>();
        configs.put("max.message.bytes", "20971520");
        newTopic.configs(configs);
        return newTopic;
    }

    /**
     * Order topic new topic.
     *
     * @return the new topic
     */
    @Bean
    public NewTopic orderTopic() {
        NewTopic newTopic = new NewTopic(orderTopicName, orderTopicNumber, (short) 1);
        Map<String, String> configs = new HashMap<>();
        configs.put("max.message.bytes", "20971520");
        newTopic.configs(configs);
        return newTopic;
    }

    /**
     * Order sku topic new topic.
     *
     * @return the new topic
     */
    @Bean
    public NewTopic orderSkuTopic() {
        NewTopic newTopic = new NewTopic(orderSkuTopicName, orderSkuTopicNumber, (short) 1);
        Map<String, String> configs = new HashMap<>();
        configs.put("max.message.bytes", "20971520");
        newTopic.configs(configs);
        return newTopic;
    }
}
