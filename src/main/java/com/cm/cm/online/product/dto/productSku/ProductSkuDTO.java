package com.cm.cm.online.product.dto.productSku;

import com.cm.cm.online.product.dto.sku.SkuDTO;
import com.cm.cm.online.product.entity.productSku.ProductSkuVO;
import lombok.Data;

@Data
public class ProductSkuDTO {
    private ProductSkuVO productSkuVO;
    private int quantity;
    private SkuDTO sku;
}
