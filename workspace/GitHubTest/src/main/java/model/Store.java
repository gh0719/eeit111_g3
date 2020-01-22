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
@Table(name = "stores")
public class Store {
	@Id
	@Column(name = "store_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	
	@Column(name = "store_Name")
	private String storeName;
	
	@Column(name = "store_pf")
	private String storePf;
	
	@Column(name = "store_tel")
	private int storeTel;
	
	@Column(name = "store_pic")
	private byte storePic;
	
	@Column(name = "store_address")
	private String storeAddress;
	
	@Column(name = "store_number")
	private int storeNumber;
	
	@Column(name = "store_account")
	private int storeAccount;
	
	@Column(name = "store_pi_name")
	private String storePiName;
	
	@Column(name = "store_pi_twid")
	private String storePiTwid;
	
	@Column(name = "store_pi_tel")
	private int storePiTel;
	
	@Column(name = "store_pi_address")
	private String storePiAddress;
	
	@Column(name = "store_status")
	private String storeStatus;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
	private Set<FundProject> FundProjects = new HashSet<FundProject>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
	private Set<Product> Products = new HashSet<Product>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
	private Set<OrderDetail> ordersDetails = new HashSet<OrderDetail>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
	private Set<Return> returns = new HashSet<Return>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
	private Set<Reply> replys = new HashSet<Reply>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
	private Set<FundProduct> fundProducts = new HashSet<FundProduct>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
	private Set<FundReturn> fundReturns = new HashSet<FundReturn>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
	private Set<FundReply> fundReplys = new HashSet<FundReply>();

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStorePf() {
		return storePf;
	}

	public void setStorePf(String storePf) {
		this.storePf = storePf;
	}

	public int getStoreTel() {
		return storeTel;
	}

	public void setStoreTel(int storeTel) {
		this.storeTel = storeTel;
	}

	public byte getStorePic() {
		return storePic;
	}

	public void setStorePic(byte storePic) {
		this.storePic = storePic;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public int getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}

	public int getStoreAccount() {
		return storeAccount;
	}

	public void setStoreAccount(int storeAccount) {
		this.storeAccount = storeAccount;
	}

	public String getStorePiName() {
		return storePiName;
	}

	public void setStorePiName(String storePiName) {
		this.storePiName = storePiName;
	}

	public String getStorePiTwid() {
		return storePiTwid;
	}

	public void setStorePiTwid(String storePiTwid) {
		this.storePiTwid = storePiTwid;
	}

	public int getStorePiTel() {
		return storePiTel;
	}

	public void setStorePiTel(int storePiTel) {
		this.storePiTel = storePiTel;
	}

	public String getStorePiAddress() {
		return storePiAddress;
	}

	public void setStorePiAddress(String storePiAddress) {
		this.storePiAddress = storePiAddress;
	}

	public String getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Set<FundProject> getFundProjects() {
		return FundProjects;
	}

	public void setFundProjects(Set<FundProject> fundProjects) {
		FundProjects = fundProjects;
	}

	public Set<Product> getProducts() {
		return Products;
	}

	public void setProducts(Set<Product> products) {
		Products = products;
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

	public Set<Reply> getReplys() {
		return replys;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}

	public Set<FundProduct> getFundProducts() {
		return fundProducts;
	}

	public void setFundProducts(Set<FundProduct> fundProducts) {
		this.fundProducts = fundProducts;
	}

	public Set<FundReturn> getFundReturns() {
		return fundReturns;
	}

	public void setFundReturns(Set<FundReturn> fundReturns) {
		this.fundReturns = fundReturns;
	}

	public Set<FundReply> getFundReplys() {
		return fundReplys;
	}

	public void setFundReplys(Set<FundReply> fundReplys) {
		this.fundReplys = fundReplys;
	}

}
