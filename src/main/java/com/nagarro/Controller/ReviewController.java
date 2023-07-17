package com.nagarro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.Repository.ReviewRepo;
import com.nagarro.Service.ProductService;
import com.nagarro.entity.Product;
import com.nagarro.entity.Review;

@RestController
@RequestMapping(path="/review")
@CrossOrigin
public class ReviewController {

	@Autowired
	private ReviewRepo reviewRepository;
	
	@Autowired
	private ProductService productService;
	
//	@PostMapping("/postReview")
//	public Review postReview(@RequestBody Review newReview) {
//		return reviewRepository.save(newReview);
//	}
		
	@PostMapping("/addReview")
	public Review addReview(@RequestBody Review newReview) {
        System.out.println("Adding a review for product code: " + newReview.getProduct().getProductCode());
        
        // Retrieve the product from the database using the productCode
        List<Product> product = productService.getProductById(newReview.getProduct().getProductCode());
        if (product == null) {
            throw new IllegalArgumentException("Product with code " + newReview.getProduct().getProductCode() + " does not exist.");
        }
        
        // Set the product for the review
        newReview.setProduct(product.get(0));
        
        return reviewRepository.save(newReview);
    }
	
	
 	//get all reviews
	@GetMapping("/getReviews")
	public List<Review> getAllReviews(){
		System.out.println("Get All Reviews Clicked");
		return reviewRepository.findAll();
	}
		
	
	//get all reviews by product code
	@GetMapping("/getReviewsByProductCode/{productCode}")
	public List<Review> getAllReviewsByProductCode(@PathVariable("productCode") String productCode) {
	    System.out.println("Get All Reviews for Product Code: " + productCode);
	    
	    // Retrieve the product from the database using the prodCode
	    List<Product> product = productService.getProductById(productCode);
	    if (product == null) {
	        throw new IllegalArgumentException("Product with code " + productCode + " does not exist.");
	    }
	    
	    // Retrieve all reviews for the product
	    return reviewRepository.findByProduct(product.get(0));
	}
	
	//get all reviews by product code
	@GetMapping("/getReviewsCountByProductCode/{productCode}")
	public long getReviewsCountByProductCode(@PathVariable("productCode") String productCode) {
	    System.out.println("Get All Reviews for Product Code: " + productCode);
	    
	    // Retrieve the product from the database using the prodCode
	    List<Product> product = productService.getProductById(productCode);
	    if (product == null) {
	        throw new IllegalArgumentException("Product with code " + productCode + " does not exist.");
	    }
	    
	    // Retrieve all reviews for the product
	    return reviewRepository.countByProduct(product.get(0));
	}
	
	//get total number of reviews
	@GetMapping("/getTotalReviews")
	public int getTotalReviewsCount() {
	    System.out.println("Get Total Reviews Count");
	    return (int) reviewRepository.count();
	}
	
}
