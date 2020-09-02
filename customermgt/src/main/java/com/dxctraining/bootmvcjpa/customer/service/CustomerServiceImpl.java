package com.dxctraining.bootmvcjpa.customer.service;

import com.dxctraining.bootmvcjpa.customer.dao.ICustomerDao;
import com.dxctraining.bootmvcjpa.customer.entities.Customer;
import com.dxctraining.bootmvcjpa.exceptions.CustomerNotFoundException;
import com.dxctraining.bootmvcjpa.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;

	@Override
	public Customer findCustomerById(int id) {
		Optional<Customer> optional = dao.findById(id);
		if (!optional.isPresent()) {
			throw new CustomerNotFoundException("customer not found for id=" + id);
		}
		Customer customer = optional.get();
		return customer;
	}

	@Override
	public Customer save(Customer customer) {
		validate(customer);
		customer = dao.save(customer);
		return customer;
	}

	public void validate(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("argument is null");
		}
	}

	@Override
	public List<Customer> findByName(String name) {
		List<Customer> customers = dao.findByName(name);
		return customers;
	}

	@Override
	public List<Customer> allCustomers() {
		List<Customer> customers = dao.findAll();
		return customers;
	}

}
