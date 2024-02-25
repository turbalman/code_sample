package com.demo.order.services.order;


import com.demo.order.model.product.CachedSku;
import com.demo.order.model.product.Sku;
import com.demo.order.model.protobuf.generated.Order;
import com.demo.order.model.protobuf.generated.OrderSku;
import com.demo.order.services.product.SkuService;
import com.demo.order.util.OrderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

/**
 * The type Order generator.
 */
@Service
@RequiredArgsConstructor
public class OrderGenerator {
    /**
     * The Order sku producer.
     */
    @Autowired
    private OrderSkuProducer orderSkuProducer;

    /**
     * The Order producer.
     */
    @Autowired
    private OrderProducer orderProducer;

    /**
     * The Order address producer.
     */
    @Autowired
    private OrderAddressProducer orderAddressProducer;

    /**
     * The Sku service.
     */
    @Autowired
    private SkuService skuService;

    /**
     * Generate.
     *
     * @throws IOException the io exception
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    @Scheduled(fixedDelay = 1000)
    public void generate() throws IOException {
        Sku sku1 = OrderUtil.fakeSku();
        Sku sku2 = OrderUtil.fakeSku();
        skuService.upsert(sku1);
        skuService.upsert(sku2);
        Order order = OrderUtil.fakeOrder(Arrays.asList(sku1.getId().toString(), sku2.getId().toString()));
        orderProducer.sendMessage(order);
        orderAddressProducer.sendMessage(OrderUtil.getOrderAddress(order));
        for (int i = 0; i < order.getSkuIdsCount(); i++) {
            OrderSku orderSku = OrderUtil.getOrderSku(order, i);
            CachedSku sku = skuService.fetch(UUID.fromString(orderSku.getSkuId()));
            orderSkuProducer.sendMessage(orderSku.toBuilder()
                    .setSkuCategory(sku.getCategory())
                    .setName(sku.getName())
                    .build());
        }
    }
}
