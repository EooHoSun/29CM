package com.cm.cm.online.product.entity.productSku;

import com.cm.cm.online.product.entity.product.ProductEntity;
import com.cm.cm.online.product.entity.sku.SkuEntity;
import com.cm.cm.online.product.entity.sku.SkuSubEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "PRODUCTS_SKUS")
public class ProductSkuEntity {

    @EmbeddedId
    ProductSkuVO productSkuVO;
    private int quantity;

    @OneToOne
    @JoinColumn(name="skuId", referencedColumnName = "id", updatable = false, insertable = false)
    private SkuEntity sku;

    public int getPrice(){
        return this.getSku ().getSaleprice () * this.getQuantity ();
    }
}
