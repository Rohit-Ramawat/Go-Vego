package com.masai.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BillingDetails {
	
	private int billingId;
	private int orderId;
	private String transactionMode;
	private LocalDateTime transactionDate;
	private String transactionStatus;
	private Address billingAddress;
	
}
