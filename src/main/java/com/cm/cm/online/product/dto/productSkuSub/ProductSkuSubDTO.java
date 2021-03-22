package com.cm.cm.online.product.dto.productSkuSub;

import com.cm.cm.online.product.dto.skuSub.SkuSubDTO;
import com.cm.cm.online.product.entity.productSkuSub.ProductSkuSubVO;
import lombok.Data;

@Data
public class ProductSkuSubDTO {
    ProductSkuSubVO productSkuSubVO;
    private int productSkuQuantity;
    private SkuSubDTO skuSub;
}
