package com.dxctraining.mongoexperiments.productmgt.service;

import java.util.List;

import com.dxctraining.mongoexperiments.productmgt.entities.Product;



public interface IProductService{
	
	Product findProductById(String id);

	Product save(Product product);
	
	List<Product> findProductByName(String name);
	
	List<Product> displayAllProducts();
}