package com.demo.order.model.order;

import com.demo.order.converter.OrderSkuConverter;
import com.demo.order.model.AuditModel;
import com.demo.order.model.protobuf.generated.OrderSku;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * The type Order sku summary.
 */
@Getter
@Setter
@Entity
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderSkuSummary extends AuditModel {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private UUID id;

    /**
     * The Order id.
     */
    @NotNull
    @Type(type = "uuid-char")
    private UUID orderId;

    /**
     * The User id.
     */
    @NotNull
    @Type(type = "uuid-char")
    private UUID userId;

    /**
     * The Sku id.
     */
    @NotNull
    @Type(type = "uuid-char")
    private UUID skuId;

    /**
     * The Submitted order sku.
     */
    @Convert(converter = OrderSkuConverter.class)
    @Column(columnDefinition = "json")
    private OrderSku submittedOrderSku;


    /**
     * Instantiates a new Order sku summary.
     *
     * @param orderSku the order sku
     */
    public OrderSkuSummary(final OrderSku orderSku) {
        orderId = UUID.fromString(orderSku.getOrderId());
        userId = UUID.fromString(orderSku.getUserId());
        skuId = UUID.fromString(orderSku.getSkuId());
        submittedOrderSku = orderSku;
    }
}
