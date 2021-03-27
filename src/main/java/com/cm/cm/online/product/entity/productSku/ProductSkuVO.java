package com.cm.cm.online.product.entity.productSku;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class ProductSkuVO implements Serializable {
    private long productId;
    private long skuId;
}
