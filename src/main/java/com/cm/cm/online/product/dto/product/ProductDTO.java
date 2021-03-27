package com.cm.cm.online.product.dto.product;
import com.cm.cm.online.product.dto.productSku.ProductSkuDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private long id;
    private String contents;
    private String name;
    private int quantity;
    private List<ProductSkuDTO> skuList;
    private boolean saleable = true;
    private int totalPrice = -1;

}
