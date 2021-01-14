package com.spring.hibernate.api.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hibernate.api.dto.OrderRequest;
import com.spring.hibernate.api.dto.OrderResponse;
import com.spring.hibernate.api.dto.ProductResponse;
import com.spring.hibernate.api.entity.CustomerDetails;
import com.spring.hibernate.api.entity.ProductDetails;
import com.spring.hibernate.api.wrapper.OrderWrapper;

@RestController
public class OrderController {
	
	@Autowired
	private OrderWrapper orderWrapper;
	
	@PostMapping("/placeOrder")
	public OrderResponse placeOrder(@RequestBody OrderRequest request) {
		return orderWrapper.placeOrder(request);
	}
	
	@GetMapping("/findAllOrders")
	public List<CustomerDetails> findAllOrders(){
		return orderWrapper.findAllOrders();
	}
	
	@GetMapping("/findAllProducts")
	public List<ProductDetails> findAllProducts(){
		return orderWrapper.findAllProducts();
	}
	
	@GetMapping("/findProductsByCategory/{category}")
	public List<ProductDetails> findProductsByCategory(@PathParam(value = "category") String category){
		return orderWrapper.findProductsByCategory(category);
	} 
	
	@GetMapping("/getInfo")
	public List<ProductResponse> findProductsByCustomer(){
		return orderWrapper.findProductsByCustomer();
	}
	
	@GetMapping("/getOrderStatusDetails/{orderId}")
	public String getOrderStatusDetails(@PathParam(value = "orderId") String orderId) {
		return orderWrapper.findOrderStatus(orderId);
	}

}
