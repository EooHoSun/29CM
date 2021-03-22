package com.cm.cm.online.product.dto.sku;

import com.cm.cm.online.product.dto.origin.OriginDTO;
import com.cm.cm.online.product.entity.origin.OriginEntity;
import com.cm.cm.online.product.entity.skuSub.SkuSubVO;
import lombok.Data;


@Data
public class SkuSubDTO {
    private SkuSubVO skuSubVO;
    private int skuSalePrice;
    private int skuPurchasePrice;
    private String skuName;
    private String originCd;
    private OriginDTO origin;
}
