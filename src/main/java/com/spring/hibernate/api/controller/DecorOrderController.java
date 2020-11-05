package com.spring.hibernate.api.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hibernate.api.dto.DecorOrderRequest;
import com.spring.hibernate.api.dto.DecorOrderResponse;
import com.spring.hibernate.api.entity.Customer;
import com.spring.hibernate.api.entity.DecorProduct;
import com.spring.hibernate.api.repository.CustomerRepository;
import com.spring.hibernate.api.repository.DecorRepository;

@RestController
public class DecorOrderController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DecorRepository decorRepository;
	
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody DecorOrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}
	
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/findAllProducts")
	public List<DecorProduct> findAllProducts(){
		return decorRepository.findAll();
	}
	
	@GetMapping("/findProductsByCategory/{category}")
	public List<DecorProduct> findProductsByCategory(@PathParam(value = "category") String category){
		return decorRepository.findByCategory(category);
	} 
	
	@GetMapping("/getInfo")
	public List<DecorOrderResponse> getJoinInformation(){
		return customerRepository.getJoinInformation();
	}

}
