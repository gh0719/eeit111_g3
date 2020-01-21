package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fund_orders")
public class FundOrder {
	@Id
	@Column(name = "fund_order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fundOrderId;
	@Column(name = "fund_order_status")
	private String fundOrderStatus;
	@Column(name = "fund_order_date")
	private Date fundOrderDate;
	@Column(name = "fund_order_products_name")
	private String fundOrderProductsName;
	@Column(name = "fund_order_price")
	private int fundOrderPrice;
	@Column(name = "fund_order_extra_price")
	private int fundOrderExtraPrice;
	@Column(name = "fund_order_total")
	private int fundOrderTotal;
	@Column(name = "fund_oorder_delivery_name")
	private String fundOorderDeliveryName;
	@Column(name = "fund_order_delivery_method")
	private String fundOrderDeliveryMethod;
	@Column(name = "fund_order_delivery_number")
	private String fundOrderDeliveryNumber;
	@Column(name = "fund_order_name")
	private String fundOrderName;
	@Column(name = "fund_order_phone")
	private int fundOrderPhone;
	@Column(name = "fund_order_address")
	private String fundOrderAddress;
	@ManyToOne
	private Member member;
	@ManyToOne
	private FundSettle fundSettle;
	@ManyToOne
	private FundProduct fundProduct;
	@OneToMany(mappedBy = "fundOrder")
	private Set<FundReturn> fundReturns = new HashSet<FundReturn>();

	public int getFundOrderId() {
		return fundOrderId;
	}

	public void setFundOrderId(int fundOrderId) {
		this.fundOrderId = fundOrderId;
	}

	public String getFundOrderStatus() {
		return fundOrderStatus;
	}

	public void setFundOrderStatus(String fundOrderStatus) {
		this.fundOrderStatus = fundOrderStatus;
	}

	public Date getFundOrderDate() {
		return fundOrderDate;
	}

	public void setFundOrderDate(Date fundOrderDate) {
		this.fundOrderDate = fundOrderDate;
	}

	public String getFundOrderProductsName() {
		return fundOrderProductsName;
	}

	public void setFundOrderProductsName(String fundOrderProductsName) {
		this.fundOrderProductsName = fundOrderProductsName;
	}

	public int getFundOrderPrice() {
		return fundOrderPrice;
	}

	public void setFundOrderPrice(int fundOrderPrice) {
		this.fundOrderPrice = fundOrderPrice;
	}

	public int getFundOrderExtraPrice() {
		return fundOrderExtraPrice;
	}

	public void setFundOrderExtraPrice(int fundOrderExtraPrice) {
		this.fundOrderExtraPrice = fundOrderExtraPrice;
	}

	public int getFundOrderTotal() {
		return fundOrderTotal;
	}

	public void setFundOrderTotal(int fundOrderTotal) {
		this.fundOrderTotal = fundOrderTotal;
	}

	public String getFundOorderDeliveryName() {
		return fundOorderDeliveryName;
	}

	public void setFundOorderDeliveryName(String fundOorderDeliveryName) {
		this.fundOorderDeliveryName = fundOorderDeliveryName;
	}

	public String getFundOrderDeliveryMethod() {
		return fundOrderDeliveryMethod;
	}

	public void setFundOrderDeliveryMethod(String fundOrderDeliveryMethod) {
		this.fundOrderDeliveryMethod = fundOrderDeliveryMethod;
	}

	public String getFundOrderDeliveryNumber() {
		return fundOrderDeliveryNumber;
	}

	public void setFundOrderDeliveryNumber(String fundOrderDeliveryNumber) {
		this.fundOrderDeliveryNumber = fundOrderDeliveryNumber;
	}

	public String getFundOrderName() {
		return fundOrderName;
	}

	public void setFundOrderName(String fundOrderName) {
		this.fundOrderName = fundOrderName;
	}

	public int getFundOrderPhone() {
		return fundOrderPhone;
	}

	public void setFundOrderPhone(int fundOrderPhone) {
		this.fundOrderPhone = fundOrderPhone;
	}

	public String getFundOrderAddress() {
		return fundOrderAddress;
	}

	public void setFundOrderAddress(String fundOrderAddress) {
		this.fundOrderAddress = fundOrderAddress;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public FundSettle getFundSettle() {
		return fundSettle;
	}

	public void setFundSettle(FundSettle fundSettle) {
		this.fundSettle = fundSettle;
	}

	public FundProduct getFundProduct() {
		return fundProduct;
	}

	public void setFundProduct(FundProduct fundProduct) {
		this.fundProduct = fundProduct;
	}

	public Set<FundReturn> getFundReturns() {
		return fundReturns;
	}

	public void setFundReturns(Set<FundReturn> fundReturns) {
		this.fundReturns = fundReturns;
	}

}
