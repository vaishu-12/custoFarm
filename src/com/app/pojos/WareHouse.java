package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class WareHouse 
{
	private Integer warehouseId;
	private String warehouseName;
	private String address;
	private long contact;
	private Manager mgr;
	private List<Storage> str;
	

	public WareHouse() {
	System.out.println("in warehouse def constr");
	}

	public WareHouse(Integer warehouseId, String warehouseName, String address, long contact) {
		super();
		this.warehouseId = warehouseId;
		this.warehouseName = warehouseName;
		this.address = address;
		this.contact = contact;

	}

	public WareHouse(String warehouseName, String address, long contact) {
		super();
		this.warehouseName = warehouseName;
		this.address = address;
		this.contact = contact;

	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	@OneToOne(cascade=CascadeType.ALL,mappedBy="warehouse")
	public Manager getMgr() {
		return mgr;
	}

	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="warehouse")
	public List<Storage> getStr() {
		return str;
	}

	public void setStr(List<Storage> str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "WareHouse [warehouseId=" + warehouseId + ", warehouseName=" + warehouseName + ", address=" + address
				+ ", contact=" + contact + ", mgr=" + mgr + "]";
	}
	
	public void addMgr(String firstName, String lastName, String email, long contact, String address)
	{
		Manager s=new Manager(firstName, lastName, email, contact, address);
		s.setWarehouse(this);
		this.setMgr(s);
	}
	
	public void addStorage( double quantity,Product product)
	{
		Storage s=new Storage();
		str.add(s);
		s.setquantity(quantity);
		s.setProduct(product);
	}
	
}
