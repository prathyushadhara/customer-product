package com.dxctraining.bootmvcjpa.customer.service;



import java.util.List;

import com.dxctraining.bootmvcjpa.customer.entities.Customer;


public interface ICustomerService {

	Customer findCustomerById(int id);

	Customer save(Customer customer);

	List<Customer> findByName(String name);

	List<Customer> allCustomers();

}
