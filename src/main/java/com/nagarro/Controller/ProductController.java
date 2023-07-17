package com.nagarro.Controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.Service.ProductService;
import com.nagarro.entity.Product;
import com.nagarro.entity.Review;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	// Get the list of all the products in the Product Table
	@GetMapping()
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	//	Get product detail by using product code
	@GetMapping("/productCode/{productCode}")
	public List<Product> getProductByProductCode(@PathVariable String productCode) {
		System.out.println(productService.getProductById(productCode));
		return productService.getProductById(productCode);
	}
	
	// Add the details of new Product
	@PostMapping()
	public Product addProduct(@RequestBody Product product){
		System.out.println(product.getProductCode());
		return productService.addProduct(product);
	}
	
	//Get Total Number of Products present in the Product Table
	@GetMapping("/totalProducts")
	public Long totalNumberOfProducts() {
		return productService.totalProducts();
	}
	
	@GetMapping("/productName/{productName}")
	public List<Product> getProductByProductName(@PathVariable String productName) {
		return productService.getProductByProductName(productName);
	}
	
	@GetMapping("/brandName/{brandName}")
	public List<Product> getProductByBrandName(@PathVariable String brandName) {
		System.out.println(brandName+ " " + productService.getProductByBrandName(brandName));
		return productService.getProductByBrandName(brandName);
	}
	
	@GetMapping("/{productCode}/rating")
	public String getProductAverageRating(@PathVariable("productCode") String productCode) {
		List<Product> product = productService.getProductById(productCode);
		if (product != null) {
			List<Review> reviews = product.get(0).getReviews();
			if (!reviews.isEmpty()) {
				int totalRating = 0;
				for (Review review : reviews) {
					totalRating += review.getRatings();
				}
				double averageRating = (double) totalRating / reviews.size();
				
				// Format the average rating with two decimal places
	            DecimalFormat df = new DecimalFormat("#.#");
	            String formattedRating = df.format(averageRating);
				
				return formattedRating;
			}
		}
		// If product or reviews not found, return 0 indicating no rating available
		return "0.0";
	}
	
}

	
