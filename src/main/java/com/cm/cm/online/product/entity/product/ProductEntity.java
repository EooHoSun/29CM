package com.cm.cm.online.product.entity.product;

import com.cm.cm.online.BaseEntity;
import com.cm.cm.online.product.dto.product.ProductDTO;
import com.cm.cm.online.product.entity.productSku.ProductSkuEntity;
import com.cm.cm.online.product.entity.sku.SkuMainEntity;
import com.cm.cm.online.product.entity.sku.SkuSubEntity;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 상품 table(entity)
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "PRODUCTS")
@EqualsAndHashCode(of = "id")
public class ProductEntity  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String contents;
    private String name;
    private int quantity;



    @OneToMany
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private List<ProductSkuEntity> skuList = new ArrayList<> (  );

    public int getPrice(){
        return this.getSkuMainPrice() + this.getSkuSubPrice ();
    }

    private int getSkuMainPrice(){
        return this.getSkuList ().stream ().filter ( e -> e.getSku () instanceof SkuMainEntity ).mapToInt ( ProductSkuEntity::getPrice ).sum();
    }
    private int getSkuSubPrice(){
        return this.getSkuList ().stream ().filter ( e -> e.getSku () instanceof SkuSubEntity ).mapToInt ( ProductSkuEntity::getPrice ).sum();
    }

    public static ProductEntity newInstance(@NotNull ProductDTO dto){
        return ProductEntity.builder ()
                .contents ( dto.getContents () )
                .name ( dto.getName () )
                .quantity ( 100 )
                .build ();
    }

    public boolean saleable(){
        return this.getQuantity () > 0;
    }
}
