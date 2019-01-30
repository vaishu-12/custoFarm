package com.app.pojos;

import javax.persistence.*;

@Entity
public class Storage 
{
	private Integer storageId;
	private WareHouse warehouse;
	private Product product;
	private double quantity;



	public Storage(WareHouse warehouse, Product product, double quantity) {
		super();
		this.warehouse = warehouse;
		this.product = product;
		this.quantity = quantity;
	}


	public Storage()
	{
		 System.out.println("in Storage def const");
	}


	public Storage(Integer storageId, double quantity) {
		super();
		this.storageId = storageId;
		this.quantity = quantity;
	}
	

	public Storage( double quantity) {
		super();
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getStorageId() {
		return storageId;
	}


	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	public WareHouse getWarehouse() {
		return warehouse;
	}


	public void setWarehouse(WareHouse warehouse) {
		this.warehouse = warehouse;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	
	public double getquantity() {
		return quantity;
	}


	public void setquantity(double quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "Storage [storageId=" + storageId + ", warehouse=" + warehouse + ", product=" + product + ", quantity="
				+ quantity + "]";
	}
	
	
	
}
