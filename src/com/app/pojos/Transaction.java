package com.app.pojos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction 
{
	private Integer transactionId;
	private Customer customer;
	private Date transactionDate;
	private int units;
	private double totalAmt;
	public String product;
	
	public Transaction() {
		System.out.println("in transaction def const");
	}

	
	public Transaction(Integer transactionId, Date transactionDate, int units, double totalAmt,String product) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.units = units;
		this.totalAmt = totalAmt;
		this.product=product;
	}

	public Transaction(Customer customer, Date transactionDate, int units, double totalAmt,String product) {
		super();
		this.customer = customer;
		this.transactionDate = transactionDate;
		this.units = units;
		this.totalAmt = totalAmt;
		this.product=product;
	}


	public Transaction( Date transactionDate, int units, double totalAmt) {
		super();
		this.transactionDate = transactionDate;
		this.units = units;
		this.totalAmt = totalAmt;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	@Temporal(TemporalType.DATE)
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	

	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate="
				+ transactionDate + ", units=" + units + ", totalAmt=" + totalAmt + "]";
	}
	
	
}
