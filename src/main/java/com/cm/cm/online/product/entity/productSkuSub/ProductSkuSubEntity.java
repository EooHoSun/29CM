package com.cm.cm.online.product.entity.productSkuSub;

import com.cm.cm.online.product.entity.product.ProductEntity;
import com.cm.cm.online.product.entity.skuSub.SkuSubEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "PRODUCTS_SKUSUB")
@EqualsAndHashCode(of = "productSkuSubVO")
public class ProductSkuSubEntity {
    @EmbeddedId
    ProductSkuSubVO productSkuSubVO;
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id", updatable = false,insertable = false)
    private ProductEntity product;


    @OneToOne
    @JoinColumn(name="skusubId", referencedColumnName = "id", updatable = false, insertable = false)
    private SkuSubEntity skuSub;


    public int getPrice(){
        return this.getSkuSub ().getSaleprice () * this.getQuantity ();
    }
}
