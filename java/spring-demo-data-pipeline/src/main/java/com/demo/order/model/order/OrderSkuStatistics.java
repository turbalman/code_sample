package com.demo.order.model.order;

import com.demo.order.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * The type Order sku statistics.
 */
@Getter
@Setter
@Entity
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class OrderSkuStatistics extends AuditModel {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * The Start timestamp.
     */
    private Long startTimestamp;

    /**
     * The End timestamp.
     */
    private Long endTimestamp;

    /**
     * The Sku id.
     */
    private UUID skuId;
}