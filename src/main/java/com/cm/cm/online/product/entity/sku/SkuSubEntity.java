package com.cm.cm.online.product.entity.sku;

import com.cm.cm.online.product.entity.origin.OriginEntity;
import com.cm.cm.online.product.entity.product.ProductEntity;
import lombok.*;

import javax.persistence.*;

/**
 * μλΈ λ¨ν table(entity)
 */
@Entity
@DiscriminatorValue ( "SUB" )
public class SkuSubEntity extends SkuEntity{


}
