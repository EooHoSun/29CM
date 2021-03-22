package com.cm.cm.online.product.entity.skuMain;

import com.cm.cm.online.product.entity.product.ProductEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_PRODUCT_SKU_MAIN")
@EqualsAndHashCode(of = "productSkuMainVO")
public class ProductSkuMainEntity {
    @EmbeddedId
    private ProductSkuMainVO productSkuMainVO;
    private int productSkuQuantity;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", insertable = false, updatable = false)
    private ProductEntity product;

    @OneToOne
    @JoinColumn(name="skuId", referencedColumnName = "skuId", updatable = false, insertable = false)
    private SkuMainEntity skuMain;

    public int getPrice(){
        return this.getSkuMain ().getSkuSalePrice () * this.getProductSkuQuantity ();
    }

}
