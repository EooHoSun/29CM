package com.cm.cm.online.product.entity.skuMain;

import com.cm.cm.online.product.dto.sku.SkuMainDTO;
import com.cm.cm.online.product.entity.origin.OriginEntity;
import com.cm.cm.online.product.entity.product.ProductEntity;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

/**
 * 메인 단품 table(entity)
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_SKU_MAIN")
@EqualsAndHashCode(of = "skuId")
public class SkuMainEntity {
    @Id
    private String skuId;
    private int skuSalePrice;
    private int skuPurchasePrice;
    private String skuName;
    private String productId;
    private String originCd;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", insertable = false, updatable = false)
    private ProductEntity product;


    @ManyToOne
    @JoinColumn(name = "originCd", referencedColumnName = "originCd", insertable = false, updatable = false)
    private OriginEntity origin;

    public static SkuMainEntity newInstance(SkuMainDTO dto){
        return SkuMainEntity.builder ()
                .skuId ( UUID.randomUUID ().toString () )
                .skuName ( dto.getSkuName ( ) )
                .skuSalePrice ( dto.getSkuSalePrice () )
                .skuPurchasePrice ( dto.getSkuPurchasePrice () )
                .build ();
    }

}
