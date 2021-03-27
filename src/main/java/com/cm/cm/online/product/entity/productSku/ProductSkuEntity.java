package com.cm.cm.online.product.entity.productSku;

import com.cm.cm.online.BaseEntity;
import com.cm.cm.online.product.entity.sku.SkuEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "PRODUCTS_SKUS")
public class ProductSkuEntity  extends BaseEntity {

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
