package com.dxctraining.wisheditemmgt.wisheditem.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wisheditems")
public class WishedItem {

	@Id
	private String id;

	private String name;

	private String productId;

	private Integer customerId;

	public WishedItem() {
	}

	public WishedItem(String name, String productId, Integer customerId) {
		this.name = name;
		this.productId = productId;
		this.customerId = customerId;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

		if (arg == null || !(arg instanceof WishedItem)) {
			return false;
		}

		WishedItem that = (WishedItem) arg;
		boolean isequal = this.id.equals(that.id);
		return isequal;
	}

}
