package moderl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "fund_settles")
public class FundSettle {
	@Id
	@Column(name = "fund_settle_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fundSettleId;
	@Column(name = "fund_settle_fdate")
	private Date fundSettleFdate;
	@Column(name = "fund_settle_ldate")
	private Date fundSettleLdate;
	@Column(name = "fund_settle_total")
	private int fundSettleTotal;
	@Column(name = "fund_settle_status")
	private boolean fundSettleStatus;
	@ManyToOne
	private FundProject fundProject;
	@OneToMany(mappedBy = "fundSettle")
	private Set<FundOrder> fundOrders = new HashSet<FundOrder>();

	public int getFundSettleId() {
		return fundSettleId;
	}

	public void setFundSettleId(int fundSettleId) {
		this.fundSettleId = fundSettleId;
	}

	public Date getFundSettleFdate() {
		return fundSettleFdate;
	}

	public void setFundSettleFdate(Date fundSettleFdate) {
		this.fundSettleFdate = fundSettleFdate;
	}

	public Date getFundSettleLdate() {
		return fundSettleLdate;
	}

	public void setFundSettleLdate(Date fundSettleLdate) {
		this.fundSettleLdate = fundSettleLdate;
	}

	public int getFundSettleTotal() {
		return fundSettleTotal;
	}

	public void setFundSettleTotal(int fundSettleTotal) {
		this.fundSettleTotal = fundSettleTotal;
	}

	public boolean isFundSettleStatus() {
		return fundSettleStatus;
	}

	public void setFundSettleStatus(boolean fundSettleStatus) {
		this.fundSettleStatus = fundSettleStatus;
	}

	public FundProject getFundProject() {
		return fundProject;
	}

	public void setFundProject(FundProject fundProject) {
		this.fundProject = fundProject;
	}

	public Set<FundOrder> getFundOrders() {
		return fundOrders;
	}

	public void setFundOrders(Set<FundOrder> fundOrders) {
		this.fundOrders = fundOrders;
	}

}
