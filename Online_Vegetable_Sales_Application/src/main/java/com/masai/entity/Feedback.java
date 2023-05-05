package com.masai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int feedbackId;
	private int vegtableId;
	@Column(nullable = false)
	private int rating;
	@Column(nullable = false, length = 50)
	private String comments;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int vegtableId, int rating, String comments, Customer customer) {
		super();
		this.vegtableId = vegtableId;
		this.rating = rating;
		this.comments = comments;
		this.customer = customer;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getVegtableId() {
		return vegtableId;
	}

	public void setVegtableId(int vegtableId) {
		this.vegtableId = vegtableId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", vegtableId=" + vegtableId + ", rating=" + rating
				+ ", comments=" + comments + ", customer=" + customer + "]";
	}
	
	
}
