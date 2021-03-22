package com.cm.cm.online.product.dto.product;

import com.cm.cm.online.product.dto.productSkuMain.ProductSkuMainDTO;
import com.cm.cm.online.product.dto.productSkuSub.ProductSkuSubDTO;
import lombok.Data;

import java.util.Set;

@Data
public class ProductDTO {
    private String id;
    private String contents;
    private String name;
    private int quantity;
    private ProductSkuMainDTO skuMain;
    private Set<ProductSkuSubDTO> skuSubList;
    private boolean saleable = true;
    private int totalPrice = -1;

}
