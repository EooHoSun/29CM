package com.cm.cm.online.product.service;

import com.cm.cm.online.product.dto.product.ProductDTO;
import com.cm.cm.online.product.entity.product.ProductEntity;
import com.cm.cm.online.product.repository.ProductMapper;
import com.cm.cm.online.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
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
            int compNum = e1.getQuantity () - e2.getQuantity ();
            return orderByQuantity == 1 ? compNum : -compNum;
        };

        result = repository
                .findAll ( )
                .stream( )
                .sorted (comp1.thenComparing(comp2))
                .map(entity -> {
                    ProductDTO dto = mapper.toProductDTO ( entity );

                    if(dto.getQuantity () < 1){
                        dto.setSaleable ( false );
                    }

                    dto.setTotalPrice ( entity.getPrice () );
                    return dto;
                })
                .collect( Collectors.toList ( ));

        return result;
    }

    public ProductDTO findByProductId( long productId){
        ProductDTO result = null;
        ProductEntity entity = repository.findById ( productId ).get ();

        if( entity.saleable () ){
            result = mapper.toProductDTO ( entity );
        }

        return result;
    }

    //
    public Integer getPriceByProductId(long productId){
        Integer result = -1;

        ProductEntity entity = repository
                .findById ( productId )
                .get ();

        log.info ( "productEntity : " + entity);
        if(entity.saleable ()){
            result = Integer.valueOf (entity.getPrice ());
        }

        return result;
    }
}
