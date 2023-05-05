package com.masai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 50)
	private String contactNumber;
	@Column(nullable = false, length = 50)
	private String emailId;
	@Column(name = "is_deleted", nullable = false)
	private int isDeleted;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String userId, String password, String role, String name, String contactNumber, String emailId) {
		super(userId, password, role);
		this.name = name;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", contactNumber=" + contactNumber + ", emailId="
				+ emailId + "]";
	}
	
	
}
