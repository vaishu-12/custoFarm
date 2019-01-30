package com.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojos.Admin;
import com.app.pojos.Employee;
import com.app.pojos.Manager;
import com.app.pojos.Product;
import com.app.pojos.Storage;
import com.app.pojos.Transaction;
import com.app.pojos.WareHouse;
import com.app.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	public AdminController() {
		System.out.println("in admin controller");
	}
	
	@RequestMapping("/loginform")
	public String getAdminLoginForm()
	{
		return "/admin/loginform";
	}
	
	@RequestMapping("/validateAdmin")
	public String validateAdmin(@RequestParam String userName,@RequestParam String password,HttpSession hs,ModelMap map)
	{
		Employee e=(Employee)service.validateAdmin(userName,password);
		if(e!=null)
		{
			hs.setAttribute("admin", e);
			System.out.println("success");
			return "/admin/indexAdmin";
		}
		else
		{
			map.addAttribute("status","Invalid username or password, please try again");
			System.out.println("failure");
			return "/admin/loginform";
		}
	}
	
	@GetMapping("/addwarehouse")
	public ModelAndView addWareHouseForm(WareHouse warehouse)
	{
		System.out.println("in addwarehouse form mthd");
		return new ModelAndView("/admin/addwarehouse","warehouse",warehouse);
	}
	
	@PostMapping("/addwarehouse")
	public ModelAndView addWareHouse(WareHouse warehouse,HttpSession hs)
	{
		System.out.println("hi from "+warehouse);
		System.out.println("in addwarehouse  mthd");
		WareHouse w=service.addWareHouse(warehouse);
		hs.setAttribute("warehouse",w);
		System.out.println("added successfully");
		Manager m=new Manager();
		return new ModelAndView("/admin/addmanager","manager",m);
	}
	

	
	
	
	@GetMapping("/getWareHouses")
	public ModelAndView ShowWareHouses()
	{
		System.out.println("in getwarehouses");
		ArrayList<WareHouse> listWrhouse=service.getWareHouses();
		System.out.println(listWrhouse);
		return new ModelAndView("/admin/listwarehouse","listWrhouse",listWrhouse);
	}
	
	//for using path variable we have to take requestMapping can't be done by getmapping
	@RequestMapping(value="/updatewarehouseform") 
	public ModelAndView updateWareHouseForm(@RequestParam int warehouseId)//@PathVariable int id
	{
		System.out.println("in update"+warehouseId);
		System.out.println("in updatemanager form mthd"+warehouseId);
		return new ModelAndView("/admin/updatewarehouse","warehouseid",warehouseId);

	}
	
	@GetMapping("/updatewarehouse") 
	public ModelAndView updateWareHouse(@RequestParam int warehouseid,@RequestParam String name,@RequestParam String address,@RequestParam String contact,HttpSession hs)
	{
		System.out.println("in update warehouse");
		long contact1=Long.parseLong(contact);
		WareHouse warehouse=service.updateWareHouse(name,address,contact1,warehouseid);
		return new ModelAndView("/admin/indexAdmin","Status","updated successfully");
	}
	
	
	@GetMapping("/AddProduct")
	public String addProductForm(Product p)
	{
		return "/admin/addProductForm";
	}
	
	@PostMapping("/AddProduct")
	public ModelAndView addProduct(Product p)
	{
		return new ModelAndView("/admin/indexAdmin","Status",service.addProduct(p));
	}
	
	@GetMapping("/DeleteProduct")
	public ModelAndView deleteProductForm()
	{
		ArrayList<Product> products=service.getAllProducts();
		return new ModelAndView("/admin/DeleteProductForm","products",products);
	}
	
	@PostMapping("/DeleteProduct")
	public ModelAndView deleteProduct(@RequestParam String ProductId)
	{
		int productId=Integer.parseInt(ProductId.split(" ")[0]);
		System.out.println(productId);
		return new ModelAndView("/admin/indexAdmin","Status",service.removeProduct(productId));
	}
	
	@GetMapping("/GetAllProduct")
	public ModelAndView GetAllProduct()
	{
		ArrayList<Product> products=service.getAllProducts();
		System.out.println(products);
		return new ModelAndView("/admin/allProductDetails","products",products);
	}
	
	@GetMapping("/updateProduct")
	public ModelAndView updateProductForm()
	{
		ArrayList<Product> products=service.getAllProducts();
		return new ModelAndView("/admin/updateProductForm","products",products);
	}
	
	@PostMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam String ProductId,@RequestParam double price)
	{
		int productId=Integer.parseInt(ProductId.split(" ")[0]);
		System.out.println(productId);
		return new ModelAndView("/admin/indexAdmin","Status",service.updateProduct(productId,price));
	}
	
	@GetMapping("/transactionDetails")
	public String transactionDetails()
	{
		System.out.println("in tx");
		return "/admin/transactionDetailsForm";
	}
	
	@PostMapping("/transactionDetails")
	public ModelAndView transactionDetails(@RequestParam String startDate,@RequestParam String endDate,Model map)
	{
		map.addAttribute("dateBetween", "Transactions Between "+startDate+" & "+endDate);
		System.out.println("txdetails");
		ArrayList<Transaction> txs=service.transactionDetails(startDate,endDate);
		return new ModelAndView("/admin/allTransactions","txs",txs);
	}
	
	@GetMapping("/deletewarehouse") 
	public ModelAndView deleteWareHouse(@RequestParam int warehouseId,HttpSession hs)
	{
		System.out.println("in delete warehouse");
		WareHouse warehouse=service.deleteWareHouse(warehouseId);
		return new ModelAndView("/admin/indexAdmin","Status",warehouse.getWarehouseName()+" warehouse  deleted");
	}
	
	
	
	@GetMapping("/addmanager")
	public ModelAndView addManagerForm(Manager manager)
	{
		System.out.println("in addmanager form mthd");
		System.out.println("manager in in add man"+manager);
		return new ModelAndView("/admin/addmanager","manger",manager);
	}
	
	@PostMapping("/addmanager")
	public ModelAndView addManager(Manager manager,HttpSession hs)
	{
		System.out.println("hi from "+manager);
		System.out.println("in addmanager  mthd");
		Manager m=service.addManager(manager,(WareHouse)hs.getAttribute("warehouse"));
		System.out.println("add manager success");
		return new ModelAndView("/admin/indexAdmin","status",m.getFirstName()+"registered as manager");
	}
	
	
	@GetMapping("/getManagers")
	public ModelAndView ShowManagers()
	{
		System.out.println("in getmanagers");
		ArrayList<Manager> listManagers=service.getManagers();
		System.out.println(listManagers);
		return new ModelAndView("/admin/listmanagers","listManagers",listManagers);
	}
	
	
	@RequestMapping(value="/updatemanagerform") 
	public ModelAndView updateManagerForm(@RequestParam int mgrId)
	{
		System.out.println("in update mgr"+mgrId);
		System.out.println("in updatemanager form mthd"+mgrId);
		return new ModelAndView("/admin/updatemanager","mgrId",mgrId);

	}
	
	@GetMapping("/updateManager") 
	public ModelAndView updateManager(@RequestParam int mgrId,@RequestParam String email,@RequestParam String contact,@RequestParam String address,HttpSession hs)
	{
		System.out.println("in update mgr");
		
		try{
			long contact1=Long.parseLong(contact);
			Manager mgr=service.updateManager(email,contact1,address,mgrId);
			System.out.println("here i am3h"+mgr);
			return new ModelAndView("/admin/indexAdmin","Status","manager updated successfully");
		}
		catch(Exception e)
		{
			return new ModelAndView("/admin/indexAdmin","Status","Choose different Email(already Exists) or Invalid Contact no. ");
		}
		
	}

	@GetMapping("/deletemanager") 
	public ModelAndView deleteManager(@RequestParam int mgrId,HttpSession hs)
	{
		System.out.println("in delete mgr");
		Manager mgr=service.deleteManager(mgrId);
		return new ModelAndView("/admin/indexAdmin","Status","manager deleted successfully");
	}
	
	
	@GetMapping("/getWhContentsForm") 
	public ModelAndView WarehouseContentsForm()
	{
		System.out.println("in wh content form");
		ArrayList<WareHouse> listwh=service.getWareHouses();
		System.out.println(listwh);
		return new ModelAndView("/admin/whContents","listwh",listwh);
	}
	
	
	@GetMapping("/checkContents") 
	public ModelAndView WarehouseContents(@RequestParam String warehouse,Model map)
	{
		System.out.println("in wh contents");
		map.addAttribute("warehouse", warehouse);
		int id=Integer.parseInt(warehouse.split(" ")[0]);
		ArrayList<Storage> store=service.getWareHouseStorage(id);
		return new ModelAndView("/admin/whContentsDisplay","store",store);
	}
	
	




	@GetMapping("/getindexAdmin")
	public String getindexAdmin()
	{
		return "/admin/indexAdmin";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession hs,Model map,HttpServletResponse response,HttpServletRequest request)
	{
		Admin m=(Admin) hs.getAttribute("admin");
		map.addAttribute("status", m.getFirstName()+" logged out successfully");
		hs.setAttribute("admin", null);
		hs.invalidate();
		return "/admin/loginform";
	}
	
	
	
	@GetMapping("/addAdmin")
	public String addAdminrForm(Admin admin)
	{
		return "/admin/adminRegistration";
	}
	
	
	@PostMapping("/addAdmin")
	public String addAdmin(Admin admin,HttpSession hs)
	{
		service.addAdmin(admin);
		return "/finalPage";
	}
}

