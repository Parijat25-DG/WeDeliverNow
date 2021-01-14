package com.spring.hibernate.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.spring.hibernate.api.dto.DeliveryEx;

@Entity
public class DeliveryDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private String orderId;
	private DeliveryEx details;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DeliveryEx getDetails() {
		return details;
	}
	public void setDetails(DeliveryEx details) {
		this.details = details;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	

}
