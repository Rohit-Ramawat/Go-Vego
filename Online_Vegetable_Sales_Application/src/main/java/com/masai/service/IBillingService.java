package com.masai.service;

import com.masai.entity.BillingDetails;
import com.masai.exception.BillException;

public interface IBillingService {
	
	public void addBill(BillingDetails bill) throws BillException;
	public BillingDetails updateBill(BillingDetails bill);
	public BillingDetails viewBill(int id);
}
