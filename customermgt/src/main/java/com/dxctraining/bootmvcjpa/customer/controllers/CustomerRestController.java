package com.dxctraining.bootmvcjpa.customer.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.bootmvcjpa.customer.dto.CreateCustomerRequest;
import com.dxctraining.bootmvcjpa.customer.dto.CustomerDto;
import com.dxctraining.bootmvcjpa.customer.entities.Customer;
import com.dxctraining.bootmvcjpa.customer.service.ICustomerService;
import com.dxctraining.bootmvcjpa.customer.util.CustomerUtil;



@RestController
@RequestMapping("/customers")
public class CustomerRestController {
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private CustomerUtil customerUtil;


	@PostMapping(value = "/add")
	public CustomerDto create(@RequestBody CreateCustomerRequest data) {
		String name = data.getName();
		Customer customer = new Customer(name);
		customer = customerService.save(customer);
		CustomerDto response = customerUtil.customerDto(customer);
		return response;
	}

	@GetMapping("/get/{id}")
	public CustomerDto findCustomerById(@PathVariable("id") int id) {
		Customer customer = customerService.findCustomerById(id);
		CustomerDto response =customerUtil. customerDto(customer);
		return response;
	}
	
	  @GetMapping
	    public List<CustomerDto> fetchAll() {
	        List<Customer> list = customerService.allCustomers();
	        List<CustomerDto>response=new ArrayList<>();
	        for (Customer customer:list){
	        	CustomerDto dto=customerUtil.customerDto(customer);
	            response.add(dto);
	        }
	        return response;
	    }

	  @GetMapping("/get/customer/{name}")
	    public List<CustomerDto> fetchCustomerByName(@PathVariable("name") String name ) {
	        List<Customer> list = customerService.findByName(name);
	        List<CustomerDto>response=new ArrayList<>();
	        for (Customer customer:list){
	        	CustomerDto dto=customerUtil.customerDto(customer);
	            response.add(dto);
	        }
	        return response;
	    }
	
}
