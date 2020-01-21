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
@Table(name = "fund_projects")
public class FundProject {
	@Id
	@Column(name = "fund_project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fundProjectId;
	@Column(name = "fund_project_title")
	private String fundProjectTitle;
	@Column(name = "fund_project_pf")
	private String fundProjectPf;
	@Column(name = "fund_project_total")
	private int fundProjectTotal;
	@Column(name = "fund_project_date")
	private int fundProjectDate;
	@Column(name = "fund_project_project")
	private byte fundProjectProject;
	@Column(name = "fund_project_status")
	private boolean fundProjectStatus;
	@ManyToOne
	private Member member;
	@OneToMany(mappedBy = "fundProject")
	private Set<FundProduct> fundProducts = new HashSet<FundProduct>();
	@OneToMany(mappedBy = "fundProject")
	private Set<FundSettle> fundSettles = new HashSet<FundSettle>();

	
	public int getFundProjectId() {
		return fundProjectId;
	}

	public void setFundProjectId(int fundProjectId) {
		this.fundProjectId = fundProjectId;
	}

	public String getFundProjectTitle() {
		return fundProjectTitle;
	}

	public void setFundProjectTitle(String fundProjectTitle) {
		this.fundProjectTitle = fundProjectTitle;
	}

	public String getFundProjectPf() {
		return fundProjectPf;
	}

	public void setFundProjectPf(String fundProjectPf) {
		this.fundProjectPf = fundProjectPf;
	}

	public int getFundProjectTotal() {
		return fundProjectTotal;
	}

	public void setFundProjectTotal(int fundProjectTotal) {
		this.fundProjectTotal = fundProjectTotal;
	}

	public int getFundProjectDate() {
		return fundProjectDate;
	}

	public void setFundProjectDate(int fundProjectDate) {
		this.fundProjectDate = fundProjectDate;
	}

	public byte getFundProjectProject() {
		return fundProjectProject;
	}

	public void setFundProjectProject(byte fundProjectProject) {
		this.fundProjectProject = fundProjectProject;
	}

	public boolean isFundProjectStatus() {
		return fundProjectStatus;
	}

	public void setFundProjectStatus(boolean fundProjectStatus) {
		this.fundProjectStatus = fundProjectStatus;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Set<FundProduct> getFundProducts() {
		return fundProducts;
	}

	public void setFundProducts(Set<FundProduct> fundProducts) {
		this.fundProducts = fundProducts;
	}

	public Set<FundSettle> getFundSettles() {
		return fundSettles;
	}

	public void setFundSettles(Set<FundSettle> fundSettles) {
		this.fundSettles = fundSettles;
	}

}
