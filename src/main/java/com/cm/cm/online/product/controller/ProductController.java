package com.cm.cm.online.product.controller;


import com.cm.cm.online.product.dto.product.ProductDTO;
import com.cm.cm.online.product.service.ProductService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService service;


    @GetMapping("/v1/{orderByPrice}/{orderByQuantity}")
    public ResponseEntity<List<ProductDTO>> findAll(@PathVariable @DefaultValue("0") int orderByPrice, @PathVariable @DefaultValue("0") int orderByQuantity){
        ResponseEntity<List<ProductDTO>> result = null;

        try {
            result = ResponseEntity.ok ( service.findAll( orderByPrice,  orderByQuantity) );
        }catch(Exception e){
            ResponseEntity.status ( 500 );
        }

        return result;
    }

    @GetMapping("/v1/{productId}")
    public ResponseEntity<ProductDTO> findByProductId(@PathVariable @NotNull long productId){
        ResponseEntity<ProductDTO> result = null;

        try {
            result = ResponseEntity.ok ( service.findByProductId(productId) );
        }catch(Exception e){
            ResponseEntity.status ( 500 );
        }

        return result;
    }


    @GetMapping("/price/v1/{productId}")
    public ResponseEntity<Integer> getPriceByProductId(@PathVariable @NotNull long productId){
        ResponseEntity<Integer> result = null;

        try {
            result = ResponseEntity.ok ( service.getPriceByProductId(productId) );
        }catch(Exception e){
            ResponseEntity.status ( 500 );
        }

        return result;
    }


}
