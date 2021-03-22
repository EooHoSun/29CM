package com.cm.cm.online.product.dto.product;

import com.cm.cm.online.product.dto.sku.SkuMainDTO;
import com.cm.cm.online.product.dto.sku.SkuSubDTO;
import com.cm.cm.online.product.entity.sku.SkuMainEntity;
import com.cm.cm.online.product.entity.sku.SkuSubEntity;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class ProductDTO {
    private String productId;
    private String productContents;
    private String productName;
    private int productQuantity;
    private String skuMainId;
    private SkuMainDTO skuMain;
    private Set<SkuSubDTO> skuSubList;
    private boolean saleable = true;

}
