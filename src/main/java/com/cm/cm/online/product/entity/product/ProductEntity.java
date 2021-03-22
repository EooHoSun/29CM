package com.cm.cm.online.product.entity.product;

import com.cm.cm.online.product.dto.product.ProductDTO;
import com.cm.cm.online.product.entity.skuMain.SkuMainEntity;
import com.cm.cm.online.product.entity.skuSub.SkuSubEntity;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 상품 table(entity)
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_PRODUCT_M")
@EqualsAndHashCode(of = "productId")
public class ProductEntity {
    @Id
    private String productId;
    private String productContents;
    private String productName;
    private int productQuantity;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "product")
    private SkuMainEntity skuMain;


    // N + 1 문제 및 속도 성능 저하 해결을 위한 지연로딩, subselect, batch size 설정
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    @BatchSize ( size = 100)
    @Fetch ( FetchMode.SUBSELECT )
    private Set<SkuSubEntity> skuSubList = new LinkedHashSet<>();


    public int getPrice(){
        return this.skuMain.getSkuSalePrice () + this.getSkuSubList ().stream ().mapToInt ( SkuSubEntity::getSkuSalePrice ).sum ();
    }

    public static ProductEntity newInstance(ProductDTO dto){
        return ProductEntity.builder ()
                .productId ( UUID.randomUUID ( ).toString () )
                .productContents ( dto.getProductContents () )
                .productName ( dto.getProductName () )
                .productQuantity ( 100 )
                .build ();
    }

    public boolean saleable(){
        return this.getProductQuantity () > 0;
    }




}
