package com.cm.cm.online.product.entity.skuSub;

import com.cm.cm.online.product.entity.product.ProductEntity;
import com.cm.cm.online.product.entity.skuMain.SkuMainEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_PRODUCT_SKU_SUB")
@EqualsAndHashCode(of = "productSkuSubVO")
public class ProductSkuSubEntity {
    @EmbeddedId
    ProductSkuSubVO productSkuSubVO;
    private int productSkuQuantity;


    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", updatable = false,insertable = false)
    private ProductEntity product;


    @OneToOne
    @JoinColumn(name="skuId", referencedColumnName = "skuId", updatable = false, insertable = false)
    private SkuSubEntity skuSub;


    public int getPrice(){
        return this.getSkuSub ().getSkuSalePrice () * this.getProductSkuQuantity ();
    }
}
