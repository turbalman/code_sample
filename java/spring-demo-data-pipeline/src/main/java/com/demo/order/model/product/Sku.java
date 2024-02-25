package com.demo.order.model.product;

import com.demo.order.model.AuditModel;
import com.demo.order.model.protobuf.generated.OrderSku;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

/**
 * The type Sku.
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sku extends AuditModel {
    /**
     * The Id.
     */
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private UUID id;

    /**
     * The Name.
     */
    @NotEmpty
    private String name;

    /**
     * The Description.
     */
    @NotEmpty
    private String description;

    /**
     * The Category.
     */
    @NotNull
    private OrderSku.SkuCategory category;
}
