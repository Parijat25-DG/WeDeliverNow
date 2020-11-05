package com.spring.hibernate.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.hibernate.api.dto.DecorOrderResponse;
import com.spring.hibernate.api.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	@Query("SELECT new DecorOrderResponse(c.name, p.productName) FROM CUSTOMER c JOIN c.products p")
	public List<DecorOrderResponse> getJoinInformation();

}
