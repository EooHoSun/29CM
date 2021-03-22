package com.cm.cm.online.product.service;

import com.cm.cm.online.product.dto.product.ProductDTO;
import com.cm.cm.online.product.dto.sku.SkuMainDTO;
import com.cm.cm.online.product.entity.origin.OriginEntity;
import com.cm.cm.online.product.entity.product.ProductEntity;
import com.cm.cm.online.product.entity.sku.SkuMainEntity;
import com.cm.cm.online.product.repository.ProductMapper;
import com.cm.cm.online.product.repository.ProductRepository;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public List<ProductDTO> findAll(int orderByPrice, int orderByQuantity){
        List<ProductDTO> result = null;

        Comparator<ProductEntity> comp1 = (e1, e2) -> {
            int compNum = e1.getPrice () - e2.getPrice ();
            return orderByPrice == 1 ? compNum : -compNum;
        };
        Comparator<ProductEntity> comp2 = (e1, e2) -> {
            int compNum = e1.getProductQuantity () - e2.getProductQuantity ();
            return orderByQuantity == 1 ? compNum : -compNum;
        };

        result = repository
                .findAll ( )
                .stream( )
                .sorted (comp1.thenComparing(comp2))
                .map(mapper::toProductDTO)
                .collect( Collectors.toList ( ));


        return result;
    }

    public ProductDTO findByProductId( String productId){
        ProductDTO result = null;
        ProductEntity entity = repository.findById ( productId ).get ();

        if( entity.saleable () ){
            result = mapper.toProductDTO ( entity );
        }

        return result;
    }
    public Integer getPriceByProductId(String productId){
        Integer result = -1;

        result = Integer.valueOf (
                repository
                        .findById ( productId )
                        .get ()
                        .getPrice () );

        return result;
    }
}
