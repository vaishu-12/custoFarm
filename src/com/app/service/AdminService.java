package com.app.service;

import java.util.ArrayList;

import com.app.pojos.Admin;
import com.app.pojos.Employee;
import com.app.pojos.Manager;
import com.app.pojos.Product;
import com.app.pojos.Storage;
import com.app.pojos.Transaction;
import com.app.pojos.WareHouse;

public interface AdminService {
	Employee validateAdmin(String userName,String password);
	WareHouse addWareHouse(WareHouse warehouse);
	Manager addManager(Manager manager,WareHouse warehouse);
	ArrayList<WareHouse> getWareHouses();
	WareHouse updateWareHouse(String name,String address,long contact,int warehouseid);
	public String addProduct(Product p);
	public ArrayList<Product> getAllProducts();
	public String removeProduct(int p);
	public String updateProduct(int p, double price);
	public ArrayList<Transaction> transactionDetails(String startDate,String endDate);
	WareHouse deleteWareHouse(int warehouseid);
	ArrayList<Manager> getManagers();
	Manager updateManager(String email,long contact1,String address,int mgrId);
	Manager deleteManager(int mgrId);
	ArrayList<Storage> getWareHouseStorage(int id);
	void addAdmin(Admin a);
	
}
