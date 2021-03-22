package com.cm.cm.online.product.entity.product;

import com.cm.cm.online.product.dto.product.ProductDTO;
import com.cm.cm.online.product.entity.productSkuMain.ProductSkuMainEntity;
import com.cm.cm.online.product.entity.productSkuSub.ProductSkuSubEntity;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "product")
    private ProductSkuMainEntity skuMain;



    // N + 1 문제 및 속도 성능 저하 해결을 위한 지연로딩, subselect, batch size 설정
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    @BatchSize ( size = 100)
    @Fetch ( FetchMode.SUBSELECT )
    private Set<ProductSkuSubEntity> skuSubList = new LinkedHashSet<>();


    public int getPrice(){
        return this.skuMain.getPrice () + this.getSkuSubList ().stream ().mapToInt ( ProductSkuSubEntity::getPrice ).sum ();
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
