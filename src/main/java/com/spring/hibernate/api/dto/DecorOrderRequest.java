package com.spring.hibernate.api.dto;

import com.spring.hibernate.api.entity.Customer;

public class DecorOrderRequest {
	
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
