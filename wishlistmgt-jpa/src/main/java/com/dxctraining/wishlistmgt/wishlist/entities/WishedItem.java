package com.dxctraining.wishlistmgt.wishlist.entities;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "wisheditems")
public class WishedItem {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private int customerId;

	private String productId;

	public WishedItem() {

	}

	public WishedItem(int customerId, String productId) {
		this.customerId = customerId;
		this.productId = productId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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
