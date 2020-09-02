package com.dxctraining.bootmvcjpa.customer.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import com.dxctraining.bootmvcjpa.customer.entities.Customer;

import java.util.List;

public interface ICustomerDao extends JpaRepository<Customer, Integer> {

    List<Customer> findByName(String name);

}
