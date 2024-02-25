package com.demo.order.services;


import com.demo.order.model.protobuf.generated.OrderAddress;
import com.demo.order.model.protobuf.generated.OrderStatistics;
import com.demo.order.processing.InputMessageTimestampAssigner;
import com.demo.order.processing.OrderStatisticsAggregator;
import com.demo.order.serialization.OrderAddressDeserializationSchema;
import com.demo.order.serialization.OrderStatisticsSerializationSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * The type Processing service.
 */
@Service
@Log4j2
@RequiredArgsConstructor
@PropertySource({"classpath:application.properties"})
public class ProcessingService {
    /**
     * The Order address deserialization schema.
     */
    private final OrderAddressDeserializationSchema orderAddressDeserializationSchema;
    /**
     * The Order statistics serialization schema.
     */
    private final OrderStatisticsSerializationSchema orderStatisticsSerializationSchema;
    /**
     * The Kafka address.
     */
    @Value("${kafka.bootstrapAddress}")
    private String kafkaAddress;
    /**
     * The Kafka group id order address.
     */
    @Value("${OrderAddress.consumer.group_id}")
    private String kafkaGroupIdOrderAddress;
    /**
     * The Topic order address.
     */
    @Value(value = "${OrderAddress.topic.name}")
    private String topicOrderAddress;
    /**
     * The Topic order statistics.
     */
    @Value(value = "${OrderStatistics.topic.name}")
    private String topicOrderStatistics;

    /**
     * The Order statistics monitoring window.
     */
    @Value(value = "${OrderStatistics.monitoring.window}")
    private long orderStatisticsMonitoringWindow;

    /**
     * Start flink stream processing.
     */
    @PostConstruct
    public void startFlinkStreamProcessing() throws Exception {
        processVehicleStatistic();
    }

    /**
     * Process vehicle statistic.
     *
     * @throws Exception the exception
     */
    public void processVehicleStatistic() throws Exception {
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        environment.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        FlinkKafkaConsumer<OrderAddress> flinkKafkaConsumer = createInputMessageConsumer(topicOrderAddress,
                kafkaAddress,
                kafkaGroupIdOrderAddress);
        flinkKafkaConsumer.setStartFromEarliest();
        flinkKafkaConsumer.assignTimestampsAndWatermarks(new InputMessageTimestampAssigner());
        DataStream<OrderAddress> inputMessagesStream = environment.addSource(flinkKafkaConsumer);
        inputMessagesStream
                .timeWindowAll(Time.seconds(orderStatisticsMonitoringWindow))
                .aggregate(new OrderStatisticsAggregator())
                .addSink(new FlinkKafkaProducer<OrderStatistics>(kafkaAddress,
                        topicOrderStatistics,
                        orderStatisticsSerializationSchema));

        environment.execute();
    }

    /**
     * Create input message consumer flink kafka consumer.
     *
     * @param topic   the topic
     * @param address the kafka address
     * @param group   the kafka group
     * @return the flink kafka consumer
     */
    public FlinkKafkaConsumer<OrderAddress> createInputMessageConsumer(final String topic,
                                                                       final String address,
                                                                       final String group) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", address);
        properties.setProperty("group.id", group);
        FlinkKafkaConsumer<OrderAddress> consumer = new FlinkKafkaConsumer<OrderAddress>(topic,
                orderAddressDeserializationSchema,
                properties);

        return consumer;
    }
}
