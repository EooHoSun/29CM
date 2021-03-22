package com.cm.cm.online.product.entity.productSkuSub;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class ProductSkuSubVO implements Serializable {
    private long productId;
    private long skuId;
}
