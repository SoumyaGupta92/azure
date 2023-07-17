package com.nagarro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.entity.Product;
import com.nagarro.entity.Review;

public interface ReviewRepo extends JpaRepository<Review, String>{

	List<Review> findByProduct(Product product);

	long countByProduct(Product product);
	
}
