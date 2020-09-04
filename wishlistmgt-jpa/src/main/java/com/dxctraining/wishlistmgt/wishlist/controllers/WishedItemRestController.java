package com.dxctraining.wishlistmgt.wishlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.wishlistmgt.wishlist.dto.CreateWishedItemRequest;
import com.dxctraining.wishlistmgt.wishlist.dto.CustomerDto;
import com.dxctraining.wishlistmgt.wishlist.dto.ProductDto;
import com.dxctraining.wishlistmgt.wishlist.dto.WishedItemDto;
import com.dxctraining.wishlistmgt.wishlist.entities.WishedItem;
import com.dxctraining.wishlistmgt.wishlist.service.IWishedItemService;
import com.dxctraining.wishlistmgt.wishlist.util.WishedItemUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlists")
public class WishedItemRestController {

    @Autowired
    private IWishedItemService service;

    @Autowired
    private WishedItemUtil wishedItemUtil;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @PostMapping("/add")
	public WishedItemDto addWishlist(@RequestBody CreateWishedItemRequest requestData) {
		WishedItem wishedItem = new WishedItem(requestData.getCustomerId(), requestData.getProductId());
		wishedItem = service.save(wishedItem);
		CustomerDto customerDto = findCustomerDetailsByCustomerId(requestData.getCustomerId());
		customerDto.setCustomerId(requestData.getCustomerId());
		ProductDto productDto = findProductDetailsByProductId(requestData.getProductId());
		WishedItemDto response = wishedItemUtil.wishedItemDto(wishedItem,customerDto.getCustomerId(),customerDto.getName(),productDto.getId(),productDto.getName());
		return response;
	}
    
    @GetMapping("/get/{id}")
	public List<WishedItemDto> findAllWishedItemsById(@PathVariable("id")int customerId) {
		List<WishedItem>list = service.findAllById(customerId);
		List<WishedItemDto>response = new ArrayList<>();
		for(WishedItem wishedItem:list) {
			String productId = wishedItem.getProductId();
        	ProductDto productDto = findProductDetailsByProductId(productId);
        	int custId = wishedItem.getCustomerId();
        	CustomerDto customerDto = findCustomerDetailsByCustomerId(customerId);
			WishedItemDto dto = wishedItemUtil.wishedItemDto(wishedItem,custId,customerDto.getName(),productId, productDto.getName());
			response.add(dto);
		}
		return response;
	}

    @GetMapping
    public List<WishedItemDto> fetchAll() {
        List<WishedItem> list = service.allWishedItems();
        List<WishedItemDto>response=new ArrayList<>();
        for (WishedItem wishedItem:list){
        	String productId = wishedItem.getProductId();
        	ProductDto productDto = findProductDetailsByProductId(productId);
        	int customerId = wishedItem.getCustomerId();
        	CustomerDto customerDto = findCustomerDetailsByCustomerId(customerId);
            WishedItemDto dto=wishedItemUtil.wishedItemDto(wishedItem,customerId,customerDto.getName(),productId, productDto.getName());
            response.add(dto);
        }
        return response;
    }
    
    public CustomerDto findCustomerDetailsByCustomerId(int customerId) {
    	String url = "http://localhost:8989/customers/get/"+customerId;
    	CustomerDto dto = restTemplate.getForObject(url, CustomerDto.class);
		return dto;
    }
    
    public ProductDto findProductDetailsByProductId(String productId) {
    	String url = "http://localhost:8686/products/get/"+productId;
    	ProductDto dto = restTemplate.getForObject(url, ProductDto.class);
		return dto;
    }

}




