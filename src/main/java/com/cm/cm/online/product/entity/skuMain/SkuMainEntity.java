package com.cm.cm.online.product.entity.skuMain;

import com.cm.cm.online.product.dto.skuMain.SkuMainDTO;
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
@Table(name = "SKUMAIN")
@EqualsAndHashCode(of = "id")
public class SkuMainEntity {
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

    public static SkuMainEntity newInstance(SkuMainDTO dto){
        return SkuMainEntity.builder ()
                .name ( dto.getName ( ) )
                .saleprice ( dto.getSaleprice () )
                .purchaseprice ( dto.getPurchaseprice () )
                .build ();
    }

}
