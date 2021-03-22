package com.cm.cm.online.product.dto.sku;

import com.cm.cm.online.product.entity.skuSub.ProductSkuSubVO;
import com.cm.cm.online.product.entity.skuSub.SkuSubEntity;
import lombok.Data;

@Data
public class ProductSkuSubDTO {
    ProductSkuSubVO productSkuSubVO;
    private int productSkuQuantity;
    private SkuSubDTO skuSub;
}
