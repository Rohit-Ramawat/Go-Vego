package com.masai.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity 
public class Customer extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 50)
	private String mobileNumber;
	@Embedded
	private Address address;
	@Column(nullable = false, length = 50)
	private String emailId;
	@Column(nullable = false, length = 50)
	private String password;
	@Column(nullable = false, length = 50)
	private String confirmPassword;
	
	@Column(name = "is_deleted", nullable = false)
	private int isDeleted;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<BillingDetails> billingDetails;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Cart> carts;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Feedback> feedbacks;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String mobileNumber, Address address, String emailId, String password,
			String confirmPassword, List<Order> orders, List<BillingDetails> billingDetails, List<Cart> carts,
			List<Feedback> feedbacks) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.orders = orders;
		this.billingDetails = billingDetails;
		this.carts = carts;
		this.feedbacks = feedbacks;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<BillingDetails> getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(List<BillingDetails> billingDetails) {
		this.billingDetails = billingDetails;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", emailId=" + emailId + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", orders=" + orders + ", billingDetails=" + billingDetails + ", carts=" + carts + ", feedbacks="
				+ feedbacks + "]";
	}

	
}
