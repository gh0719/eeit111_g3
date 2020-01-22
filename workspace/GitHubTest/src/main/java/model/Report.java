package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reports")
public class Report {
	@Id
	@Column(name = "report_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ReportId;
	
	@Column(name = "report_tital")
	private String ReportTital;
	
	@Column(name = "report_pf")
	private String ReportPf;
	
	@Column(name = "report_status")
	private String ReportStatus;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public int getReportId() {
		return ReportId;
	}

	public void setReportId(int reportId) {
		ReportId = reportId;
	}

	public String getReportTital() {
		return ReportTital;
	}

	public void setReportTital(String reportTital) {
		ReportTital = reportTital;
	}

	public String getReportPf() {
		return ReportPf;
	}

	public void setReportPf(String reportPf) {
		ReportPf = reportPf;
	}

	public String getReportStatus() {
		return ReportStatus;
	}

	public void setReportStatus(String reportStatus) {
		ReportStatus = reportStatus;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
