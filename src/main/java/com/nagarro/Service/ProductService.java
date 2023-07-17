package com.nagarro.Service;

import java.util.List;

import com.nagarro.entity.Product;

public interface ProductService {

	// Get all Products
	List<Product> getAllProducts();

	// Get Product by ProductCode
	List<Product> getProductById(String productCode);

	Product addProduct(Product product);

	Long totalProducts();

	List<Product> getProductByProductName(String productName);

	List<Product> getProductByBrandName(String brandName);
}
