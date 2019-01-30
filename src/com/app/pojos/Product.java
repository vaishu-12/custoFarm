package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product 
{
	private Integer productId;
	private String productName;
	private double price;
	private List<Storage> storage;
	
	public Product() {
	System.out.println("in product def const");
	}

	public Product(Integer productId, String productName, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		}
	

	public Product( String productName, double price) {

		this.productName = productName;
		this.price = price;
		}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="product", fetch = FetchType.LAZY)
	public List<Storage> getStorage() {
		return storage;
	}

	public void setStorage(List<Storage> storage) {
		this.storage = storage;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}
	
}
