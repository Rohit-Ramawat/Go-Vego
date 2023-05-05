package com.masai.service;

import com.masai.entity.BillingDetails;

public interface IBillingService {
	
	public BillingDetails addBill(BillingDetails bill);
	public BillingDetails updateBill(BillingDetails bill);
	public BillingDetails viewBill(int id);
}
