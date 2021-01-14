package com.spring.hibernate.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.hibernate.api.entity.ProductDetails;

public interface ProductRepository extends JpaRepository<ProductDetails,Integer>{

	@Query
	public List<ProductDetails> findByCategory(String category);
}
