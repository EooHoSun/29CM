package com.cm.cm.online.product.entity.productSkuMain;

import com.cm.cm.online.product.entity.product.ProductEntity;
import com.cm.cm.online.product.entity.skuMain.SkuMainEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "PRODUCTS_SKUMAIN")
@EqualsAndHashCode(of = "productSkuMainVO")
public class ProductSkuMainEntity {
    @EmbeddedId
    private ProductSkuMainVO productSkuMainVO;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductEntity product;

    @OneToOne
    @JoinColumn(name="skumainId", referencedColumnName = "id", updatable = false, insertable = false)
    private SkuMainEntity skuMain;

    public int getPrice(){
        return this.getSkuMain ().getSaleprice () * this.getQuantity ();
    }

}
