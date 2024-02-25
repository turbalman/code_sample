package com.demo.order.model.order;

import com.demo.order.converter.OrderConverter;
import com.demo.order.converter.UuidListTypeConverter;
import com.demo.order.model.AuditModel;
import com.demo.order.model.protobuf.generated.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The type Order summary.
 */
@Getter
@Setter
@Entity
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
@NoArgsConstructor
public class OrderSummary extends AuditModel {
    /**
     * The Id.
     */
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private UUID id;

    /**
     * The Status.
     */
    @NotNull
    private Order.Status status;

    /**
     * The User id.
     */
    @NotNull
    @Type(type = "uuid-char")
    private UUID userId;

    /**
     * The Sku ids.
     */
    @Convert(converter = UuidListTypeConverter.class)
    @Column(columnDefinition = "json")
    private List<UUID> skuIds;

    /**
     * The Ip.
     */
    @NotNull
    private String ip;

    /**
     * The Submitted order.
     */
    @Convert(converter = OrderConverter.class)
    @Column(columnDefinition = "json")
    private Order submittedOrder;

    /**
     * The Date.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    /**
     * Instantiates a new Order summary.
     *
     * @param order the order
     */
    public OrderSummary(final Order order) {
        id = UUID.randomUUID();
        status = Order.Status.CREATED;
        userId = UUID.fromString(order.getUserId());
        skuIds = order.getSkuIdsList().stream().map(UUID::fromString).collect(Collectors.toList());
        ip = order.getIp();
        date = new Date(new Timestamp(order.getTimestamp()).getTime());
        this.submittedOrder = order;
    }
}
