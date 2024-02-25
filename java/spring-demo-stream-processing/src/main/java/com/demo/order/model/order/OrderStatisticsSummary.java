package com.demo.order.model.order;

import com.demo.order.converter.OrderStatisticsConverter;
import com.demo.order.model.AuditModel;
import com.demo.order.model.protobuf.generated.OrderStatistics;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * The type Order statistics summary.
 */
@Getter
@Setter
@Entity
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatisticsSummary extends AuditModel {
    /**
     * The Order statistics.
     */
    @Convert(converter = OrderStatisticsConverter.class)
    @Column(columnDefinition = "json")
    private OrderStatistics orderStatistics;
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private UUID id;

    /**
     * Instantiates a new Order statistics summary.
     *
     * @param orderStatistics0 the order statistics 0
     */
    public OrderStatisticsSummary(final OrderStatistics orderStatistics0) {
        this.orderStatistics = orderStatistics0;
    }
}