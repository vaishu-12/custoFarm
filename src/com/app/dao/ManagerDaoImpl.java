package com.app.dao;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Customer;
import com.app.pojos.Employee;
import com.app.pojos.Manager;
import com.app.pojos.Product;
import com.app.pojos.Storage;
import com.app.pojos.Transaction;
import com.app.pojos.WareHouse;

@Transactional
@Repository
public class ManagerDaoImpl implements ManagerDao 
{
	@Autowired
	private SessionFactory sf;

	@Override
	public Manager validateManager(String userName, String password) 
	{
		String jpql="select e from Employee e where e.userName=:userName and e.password=:password";
		try
		{
			
			 MessageDigest md = MessageDigest.getInstance("SHA-256");

		      //Passing data to the created MessageDigest Object
		      md.update(password.getBytes());
		      
		      //Compute the message digest
		      byte[] digest = md.digest();      
		      System.out.println(digest);  
		     
		      //Converting the byte array in to HexString format
		      StringBuffer encryptedPass = new StringBuffer();
		      
		      for (int i = 0;i<digest.length;i++) {
		    	  encryptedPass.append(Integer.toHexString(0xFF & digest[i]));
		      }
		      System.out.println("Hex format : " + encryptedPass.toString());  
		      
		      
		      
		      
		      
			//System.out.println("s0");
			Employee e=sf.getCurrentSession().createQuery(jpql, Employee.class).setParameter("userName", userName).setParameter("password", encryptedPass.toString()).getSingleResult();
			//System.out.println("s1");
			Integer managerId=e.getEmpId();
			//System.out.println("s1");
			Manager m=sf.getCurrentSession().get(Manager.class,managerId);
			//System.out.println("s2");
			return m;
		}
		catch(Exception e)
		{
			System.out.println("s3"+e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String addCustomer(Customer cust) {
		
		try
		{
			sf.getCurrentSession().save(cust);
			return "Customer added successfully";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Customer addition failed";
		}
		
	}

	@Override
	public String removeCustomer(Integer customerId) 
	{
		try
		{
			Customer cust=sf.getCurrentSession().get(Customer.class, customerId);
			sf.getCurrentSession().delete(cust);
			return "Customer "+customerId+" removed successfully";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Customer remove failed";
		}
	}

	@Override
	public ArrayList<Integer> getCustIds() 
	{
		ArrayList<Integer> custIds;
		String jpql="select customerId from Customer";
		try
		{
			custIds=(ArrayList<Integer>) sf.getCurrentSession().createQuery(jpql,Integer.class).getResultList();
			return custIds;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String updateCustomer(Integer customerId, String contact, String address) {
		try
		{
			Customer c=sf.getCurrentSession().get(Customer.class, customerId);
			c.setAddress(address);
			c.setContact(Long.parseLong(contact));
			return "customer "+customerId+" info updated successfully";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "customer "+customerId+"info  not updated";
		}
	}

	@Override
	public WareHouse getWareHouseDetails(Integer mgrId) {
		try
		{
			WareHouse wh=sf.getCurrentSession().get(Manager.class,mgrId).getWarehouse();
			System.out.println(wh);
			return wh;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Storage> getWareHouseStorage(Integer WareHouseId) {

	
		try
		{
			WareHouse wh=sf.getCurrentSession().get(WareHouse.class,WareHouseId);
			String jpql="select s from Storage s where s.warehouse=:Inwh";
			ArrayList<Storage> storages=(ArrayList<Storage>) sf.getCurrentSession().createQuery(jpql,Storage.class).setParameter("Inwh",wh).getResultList();
			return storages;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Transaction purchaseProduct(Integer customerId, String product, double quantity,Integer mgrId)
	{
		try
		{
			Customer c=sf.getCurrentSession().get(Customer.class,customerId);
			String jpql="select p from Product p where p.productName=:product";
			Product p=sf.getCurrentSession().createQuery(jpql, Product.class).setParameter("product",product).getSingleResult();
			Manager m=sf.getCurrentSession().get(Manager.class,mgrId);
			WareHouse w=sf.getCurrentSession().get(WareHouse.class,m.getWarehouse().getWarehouseId());
			Storage st=null;
			
			
			String jpql1="select s from Storage s where s.warehouse=:w and s.product=:p";
			try
			{
				st=sf.getCurrentSession().createQuery(jpql1,Storage.class).setParameter("w",w).setParameter("p",p).getSingleResult();
				st.setquantity(st.getquantity()+quantity);
				Transaction t=new Transaction(c, new Date(),(int)quantity,quantity*p.getPrice(),product);
				sf.getCurrentSession().save(t);
				sf.getCurrentSession().save(st);
				return t;
			}
			catch(Exception e)
			{
				Storage st1=new Storage(w,p,quantity);
				Transaction t=new Transaction(c, new Date(),(int)quantity,quantity*p.getPrice(),product);
				sf.getCurrentSession().save(t);
				sf.getCurrentSession().save(st1);
				return t;
			}
			/*if(st!= null)
			{
				st.setquantity(st.getquantity()+quantity);
				Transaction t=new Transaction(c, new Date(),(int)quantity,quantity*p.getPrice(),product);
				sf.getCurrentSession().save(t);
				return t;
			}
			else
			{
				Storage st1=new Storage(w,p,quantity);
				Transaction t=new Transaction(c, new Date(),(int)quantity,quantity*p.getPrice(),product);
				sf.getCurrentSession().save(t);
				return t;
				
			}*/
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
			ArrayList<Product> products=(ArrayList<Product>) sf.getCurrentSession().createQuery("select p from Product p", Product.class).getResultList();
			return products;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int changePass(String userName, String password) {
		try
		{
			
			
			 
			MessageDigest md = MessageDigest.getInstance("SHA-256");

		      //Passing data to the created MessageDigest Object
		      md.update(password.getBytes());
		      
		      //Compute the message digest
		      byte[] digest = md.digest();      
		      System.out.println(digest);  
		     
		      //Converting the byte array in to HexString format
		      StringBuffer encryptedPass = new StringBuffer();
		      
		      for (int i = 0;i<digest.length;i++) {
		    	  encryptedPass.append(Integer.toHexString(0xFF & digest[i]));
		      }
		      System.out.println("Hex format : " + encryptedPass.toString());  
			
			
			
			sf.getCurrentSession().createQuery("update Employee set password=:pass where userName=:userName").setParameter("userName",userName).setParameter("pass",encryptedPass.toString()).executeUpdate();
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	
	}
}
