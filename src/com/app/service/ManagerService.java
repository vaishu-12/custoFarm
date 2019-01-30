package com.app.service;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Customer;
import com.app.pojos.Manager;
import com.app.pojos.Product;
import com.app.pojos.Storage;
import com.app.pojos.Transaction;
import com.app.pojos.WareHouse;

public interface ManagerService {

	public Manager validateManager(String userName,String password);
	public String addCustomer(Customer cust);
	public String removeCustomer(Integer customerId);
	public ArrayList<Integer> getCustIds();
	public String updateCustomer(Integer customerId,String contact,String address);
	public WareHouse getWareHouseDetails(Integer mgrId);
	public ArrayList<Storage> getWareHouseStorage(Integer WareHouseId);
	public ArrayList<Product> getAllProducts();
	public int changePass(String userName,String password);
	public Transaction purchaseProduct(@RequestParam Integer customerId,@RequestParam String product,@RequestParam double quantity,Integer mgrId);
}
