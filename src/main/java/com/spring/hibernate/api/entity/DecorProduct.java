package com.spring.hibernate.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DecorProduct {
	
	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private String productCategory;
	private int quantity;
	private int price;
	

}
