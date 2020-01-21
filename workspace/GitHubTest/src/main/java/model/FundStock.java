package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fund_stocks")
public class FundStock {
	@Id
	@Column(name = "fund_stock_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fundStockId;
	@Column(name = "fund_stock_amount")
	private int fundStockAmount;
	@Column(name = "fund_stock_sales")
	private int fundStockSales;
	@Column(name = "fund_stock_last")
	private int fundStocklast;
	@Column(name = "fund_stock_status")
	private String fundStockStatus;
	@Column(name = "fund_stock_date")
	private Date fundStockDate;
	@ManyToOne
	private FundProduct fundProduct;

	public int getFundStockId() {
		return fundStockId;
	}

	public void setFundStockId(int fundStockId) {
		this.fundStockId = fundStockId;
	}

	public int getFundStockAmount() {
		return fundStockAmount;
	}

	public void setFundStockAmount(int fundStockAmount) {
		this.fundStockAmount = fundStockAmount;
	}

	public int getFundStockSales() {
		return fundStockSales;
	}

	public void setFundStockSales(int fundStockSales) {
		this.fundStockSales = fundStockSales;
	}

	public int getFundStocklast() {
		return fundStocklast;
	}

	public void setFundStocklast(int fundStocklast) {
		this.fundStocklast = fundStocklast;
	}

	public String getFundStockStatus() {
		return fundStockStatus;
	}

	public void setFundStockStatus(String fundStockStatus) {
		this.fundStockStatus = fundStockStatus;
	}

	public Date getFundStockDate() {
		return fundStockDate;
	}

	public void setFundStockDate(Date fundStockDate) {
		this.fundStockDate = fundStockDate;
	}

	public FundProduct getFundProduct() {
		return fundProduct;
	}

	public void setFundProduct(FundProduct fundProduct) {
		this.fundProduct = fundProduct;
	}

}
