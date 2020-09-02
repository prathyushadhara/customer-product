package com.dxctraining.mongoexperiments.productmgt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dxctraining.mongoexperiments.productmgt.dto.CreateProductRequest;
import com.dxctraining.mongoexperiments.productmgt.dto.ProductDto;
import com.dxctraining.mongoexperiments.productmgt.entities.Product;
import com.dxctraining.mongoexperiments.productmgt.service.IProductService;
import com.dxctraining.mongoexperiments.productmgt.util.ProductUtil;

@RequestMapping("/products")
@RestController
public class ProductRestController {

	@Autowired
	private IProductService service;

	@Autowired
	private ProductUtil util;

	@PostMapping(value = "/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto create(@RequestBody CreateProductRequest requestData) {

		Product product = new Product(requestData.getName());
		product = service.save(product);
		ProductDto response = util.productDto(product);
		return response;
	}

	@GetMapping("/get/{id}")
	public ProductDto findSupplier(@PathVariable("id") String id) {
		Product product = service.findById(id);
		ProductDto response = util.productDto(product);
		return response;
	}

	@GetMapping("/get/product/{name}")
	public List<ProductDto> fetchProductByName(@PathVariable("name") String name) {
		List<Product> list = service.findByName(name);
		List<ProductDto> response = new ArrayList<>();
		for (Product product : list) {
			ProductDto dto = util.productDto(product);
			response.add(dto);
		}
		return response;
	}

}
