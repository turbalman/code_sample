package com.demo.order.processing;

import com.demo.order.model.protobuf.generated.OrderAddress;
import org.apache.flink.streaming.api.functions.AssignerWithPunctuatedWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;

import javax.annotation.Nullable;

/**
 * The type Input message timestamp assigner.
 */
public class InputMessageTimestampAssigner implements AssignerWithPunctuatedWatermarks<OrderAddress> {

    /**
     * Extract timestamp long.
     *
     * @param element                  the element
     * @param previousElementTimestamp the previous element timestamp
     * @return the long
     */
    @Override
    public long extractTimestamp(final OrderAddress element, final long previousElementTimestamp) {
        return element.getTimestamp();
    }

    /**
     * Check and get next watermark watermark.
     *
     * @param lastElement        the last element
     * @param extractedTimestamp the extracted timestamp
     * @return the watermark
     */
    @Nullable
    @Override
    public Watermark checkAndGetNextWatermark(final OrderAddress lastElement, final long extractedTimestamp) {
        return new Watermark(extractedTimestamp);
    }
}
