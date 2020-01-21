package moderl;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private Store store;
	@ManyToOne
	private FundProject fundProject;
	@OneToMany(mappedBy = "fundProduct")
	private Set<FundStock> fundStocks = new HashSet<FundStock>();
	@OneToMany(mappedBy = "fundProduct")
	private Set<FundOrder> fundOrders = new HashSet<FundOrder>();
	@OneToMany(mappedBy = "funProduct")
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
