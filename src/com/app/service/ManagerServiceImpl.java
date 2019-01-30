package com.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ManagerDao;
import com.app.pojos.Customer;
import com.app.pojos.Manager;
import com.app.pojos.Product;
import com.app.pojos.Storage;
import com.app.pojos.Transaction;
import com.app.pojos.WareHouse;

@Service
@Transactional
public class ManagerServiceImpl implements  ManagerService
{

	@Autowired
	private ManagerDao md;

	@Override
	public Manager validateManager(String userName, String password) {
		return md.validateManager(userName,password);
	}

	@Override
	public String addCustomer(Customer cust) {
		return md.addCustomer(cust);
	}

	@Override
	public String removeCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return md.removeCustomer(customerId);
	}

	@Override
	public ArrayList<Integer> getCustIds() {
		return md.getCustIds();
	}

	@Override
	public String updateCustomer(Integer customerId, String contact, String address) {
		return md.updateCustomer(customerId,contact,address);
	}

	@Override
	public WareHouse getWareHouseDetails(Integer mgrId) {
		return md.getWareHouseDetails(mgrId);
	}

	@Override
	public ArrayList<Storage> getWareHouseStorage(Integer WareHouseId) {
		return md.getWareHouseStorage(WareHouseId);
	}

	@Override
	public Transaction purchaseProduct(Integer customerId, String product, double quantity,Integer mgrId) {
		return md.purchaseProduct(customerId,product,quantity,mgrId);
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		
		return md.getAllProducts();
	}

	@Override
	public int changePass(String userName, String password) {
		return md.changePass(userName,password);
	}
	
}
