package com.cm.cm.online.product.dto.sku;

import com.cm.cm.online.product.dto.origin.OriginDTO;
import lombok.Data;


@Data
public class SkuSubDTO {
    private long skuId;
    private int skuSalePrice;
    private int skuPurchasePrice;
    private String skuName;
    private String originCd;
    private OriginDTO origin;
}
