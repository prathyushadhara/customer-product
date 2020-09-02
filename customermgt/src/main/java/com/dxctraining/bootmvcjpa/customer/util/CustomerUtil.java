package com.dxctraining.bootmvcjpa.customer.util;

import org.springframework.stereotype.Component;

import com.dxctraining.bootmvcjpa.customer.dto.CustomerDto;
import com.dxctraining.bootmvcjpa.customer.entities.Customer;

@Component
public class CustomerUtil {

    public CustomerDto customerDto(Customer customer){
    	CustomerDto dto=new CustomerDto(customer.getId(),customer.getName());
        return dto;
    }

}
