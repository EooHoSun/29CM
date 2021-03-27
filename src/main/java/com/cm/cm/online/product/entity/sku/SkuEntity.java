package com.cm.cm.online.product.entity.sku;

import com.cm.cm.online.product.dto.sku.SkuDTO;
import com.cm.cm.online.product.entity.origin.OriginEntity;
import lombok.*;

import javax.persistence.*;

/**
 * 메인 단품 table(entity)
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "SKUS")
@DiscriminatorColumn(name = "skutype")
public class SkuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int saleprice;
    private int purchaseprice;
    private String name;
    private String originCd;


    @ManyToOne
    @JoinColumn(name = "originCd", referencedColumnName = "cd", insertable = false, updatable = false)
    private OriginEntity origin;

    public static SkuEntity newInstance(SkuDTO dto){
        return SkuEntity.builder ()
                .name ( dto.getName ( ) )
                .saleprice ( dto.getSaleprice () )
                .purchaseprice ( dto.getPurchaseprice () )
                .build ();
    }

}
