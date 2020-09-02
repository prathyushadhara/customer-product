package com.dxctraining.mongoexperiments.productmgt.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxctraining.mongoexperiments.productmgt.entities.Product;

import java.util.List;

public interface IProductDao extends MongoRepository<Product, String> {

	List<Product> findByName(String name);

}
