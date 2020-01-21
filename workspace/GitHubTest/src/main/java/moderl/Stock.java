package moderl;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "Stocks")
public class Stock {
	@Id
	@Column(name = "stock_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockId;
	@Column(name = "stock_amount")
	private int stockAmount;
	@Column(name = "stock_sales")
	private int stockSales;
	@Column(name = "stock_last")
	private int stocklast;
	@Column(name = "stock_status")
	private String stockStatus;
	@Column(name = "stock_date")
	private Date stockDate;
	@ManyToOne
	private Product product;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	public int getStockSales() {
		return stockSales;
	}

	public void setStockSales(int stockSales) {
		this.stockSales = stockSales;
	}

	public int getStocklast() {
		return stocklast;
	}

	public void setStocklast(int stocklast) {
		this.stocklast = stocklast;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
