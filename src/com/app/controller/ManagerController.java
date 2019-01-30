package com.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojos.Customer;
import com.app.pojos.Manager;
import com.app.pojos.Product;
import com.app.pojos.Storage;
import com.app.pojos.Transaction;
import com.app.pojos.WareHouse;
import com.app.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController 
{
	@Autowired
	private ManagerService ms;
	
	@GetMapping("/getManager")
	public String getManager()
	{
		return "/manager/getManager";
	}
	
	@GetMapping("/validateManager")
	public String validateManager(@RequestParam String userName,@RequestParam String password,HttpSession hs,Model map)
	{
		System.out.println(userName + " " +password);
		Manager mgr=ms.validateManager(userName,password);
		if(mgr!=null)
		{
			hs.setAttribute("manager_dtls", mgr);
			return "/manager/indexManager";
		}
		else
		{
			map.addAttribute("login_status", "invalid login please try again");
			return "/manager/getManager";
		}
		
	}
	
	@GetMapping("/addCustomer")
	public String addCustomerForm(Customer cust)
	{
		System.out.println("in addCustomer");
		return "/manager/addCustomer";
	}

	@PostMapping("/addCustomer")
	public ModelAndView addCustomer(Customer cust)
	{
		String status=ms.addCustomer(cust);
		return new ModelAndView("/manager/indexManager","custstatus",status+"(custome id:"+cust.getCustomerId()+")");
	}
	
	@GetMapping("/removeCustomer")
	public ModelAndView removeCustomerForm()
	{
		ArrayList<Integer> alCustIds=ms.getCustIds();
		System.out.println(alCustIds);
		return new ModelAndView("/manager/removeCustomer","custIds", alCustIds);
	}
	
	@PostMapping("/removeCustomer")
	public ModelAndView removeCustomer(@RequestParam Integer customerId)
	{
		String status=ms.removeCustomer(customerId);
		return new ModelAndView("/manager/indexManager","custstatus",status);
	}
	
	@GetMapping("/updateCustomer")
	public ModelAndView updateCustomerrForm()
	{
		ArrayList<Integer> alCustIds=ms.getCustIds();
		System.out.println(alCustIds);
		return new ModelAndView("/manager/updateCustomer","custIds", alCustIds);
	}
	
	@PostMapping("/updateCustomer")
	public ModelAndView updateCustomer(@RequestParam Integer customerId,@RequestParam String contact,@RequestParam String address)
	{
		String status=ms.updateCustomer(customerId,contact,address);
		System.out.println(status);
		return new ModelAndView("/manager/indexManager","custstatus",status);
	}
	
	@GetMapping("/warehouseDetails")
	public String warehouseDetailsForm(HttpSession hs,Model map)
	{
		Integer mgrId=((Manager)hs.getAttribute("manager_dtls")).getEmpId();
		System.out.println(mgrId);
		WareHouse wh=ms.getWareHouseDetails(mgrId);
		map.addAttribute("warehouseDetails",wh);
		ArrayList<Storage> st=ms.getWareHouseStorage(wh.getWarehouseId());
		System.out.println(st);
		if(st!=null)
			map.addAttribute("StorageDetails", st);
		else
			map.addAttribute("StorageDetails","Storage not available");
		return "/manager/warehouseDetails";
	}



	@GetMapping("/purchaseProduct")
	public ModelAndView purchaseProductForm(Model map)
	{
		ArrayList<Integer> alCustIds=ms.getCustIds();
		map.addAttribute("custs", alCustIds);
		ArrayList<Product> products=ms.getAllProducts();
		System.out.println(products);
		return new ModelAndView("/manager/purchaseProduct","products",products);
	}

	@PostMapping("/purchaseProduct")
	public ModelAndView purchaseProduct(@RequestParam Integer customerId,@RequestParam String product,@RequestParam double quantity,HttpSession hs,Model map)
	{
		Integer mgrId=((Manager)hs.getAttribute("manager_dtls")).getEmpId();
		System.out.println(mgrId);
		Transaction t=ms.purchaseProduct(customerId,product,quantity,mgrId);
		
		if(t!=null)
		{
			map.addAttribute("txid", t.getTransactionId());
			map.addAttribute("product",product);
			return new ModelAndView("/manager/billGeneration","billContents",t);
		}
		else
		{
			return new ModelAndView("/manager/indexManager","purchaseProductstatus","product puchasing failed Try again!!!");
		}
		
	}
	
	
	@GetMapping("/ChangePassManager")
	public String getChangePasswordForm()
	{
		return "/manager/changePassword";
	}
	
	
	@PostMapping("/ChangePassManager")
	public ModelAndView changePass(@RequestParam String  userName,@RequestParam String password,@RequestParam String cnfPassword,HttpSession hs,Model map)
	{
		if(password.equals(cnfPassword))
		{
			int res=ms.changePass(userName,password);
			if(res==1)
			{
				return new ModelAndView("/manager/indexManager","custstatus","Password Changed Successfully!!!");
			}
			else
			{
				return new ModelAndView("/manager/indexManager","custstatus","Password updation failed ..Try again!!!");
			}
		}
		else
		{
			return new ModelAndView("/manager/indexManager","custstatus","Password and conform password not matched ..Try again!!!");
		}
		
	}

@GetMapping("/getIndexManager")
public String getIndexManager()
{
	return "/manager/indexManager";
}
	

@GetMapping("/logout")
public String logout(HttpSession hs,Model map,HttpServletResponse response,HttpServletRequest request)
{
	Manager m=(Manager) hs.getAttribute("manager_dtls");
	map.addAttribute("login_status", m.getFirstName()+" logged out successfully");
	hs.setAttribute("manager_dtls", null);
	hs.invalidate();
	//response.setHeader("refresh", "10;url=" + request.getContextPath());
	return "/manager/getManager";
}
	
}
