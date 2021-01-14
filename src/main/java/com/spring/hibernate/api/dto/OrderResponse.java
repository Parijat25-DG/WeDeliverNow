package com.spring.hibernate.api.dto;

import com.spring.hibernate.api.entity.CustomerDetails;

public class OrderResponse {
	
	private CustomerDetails customer;
	private String message;

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
