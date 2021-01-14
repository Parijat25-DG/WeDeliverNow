package com.spring.hibernate.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.hibernate.api.entity.DeliveryDetails;

public interface DeliveryRepository extends JpaRepository<DeliveryDetails,Integer>{
	
	@Query
	public DeliveryDetails findByOrderId(String orderId);
}
