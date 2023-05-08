package com.masai.service;

import com.masai.dao.BillDAO;
import com.masai.dao.BillDAOImpl;
import com.masai.entity.BillingDetails;
import com.masai.exception.BillException;

public class IBillingServiceImpl implements IBillingService {

	@Override
	public void addBill(BillingDetails bill) throws BillException {
		BillDAO bDAO = new BillDAOImpl();
		bDAO.addBill(bill);
	}

	@Override
	public BillingDetails updateBill(BillingDetails bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BillingDetails viewBill(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
