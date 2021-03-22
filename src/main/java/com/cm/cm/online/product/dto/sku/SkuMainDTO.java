package com.cm.cm.online.product.dto.sku;

import com.cm.cm.online.product.dto.origin.OriginDTO;
import lombok.Data;

@Data
public class SkuMainDTO {
    private String skuId;
    private int skuSalePrice;
    private int skuPurchasePrice;
    private String skuName;
    private String productId;
    private String originCd;
    private OriginDTO origin;
}
