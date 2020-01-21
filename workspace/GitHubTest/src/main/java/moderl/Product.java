package moderl;

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
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Column(name = "product_itemno")
	private String productItemNO;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_price")
	private int productPrice;
	@Column(name = "product_pic")
	private byte productPic;
	@Column(name = "product_status")
	private String productStatus;
	@ManyToOne
	private Store store;
	@OneToMany(mappedBy = "product")
	private Set<Stock> stocks = new HashSet<Stock>();
	@OneToMany(mappedBy = "product")
	private Set<OrderDetail> ordersDetails = new HashSet<OrderDetail>();
	@OneToMany(mappedBy = "product")
	private Set<Return> returns = new HashSet<Return>();
	@OneToMany(mappedBy = "product")
	private Set<Msg> msgs = new HashSet<Msg>();

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductItemNO() {
		return productItemNO;
	}

	public void setProductItemNO(String productItemNO) {
		this.productItemNO = productItemNO;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public byte getProductPic() {
		return productPic;
	}

	public void setProductPic(byte productPic) {
		this.productPic = productPic;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

	public Set<OrderDetail> getOrdersDetails() {
		return ordersDetails;
	}

	public void setOrdersDetails(Set<OrderDetail> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}

	public Set<Return> getReturns() {
		return returns;
	}

	public void setReturns(Set<Return> returns) {
		this.returns = returns;
	}

	public Set<Msg> getMsgs() {
		return msgs;
	}

	public void setMsgs(Set<Msg> msgs) {
		this.msgs = msgs;
	}

}
