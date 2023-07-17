package com.nagarro.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Review {	
	
	@Id
	@Column(name = "reviewId", columnDefinition = "bigint default 0")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reviewId;

	@Column(name = "reviewDescription")
	private String reviewDesc;
	
	@ManyToOne
	@JoinColumn(name = "productCode", referencedColumnName = "productCode")
	@JsonBackReference
	private Product product;
	
	@Column(name = "ratings")
	private float ratings;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(Long reviewId, String reviewDesc, Product product, float ratings) {
		super();
		this.reviewId = reviewId;
		this.reviewDesc = reviewDesc;
		this.product = product;
		this.ratings = ratings;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewDesc() {
		return reviewDesc;
	}

	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product= product;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	
}