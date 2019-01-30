package com.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminDao;
import com.app.pojos.Admin;
import com.app.pojos.Employee;
import com.app.pojos.Manager;
import com.app.pojos.Product;
import com.app.pojos.Storage;
import com.app.pojos.Transaction;
import com.app.pojos.WareHouse;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	public static SimpleDateFormat sdf;
	static
	{
		sdf=new SimpleDateFormat("yyyy-MM-dd");
	}
	@Autowired
	private AdminDao dao;
	
	public AdminServiceImpl() {
		System.out.println("in def service");
	}
	
	@Override
	public Employee validateAdmin(String userName, String password) {
		return dao.validateAdmin(userName,password);
	}
	
	@Override
	public WareHouse addWareHouse(WareHouse warehouse) {
		return dao.addWareHouse(warehouse);
	}
	
	@Override
	public Manager addManager(Manager manager,WareHouse warehouse) {
		System.out.println("in service addmanager");
		return dao.addManager(manager,warehouse);
	}
	
	@Override
	public ArrayList<WareHouse> getWareHouses() {
		return dao.getWareHouses();
	}
	
	@Override
	public WareHouse updateWareHouse(String name, String address, long contact,int warehouseid) {
	
		return dao.addWareHouse(name,address,contact,warehouseid);
	}

	@Override
	public String addProduct(Product p) {
		
		if(dao.addProduct(p)==null)
		{
			return "product addition failed";
		}
		else
		{
			return "product added successfully";
		}
			
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public String removeProduct(int p) {
		return dao.removeProduct(p);
	}

	@Override
	public String updateProduct(int p, double price) {
		return 	dao.updateProduct(p,price);
	}

	@Override
	public ArrayList<Transaction> transactionDetails(String startDate, String endDate) {
		try 
		{
			System.out.println("txdetails service");
			Date startdate=sdf.parse(startDate);
			Date enddate=sdf.parse(endDate);
			return dao.transactionDetails(startdate,enddate);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public WareHouse deleteWareHouse(int warehouseid) {
		
		return dao.deleteWareHouse(warehouseid);
	}
	
	@Override
	public ArrayList<Manager> getManagers() {
		return dao.getManagers();
	}
	
	@Override
	public Manager updateManager(String email, long contact1, String address, int mgrId) {
		return dao.updateManager(email, contact1, address, mgrId);		
	}
	
	@Override
	public Manager deleteManager(int mgrId) {
		return dao.deleteManager(mgrId);
	}
	
	@Override
	public ArrayList<Storage> getWareHouseStorage(int id) {
		return dao.getWareHouseStorage(id);
	}

	@Override
	public void addAdmin(Admin a) {
		 dao.addAdmin(a);
	}
}
