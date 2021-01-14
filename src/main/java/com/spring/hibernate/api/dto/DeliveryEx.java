package com.spring.hibernate.api.dto;

public class DeliveryEx {
	
	private String deliveryExId;
	private String deliveryExName;
	private String deliveryExMob;
	private int priority;
	private String category;
	private long deliveryTime;
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(long deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getDeliveryExId() {
		return deliveryExId;
	}
	public void setDeliveryExId(String deliveryExId) {
		this.deliveryExId = deliveryExId;
	}
	public String getDeliveryExName() {
		return deliveryExName;
	}
	public void setDeliveryExName(String deliveryExName) {
		this.deliveryExName = deliveryExName;
	}
	public String getDeliveryExMob() {
		return deliveryExMob;
	}
	public void setDeliveryExMob(String deliveryExMob) {
		this.deliveryExMob = deliveryExMob;
	}
	

}
