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
@Table(name = "Product_Returns")
public class ProductReturn {
	@Id
	@Column(name = "product_Return_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productReturnId;
	
	@Column(name = "product_Return_Detail_Name")
	private String productReturnDetailName;
	
	@Column(name = "product_Return_Detail_Amount")
	private int productReturnDetailAmount;
	
	@Column(name = "product_Return_Detail_Price") 
	private int productReturnDetailPrice;
	
	@Column(name = "product_Return_Total")
	private int productReturnTotal;
	
	@Column(name = "product_Return_Status")
	private String productReturnStatus;
	
	@Column(name = "product_Return_Reason")
	private String productReturnReason;
	
	@Column(name = "product_Return_Method")
	private String productReturnMethod;
	
	@Column(name = "product_Return_Date")
	private Date productReturnDate;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_detail_id")
	private OrderDetail ordersDetail;

	public int getProductReturnId() {
		return productReturnId;
	}

	public void setProductReturnId(int productReturnId) {
		this.productReturnId = productReturnId;
	}

	public String getProductReturnDetailName() {
		return productReturnDetailName;
	}

	public void setProductReturnDetailName(String productReturnDetailName) {
		this.productReturnDetailName = productReturnDetailName;
	}

	public int getProductReturnDetailAmount() {
		return productReturnDetailAmount;
	}

	public void setProductReturnDetailAmount(int productReturnDetailAmount) {
		this.productReturnDetailAmount = productReturnDetailAmount;
	}

	public int getProductReturnDetailPrice() {
		return productReturnDetailPrice;
	}

	public void setProductReturnDetailPrice(int productReturnDetailPrice) {
		this.productReturnDetailPrice = productReturnDetailPrice;
	}

	public int getProductReturnTotal() {
		return productReturnTotal;
	}

	public void setProductReturnTotal(int productReturnTotal) {
		this.productReturnTotal = productReturnTotal;
	}

	public String getProductReturnStatus() {
		return productReturnStatus;
	}

	public void setProductReturnStatus(String productReturnStatus) {
		this.productReturnStatus = productReturnStatus;
	}

	public String getProductReturnReason() {
		return productReturnReason;
	}

	public void setProductReturnReason(String productReturnReason) {
		this.productReturnReason = productReturnReason;
	}

	public String getProductReturnMethod() {
		return productReturnMethod;
	}

	public void setProductReturnMethod(String productReturnMethod) {
		this.productReturnMethod = productReturnMethod;
	}

	public Date getProductReturnDate() {
		return productReturnDate;
	}

	public void setProductReturnDate(Date productReturnDate) {
		this.productReturnDate = productReturnDate;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderDetail getOrdersDetail() {
		return ordersDetail;
	}

	public void setOrdersDetail(OrderDetail ordersDetail) {
		this.ordersDetail = ordersDetail;
	}

	

}
