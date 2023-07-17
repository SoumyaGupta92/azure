package com.nagarro.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "productCode")
	private String productCode;

	@Column(name = "productName")
	private String productName;

	@Column(name = "brandName")
	private String brandName;

	@Column(name = "price")
	private float price;

	@OneToMany(mappedBy = "product")
	@JsonManagedReference
	private List<Review> reviews;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productCode, String productName, String brandName, float price, List<Review> reviews) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.brandName = brandName;
		this.price = price;
		this.reviews = reviews;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
