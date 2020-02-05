package com.fund.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fund_returns")
public class FundReturn {
	@Id
	@Column(name = "fund_return_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fundReturnId;
	
	@Column(name = "fund_return_total")
	private int fundReturnTotal;
	
	@Column(name = "fund_return_status")
	private String fundReturnStatus;
	
	@Column(name = "fund_return_method")
	private String fundReturnMethod;
	
	@Column(name = "fund_return_date")
	private Date fundReturnDate;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "fund_order_id")
	private FundOrder fundOrder;

	public int getFundReturnId() {
		return fundReturnId;
	}

	public void setFundReturnId(int fundReturnId) {
		this.fundReturnId = fundReturnId;
	}

	public int getFundReturnTotal() {
		return fundReturnTotal;
	}

	public void setFundReturnTotal(int fundReturnTotal) {
		this.fundReturnTotal = fundReturnTotal;
	}

	public String getFundReturnStatus() {
		return fundReturnStatus;
	}

	public void setFundReturnStatus(String fundReturnStatus) {
		this.fundReturnStatus = fundReturnStatus;
	}

	public String getFundReturnMethod() {
		return fundReturnMethod;
	}

	public void setFundReturnMethod(String fundReturnMethod) {
		this.fundReturnMethod = fundReturnMethod;
	}

	public Date getFundReturnDate() {
		return fundReturnDate;
	}

	public void setFundReturnDate(Date fundReturnDate) {
		this.fundReturnDate = fundReturnDate;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public FundOrder getFundOrder() {
		return fundOrder;
	}

	public void setFundOrder(FundOrder fundOrder) {
		this.fundOrder = fundOrder;
	}

}
