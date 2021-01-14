package com.spring.hibernate.api.dto;

import com.spring.hibernate.api.entity.CustomerDetails;

public class OrderRequest {
	
	private CustomerDetails customer;

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}
	
	

}
