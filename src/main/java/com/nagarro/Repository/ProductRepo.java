package com.nagarro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nagarro.entity.Product;

@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product, String>{
	
	List<Product> findByProductCode(String productCode);
	
	List<Product> findByProductName(String productName);

	List<Product> findByBrandName(String brandName);

}
