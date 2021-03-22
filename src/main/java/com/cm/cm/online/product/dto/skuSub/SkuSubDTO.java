package com.cm.cm.online.product.dto.skuSub;

import com.cm.cm.online.product.dto.origin.OriginDTO;
import lombok.Data;


@Data
public class SkuSubDTO {
    private long id;
    private int saleprice;
    private int purchaseprice;
    private String name;
    private String originCd;
    private OriginDTO origin;
}
