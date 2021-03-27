package com.cm.cm.online.product.entity.sku;

import javax.persistence.*;

/**
 * 메인 단품 table(entity)
 */
@Entity
@DiscriminatorValue ( "MAIN" )
public class SkuMainEntity extends SkuEntity{
}
