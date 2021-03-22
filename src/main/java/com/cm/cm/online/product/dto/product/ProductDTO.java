package com.cm.cm.online.product.dto.product;

import com.cm.cm.online.product.dto.productSkuMain.ProductSkuMainDTO;
import com.cm.cm.online.product.dto.productSkuSub.ProductSkuSubDTO;
import lombok.Data;

import java.util.Set;

@Data
public class ProductDTO {
    private String productId;
    private String productContents;
    private String productName;
    private int productQuantity;
    private ProductSkuMainDTO skuMain;
    private Set<ProductSkuSubDTO> skuSubList;
    private boolean saleable = true;
    private int totalPrice = -1;

}
