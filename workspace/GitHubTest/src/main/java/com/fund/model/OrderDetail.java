package com.fund.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetail {
	@Id
	@Column(name = "order_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailId;
	
	@Column(name = "order_detail_name")
	private String orderDetailName;
	
	@Column(name = "order_detail_amount")
	private int orderDetailAmount;
	
	@Column(name = "order_detail_price")
	private int orderDetailPrice;
	
	@Column(name = "order_delivery_name")
	private String orderDeliveryName;
	
	@Column(name = "order_delivery_method")
	private String orderDeliveryMethod;
	
	@Column(name = "order_delivery_number")
	private String orderDeliveryNumber;
	
	@Column(name = "order_delivery_status")
	private String orderDeliveryStatus;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "ordersDetail", cascade = CascadeType.ALL)
	private Set<Return> returns = new HashSet<Return>();

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getOrderDetailName() {
		return orderDetailName;
	}

	public void setOrderDetailName(String orderDetailName) {
		this.orderDetailName = orderDetailName;
	}

	public int getOrderDetailAmount() {
		return orderDetailAmount;
	}

	public void setOrderDetailAmount(int orderDetailAmount) {
		this.orderDetailAmount = orderDetailAmount;
	}

	public int getOrderDetailPrice() {
		return orderDetailPrice;
	}

	public void setOrderDetailPrice(int orderDetailPrice) {
		this.orderDetailPrice = orderDetailPrice;
	}

	public String getOrderDeliveryName() {
		return orderDeliveryName;
	}

	public void setOrderDeliveryName(String orderDeliveryName) {
		this.orderDeliveryName = orderDeliveryName;
	}

	public String getOrderDeliveryMethod() {
		return orderDeliveryMethod;
	}

	public void setOrderDeliveryMethod(String orderDeliveryMethod) {
		this.orderDeliveryMethod = orderDeliveryMethod;
	}

	public String getOrderDeliveryNumber() {
		return orderDeliveryNumber;
	}

	public void setOrderDeliveryNumber(String orderDeliveryNumber) {
		this.orderDeliveryNumber = orderDeliveryNumber;
	}

	public String getOrderDeliveryStatus() {
		return orderDeliveryStatus;
	}

	public void setOrderDeliveryStatus(String orderDeliveryStatus) {
		this.orderDeliveryStatus = orderDeliveryStatus;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<Return> getReturns() {
		return returns;
	}

	public void setReturns(Set<Return> returns) {
		this.returns = returns;
	}

}
