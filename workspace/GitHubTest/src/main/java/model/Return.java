package model;

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
@Table(name = "returns")
public class Return {
	@Id
	@Column(name = "return_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int returnId;
	
	@Column(name = "return_Detail_Name")
	private String returnDetailName;
	
	@Column(name = "return_Detail_Amount")
	private int returnDetailAmount;
	
	@Column(name = "return_Detail_Price") 
	private int returnDetailPrice;
	
	@Column(name = "return_Total")
	private int returnTotal;
	
	@Column(name = "return_Status")
	private String returnStatus;
	
	@Column(name = "return_Reason")
	private String returnReason;
	
	@Column(name = "return_Method")
	private String returnMethod;
	
	@Column(name = "return_Date")
	private Date returnDate;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_detail_id")
	private OrderDetail ordersDetail;

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public String getReturnDetailName() {
		return returnDetailName;
	}

	public void setReturnDetailName(String returnDetailName) {
		this.returnDetailName = returnDetailName;
	}

	public int getReturnDetailAmount() {
		return returnDetailAmount;
	}

	public void setReturnDetailAmount(int returnDetailAmount) {
		this.returnDetailAmount = returnDetailAmount;
	}

	public int getReturnDetailPrice() {
		return returnDetailPrice;
	}

	public void setReturnDetailPrice(int returnDetailPrice) {
		this.returnDetailPrice = returnDetailPrice;
	}

	public int getReturnTotal() {
		return returnTotal;
	}

	public void setReturnTotal(int returnTotal) {
		this.returnTotal = returnTotal;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public String getReturnMethod() {
		return returnMethod;
	}

	public void setReturnMethod(String returnMethod) {
		this.returnMethod = returnMethod;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
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
