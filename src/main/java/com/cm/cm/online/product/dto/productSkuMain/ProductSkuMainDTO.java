package com.cm.cm.online.product.dto.productSkuMain;

import com.cm.cm.online.product.dto.skuMain.SkuMainDTO;
import com.cm.cm.online.product.entity.productSkuMain.ProductSkuMainVO;
import lombok.Data;

@Data
public class ProductSkuMainDTO {
    private ProductSkuMainVO productSkuMainVO;
    private int productSkuQuantity;
    private SkuMainDTO skuMain;
}
