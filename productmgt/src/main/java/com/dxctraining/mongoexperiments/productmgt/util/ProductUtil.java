package com.dxctraining.mongoexperiments.productmgt.util;

import org.springframework.stereotype.Component;

import com.dxctraining.mongoexperiments.productmgt.dto.ProductDto;
import com.dxctraining.mongoexperiments.productmgt.entities.Product;

@Component
public class ProductUtil {

    public ProductDto productDto(Product product){
    	ProductDto dto=new ProductDto(product.getId(),product.getName());
        return dto;
    }

}
