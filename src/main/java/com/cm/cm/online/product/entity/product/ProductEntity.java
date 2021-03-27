package com.cm.cm.online.product.entity.product;

import com.cm.cm.online.product.dto.product.ProductDTO;
import com.cm.cm.online.product.entity.productSku.ProductSkuEntity;
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
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String contents;
    private String name;
    private int quantity;



    @OneToMany
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private List<ProductSkuEntity> skuList = new ArrayList<> (  );

//
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "product")
//    private ProductSkuMainEntity skuMain;
//
//
//
//    // N + 1 문제 및 속도 성능 저하 해결을 위한 지연로딩, subselect, batch size 설정
//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
//    @BatchSize ( size = 100)
//    @Fetch ( FetchMode.SUBSELECT )
//    private Set<ProductSkuSubEntity> skuSubList = new LinkedHashSet<>();
//
//
    public int getPrice(){
        return this.getSkuList ().stream ().mapToInt ( ProductSkuEntity::getPrice ).sum ();
    }

    public static ProductEntity newInstance(ProductDTO dto){
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
