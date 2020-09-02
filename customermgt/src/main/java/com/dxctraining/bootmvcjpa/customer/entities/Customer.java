package com.dxctraining.bootmvcjpa.customer.entities;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	public Customer() {

	}

	public Customer(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		}

		if (arg == null || !(arg instanceof Customer)) {
			return false;
		}

		Customer that = (Customer) arg;
		boolean isequal = this.id == that.id;
		return isequal;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
