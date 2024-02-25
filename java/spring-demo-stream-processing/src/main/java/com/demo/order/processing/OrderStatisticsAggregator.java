package com.demo.order.processing;

import com.demo.order.model.protobuf.generated.OrderAddress;
import com.demo.order.model.protobuf.generated.OrderStatistics;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * The type Order statistics aggregator.
 */
@Component
public class OrderStatisticsAggregator implements AggregateFunction<OrderAddress, OrderStatistics, OrderStatistics> {
    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderStatisticsAggregator.class);

    /**
     * Create accumulator order statistics.
     *
     * @return the order statistics
     */
    @Override
    public OrderStatistics createAccumulator() {
        return OrderStatistics.newBuilder().build();
    }

    /**
     * Add order statistics.
     *
     * @param order           the order
     * @param orderStatistics the order statistics
     * @return the order statistics
     */
    @Override
    public OrderStatistics add(final OrderAddress order, final OrderStatistics orderStatistics) {
        OrderStatistics.Builder orderStatisticsOrBuilder = orderStatistics.toBuilder();
        if (orderStatistics.getStartTimestamp() == 0 || order.getTimestamp() < orderStatistics.getStartTimestamp()) {
            orderStatisticsOrBuilder.setStartTimestamp(order.getTimestamp());
        }

        if (orderStatistics.getEndTimestamp() == 0 || order.getTimestamp() > orderStatistics.getEndTimestamp()) {
            orderStatisticsOrBuilder.setEndTimestamp(order.getTimestamp());
        }

        if (orderStatistics.getOrderCount() == 0) {
            orderStatisticsOrBuilder.setOrderCount(1);
        } else {
            orderStatisticsOrBuilder.setOrderCount(orderStatistics.getOrderCount() + 1);
        }

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("(" + order.getShippingAddress().getCountry()
                    + ", " + new Date(orderStatisticsOrBuilder.getStartTimestamp())
                    + ", " + new Date(orderStatisticsOrBuilder.getEndTimestamp())
                    + ")->" + orderStatisticsOrBuilder.getOrderCount());
        }

        return orderStatisticsOrBuilder.build();
    }

    /**
     * Gets result.
     *
     * @param orderStatistics the order statistics
     * @return the result
     */
    @Override
    public OrderStatistics getResult(final OrderStatistics orderStatistics) {
        return orderStatistics;
    }

    /**
     * Merge order statistics.
     *
     * @param orderStatistics the order statistics
     * @param accumulator     the accumulator
     * @return the order statistics
     */
    @Override
    public OrderStatistics merge(final OrderStatistics orderStatistics, final OrderStatistics accumulator) {
        return OrderStatistics.newBuilder()
                .setStartTimestamp(Long.min(orderStatistics.getStartTimestamp(), accumulator.getStartTimestamp()))
                .setEndTimestamp(Long.max(orderStatistics.getEndTimestamp(), accumulator.getEndTimestamp()))
                .setOrderCount(orderStatistics.getOrderCount() + accumulator.getOrderCount())
                .build();
    }
}
