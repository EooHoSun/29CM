package com.cm.cm.online.product.dto.skuMain;

import com.cm.cm.online.product.dto.origin.OriginDTO;
import lombok.Data;

@Data
public class SkuMainDTO {
    private String id;
    private int saleprice;
    private int purchaseprice;
    private String name;
    private String originCd;
    private OriginDTO origin;
}
