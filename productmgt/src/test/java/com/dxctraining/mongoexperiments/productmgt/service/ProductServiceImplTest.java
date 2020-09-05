package com.dxctraining.mongoexperiments.productmgt.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dxctraining.mongoexperiments.productmgt.entities.Product;

import java.util.List;

@DataMongoTest
@Import(ProductServiceImpl.class)
public class ProductServiceImplTest {

	@Autowired
	private IProductService productService;

	@Autowired
	private MongoTemplate mongo;

	@Test
	public void testSave_1() {
		String name = "oppo";

		Product product1 = new Product(name);
		product1 = productService.save(product1);
		String id = product1.getId();
		Product fetched = mongo.findById(id, Product.class);
		Assertions.assertEquals(product1.getId(), fetched.getId());
		Assertions.assertEquals(name, product1.getName());

	}

	@Test
	public void findById_2() {
		String name = "mi";

		Product product1 = new Product(name);
		product1 = mongo.save(product1);
		Product fetched = productService.findProductById(product1.getId());
		Assertions.assertEquals(name, fetched.getName());

		Assertions.assertEquals(product1.getId(), fetched.getId());

	}

}
