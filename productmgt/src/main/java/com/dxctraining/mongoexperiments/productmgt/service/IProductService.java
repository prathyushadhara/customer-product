package com.dxctraining.mongoexperiments.productmgt.service;

import java.util.List;

import com.dxctraining.mongoexperiments.productmgt.entities.Product;

public interface IProductService {

	Product save(Product product);

	Product findById(String id);
	List<Product> findAll();

	List<Product> findByName(String name);

	

}
