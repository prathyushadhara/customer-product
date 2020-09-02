package com.dxctraining.mongoexperiments.productmgt.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class Product {

	@Id
	private String id;

	private String name;

	public Product() {

	}

	public Product(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		int hash = id.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		}

		if (arg == null || !(arg instanceof Product)) {
			return false;
		}

		Product that = (Product) arg;
		boolean isequal = this.id.equals(that.id);
		return isequal;
	}
}
