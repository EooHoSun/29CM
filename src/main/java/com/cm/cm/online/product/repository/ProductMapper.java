package com.cm.cm.online.product.repository;

import com.cm.cm.online.product.dto.origin.OriginDTO;
import com.cm.cm.online.product.dto.product.ProductDTO;
import com.cm.cm.online.product.dto.productSku.ProductSkuDTO;
import com.cm.cm.online.product.dto.sku.SkuDTO;
import com.cm.cm.online.product.entity.origin.OriginEntity;
import com.cm.cm.online.product.entity.product.ProductEntity;
import com.cm.cm.online.product.entity.productSku.ProductSkuEntity;
import com.cm.cm.online.product.entity.sku.SkuMainEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    OriginDTO toOriginDTO(OriginEntity e);

    @Mapping ( source = "origin", target = "origin")
    SkuDTO toSkuDTO(SkuMainEntity e);

    @Mapping ( source = "sku", target = "sku")
    ProductSkuDTO toProductSkuDTO(ProductSkuEntity e);

    @Mapping ( source = "skuList", target = "skuList")
    ProductDTO toProductDTO(ProductEntity e);



}
