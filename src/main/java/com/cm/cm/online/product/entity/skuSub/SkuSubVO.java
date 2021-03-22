package com.cm.cm.online.product.entity.skuSub;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class SkuSubVO implements Serializable {

    private String skuId;
    private String productId;
}
