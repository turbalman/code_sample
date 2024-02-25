package com.demo.order.model.product;

import com.demo.order.model.protobuf.generated.OrderSku;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

/**
 * The type Cached sku.
 */
@Data
@NoArgsConstructor
@RedisHash("CachedDownload")
public class CachedSku {
    /**
     * The Id.
     */
    private UUID id;

    /**
     * The Name.
     */
    @NotEmpty
    private String name;

    /**
     * The Category.
     */
    @NotNull
    private OrderSku.SkuCategory category;

    /**
     * Instantiates a new Cached sku.
     *
     * @param download the download
     */
    public CachedSku(final Sku download) {
        this.id = download.getId();
        this.name = download.getName();
        this.category = download.getCategory();
    }
}
