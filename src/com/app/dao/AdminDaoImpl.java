package com.app.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Employee;
import com.app.pojos.Manager;
import com.app.pojos.Product;
import com.app.pojos.Storage;
import com.app.pojos.Transaction;
import com.app.pojos.WareHouse;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private SessionFactory sf;
	
	public AdminDaoImpl() {
		System.out.println("in admin dao impl");
	}
	
	@Override
	public Employee validateAdmin(String userName, String password) {
		System.out.println(userName +" "+password);
		String jpql="select e from Employee e where userName=:userName and password=:password";
		try{
			System.out.println("in validateAmin try");
			return (Employee)sf.getCurrentSession().createQuery(jpql,Employee.class).setParameter("userName", userName).setParameter("password",password).getSingleResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public WareHouse addWareHouse(WareHouse warehouse) {
		
		WareHouse w=sf.getCurrentSession().get(WareHouse.class,sf.getCurrentSession().save(warehouse));
		System.out.println("saved here");
		return w;
	}
	
	@Override
	public Manager addManager(Manager manager,WareHouse warehouse) {
		System.out.println("in dao addmanager");
		Manager m=sf.getCurrentSession().get(Manager.class,(Integer)sf.getCurrentSession().save(manager));
		
		
		
		MessageDigest md=null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			 md.update(("pass"+m.getEmail()).getBytes());
		      
		      //Compute the message digest
		      byte[] digest = md.digest();      
		      System.out.println(digest);  
		     
		      //Converting the byte array in to HexString format
		      StringBuffer encryptedPass = new StringBuffer();
		      
		      //Passing data to the created MessageDigest Object
		      for (int i = 0;i<digest.length;i++) {
		    	  encryptedPass.append(Integer.toHexString(0xFF & digest[i]));
		      }
		      System.out.println("Hex format : " + encryptedPass.toString());  
		      
		      
			
			
			
			m.setWarehouse(warehouse);
			m.setUserName("user"+m.getEmail());
			m.setPassword(encryptedPass.toString());
			m.setRole("manager");
			System.out.println("bye dao addmanager");
			

		} 
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	     
	 }
	
	
	@Override
	public ArrayList<WareHouse> getWareHouses() {
		String jpql="select w from WareHouse w";
		return (ArrayList<WareHouse>)sf.getCurrentSession().createQuery(jpql,WareHouse.class).getResultList();
	}
	
	@Override
	public WareHouse addWareHouse(String name, String address, long contact, int warehouseid) {
		WareHouse w=sf.getCurrentSession().get(WareHouse.class, warehouseid);
		System.out.println(w);
		w.setAddress(address);
		w.setContact(contact);
		w.setWarehouseName(name);
		System.out.println("in update wh success  & returning");
		return w;
	}

	@Override
	public Product addProduct(Product p) {
		try
		{
			sf.getCurrentSession().save(p);
			return p;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		try
		{
			String jpql="select p from Product p";
			ArrayList<Product> products=(ArrayList<Product>) sf.getCurrentSession().createQuery(jpql,Product.class).getResultList();
			return products;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public String removeProduct(int p) {
		try
		{
			sf.getCurrentSession().delete(sf.getCurrentSession().get(Product.class,p));
			return "product removed successfuly";
		}
		catch(Exception e)
		{
			e.addSuppressed(e);
			return "product deletion failed";
		}
	}

	@Override
	public String updateProduct(int p, double price) {
		try
		{
			Product prd=sf.getCurrentSession().get(Product.class,p);
			prd.setPrice(price);
			return "product updated successfuly";
		}
		catch(Exception e)
		{
			e.addSuppressed(e);
			return "product updation failed";
		}
	}

	@Override
	public ArrayList<Transaction> transactionDetails(Date startDate, Date endDate) {
		ArrayList<Transaction> ResTxs=new ArrayList<>();
		try
		{
			System.out.println("txdetails dao");
			String jpql="select t from Transaction t";
			ArrayList<Transaction> txs=(ArrayList<Transaction>) sf.getCurrentSession().createQuery(jpql,Transaction.class).getResultList();
			
			txs.forEach(tx->
			{
				if(tx.getTransactionDate().after(startDate) && tx.getTransactionDate().before(endDate))
					ResTxs.add(tx);
			});
			System.out.println(ResTxs.size());
			return ResTxs;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	
	}


	
	@Override
	public ArrayList<Manager> getManagers() {
		String jpql="select m from Manager m";
		return (ArrayList<Manager>)sf.getCurrentSession().createQuery(jpql,Manager.class).getResultList();

	}
	

	
	
	@Override
	public WareHouse deleteWareHouse(int warehouseid) {
		WareHouse w=sf.getCurrentSession().get(WareHouse.class,warehouseid);
		sf.getCurrentSession().remove(w);
		return w;
	}
	
	@Override
	public Manager updateManager(String email, long contact1, String address, int mgrId) {
		Manager m=null;
		try
		{
			m=sf.getCurrentSession().get(Manager.class, mgrId);
			m.setAddress(address);
			m.setContact(contact1);
			m.setEmail(email);
			return m;
		}
		catch(Exception e)
		{
			System.out.println(m);
			return null;
		}
		
	}
	
	@Override
	public Manager deleteManager(int mgrId) {
		Manager m=sf.getCurrentSession().get(Manager.class,mgrId);
		sf.getCurrentSession().remove(m);
		return m;
	}
	
	@Override
	public ArrayList<Storage> getWareHouseStorage(int id){
		String jpql="select s from Storage s where warehouse=:w";
		WareHouse w=sf.getCurrentSession().get(WareHouse.class,id);
		System.out.println("warehouse "+w);
		
		ArrayList<Storage> store=(ArrayList<Storage>)sf.getCurrentSession().createQuery(jpql,Storage.class).setParameter("w",w).getResultList();
		return store;
	}

	@Override
	public void addAdmin(Admin a) {
		
		try
		{
			sf.getCurrentSession().save(a);
			a.setRole("admin");
			a.setUserName(a.getEmail());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
