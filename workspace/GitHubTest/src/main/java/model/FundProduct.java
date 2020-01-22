package model;

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
@Table(name = "fund_products")
public class FundProduct {
	@Id
	@Column(name = "fund_product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fundProductId;
	
	@Column(name = "fund_product_itemno")
	private String fundProductItemNO;
	
	@Column(name = "fund_product_name")
	private String fundProductName;
	
	@Column(name = "fund_product_price")
	private int fundProductPrice;
	
	@Column(name = "fund_product_pic")
	private byte fundProductPic;
	
	@Column(name = "fund_product_status")
	private String fundProductStatus;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "fund_project_id")
	private FundProject fundProject;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fundProduct", cascade = CascadeType.ALL)
	private Set<FundStock> fundStocks = new HashSet<FundStock>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fundProduct", cascade = CascadeType.ALL)
	private Set<FundOrder> fundOrders = new HashSet<FundOrder>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funProduct", cascade = CascadeType.ALL)
	private Set<FundMsg> fundMsg = new HashSet<FundMsg>();

	public int getFundProductId() {
		return fundProductId;
	}

	public void setFundProductId(int fundProductId) {
		this.fundProductId = fundProductId;
	}

	public String getFundProductItemNO() {
		return fundProductItemNO;
	}

	public void setFundProductItemNO(String fundProductItemNO) {
		this.fundProductItemNO = fundProductItemNO;
	}

	public String getFundProductName() {
		return fundProductName;
	}

	public void setFundProductName(String fundProductName) {
		this.fundProductName = fundProductName;
	}

	public int getFundProductPrice() {
		return fundProductPrice;
	}

	public void setFundProductPrice(int fundProductPrice) {
		this.fundProductPrice = fundProductPrice;
	}

	public byte getFundProductPic() {
		return fundProductPic;
	}

	public void setFundProductPic(byte fundProductPic) {
		this.fundProductPic = fundProductPic;
	}

	public String getFundProductStatus() {
		return fundProductStatus;
	}

	public void setFundProductStatus(String fundProductStatus) {
		this.fundProductStatus = fundProductStatus;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public FundProject getFundProject() {
		return fundProject;
	}

	public void setFundProject(FundProject fundProject) {
		this.fundProject = fundProject;
	}

	public Set<FundStock> getFundStocks() {
		return fundStocks;
	}

	public void setFundStocks(Set<FundStock> fundStocks) {
		this.fundStocks = fundStocks;
	}

	public Set<FundOrder> getFundOrders() {
		return fundOrders;
	}

	public void setFundOrders(Set<FundOrder> fundOrders) {
		this.fundOrders = fundOrders;
	}

	public Set<FundMsg> getFundMsg() {
		return fundMsg;
	}

	public void setFundMsg(Set<FundMsg> fundMsg) {
		this.fundMsg = fundMsg;
	}

}
