package com.cm.cm.online.product.repository;

import com.cm.cm.online.product.dto.origin.OriginDTO;
import com.cm.cm.online.product.dto.product.ProductDTO;
import com.cm.cm.online.product.dto.productSkuMain.ProductSkuMainDTO;
import com.cm.cm.online.product.dto.productSkuSub.ProductSkuSubDTO;
import com.cm.cm.online.product.dto.skuMain.SkuMainDTO;
import com.cm.cm.online.product.dto.skuSub.SkuSubDTO;
import com.cm.cm.online.product.entity.origin.OriginEntity;
import com.cm.cm.online.product.entity.product.ProductEntity;
import com.cm.cm.online.product.entity.productSkuMain.ProductSkuMainEntity;
import com.cm.cm.online.product.entity.skuMain.SkuMainEntity;
import com.cm.cm.online.product.entity.productSkuSub.ProductSkuSubEntity;
import com.cm.cm.online.product.entity.skuSub.SkuSubEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    OriginDTO toOriginDTO(OriginEntity e);

    @Mapping ( source = "origin", target = "origin")
    SkuMainDTO toSkuMainDTO(SkuMainEntity e);

    @Mapping ( source = "origin", target = "origin")
    SkuSubDTO toSkuSubDTO(SkuSubEntity e);

    @Mapping ( source = "skuMain", target = "skuMain")
    ProductSkuMainDTO toProductSkuMainDTO(ProductSkuMainEntity e);

    @Mapping ( source = "skuSub", target = "skuSub")
    ProductSkuSubDTO toProductSkuSubDTO(ProductSkuSubEntity e);

    @Mappings ( {
        @Mapping ( source = "skuMain", target = "skuMain"),
        @Mapping ( source = "skuSubList", target = "skuSubList")
    } )
    ProductDTO toProductDTO(ProductEntity e);



}
