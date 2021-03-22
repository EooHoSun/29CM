package com.cm.cm.online.product.dto.sku;

import com.cm.cm.online.product.entity.skuMain.ProductSkuMainVO;
import com.cm.cm.online.product.entity.skuMain.SkuMainEntity;
import lombok.Data;

@Data
public class ProductSkuMainDTO {
    private ProductSkuMainVO productSkuMainVO;
    private int productSkuQuantity;
    private SkuMainDTO skuMain;
}
