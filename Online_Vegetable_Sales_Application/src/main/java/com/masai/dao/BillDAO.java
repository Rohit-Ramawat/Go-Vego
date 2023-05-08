package com.masai.dao;

import com.masai.entity.BillingDetails;
import com.masai.exception.BillException;

public interface BillDAO {
	public void addBill(BillingDetails bill) throws BillException;
}
