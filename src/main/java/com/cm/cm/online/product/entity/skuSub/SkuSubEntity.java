package com.cm.cm.online.product.entity.skuSub;

import com.cm.cm.online.product.entity.origin.OriginEntity;
import com.cm.cm.online.product.entity.product.ProductEntity;
import lombok.*;

import javax.persistence.*;

/**
 * 서브 단품 table(entity)
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_SKU_SUB")
@EqualsAndHashCode(of = "skuId")
public class SkuSubEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long skuId;
    private int skuSalePrice;
    private int skuPurchasePrice;
    private String skuName;
    private String originCd;


    @ManyToOne
    @JoinColumn(name = "originCd", referencedColumnName = "originCd", insertable = false, updatable = false)
    private OriginEntity origin;


}
