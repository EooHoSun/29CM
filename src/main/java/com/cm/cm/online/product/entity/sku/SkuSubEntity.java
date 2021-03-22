package com.cm.cm.online.product.entity.sku;

import com.cm.cm.online.product.entity.origin.OriginEntity;
import com.cm.cm.online.product.entity.product.ProductEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_SKU_SUB")
@EqualsAndHashCode(of = "skuId")
public class SkuSubEntity {
    @Id
    private String skuId;
    private int skuSalePrice;
    private int skuPurchasePrice;
    private String skuName;
    private String productId;
    private String originCd;

    @ManyToOne
    @JoinColumn(name = "originCd", referencedColumnName = "originCd", insertable = false, updatable = false)
    private OriginEntity origin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "productId", insertable = false, updatable = false)
    private ProductEntity product;

}
