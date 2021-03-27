package com.cm.cm.online.product.dto.sku;

import com.cm.cm.online.product.dto.origin.OriginDTO;
import lombok.Data;

@Data
public class SkuDTO {
    private long id;
    private int saleprice;
    private int purchaseprice;
    private String name;
    private String skuType;
    private OriginDTO origin;
}
