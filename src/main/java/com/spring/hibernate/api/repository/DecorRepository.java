package com.spring.hibernate.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.hibernate.api.entity.DecorProduct;

public interface DecorRepository extends JpaRepository<DecorProduct,Integer>{

	@Query
	public List<DecorProduct> findByCategory(String category);
}
