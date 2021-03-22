package com.cm.cm.online.product.dto.product;

import com.cm.cm.online.product.dto.sku.ProductSkuMainDTO;
import com.cm.cm.online.product.dto.sku.ProductSkuSubDTO;
import com.cm.cm.online.product.dto.sku.SkuMainDTO;
import com.cm.cm.online.product.dto.sku.SkuSubDTO;
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
