package com.nagarro.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.Repository.ProductRepo;
import com.nagarro.Service.ProductService;
import com.nagarro.entity.Product;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public List<Product> getProductById(String productCode) {
		List<Product> product = productRepo.findByProductCode(productCode);
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Long totalProducts() {
		return productRepo.count();
	}

	@Override
	public List<Product> getProductByProductName(String productName) {
		List<Product> product = productRepo.findByProductName(productName);
		return product;
	}

	@Override
	public List<Product> getProductByBrandName(String brandName) {
		List<Product> product = productRepo.findByBrandName(brandName);
		return product;
	}
	
	
}
