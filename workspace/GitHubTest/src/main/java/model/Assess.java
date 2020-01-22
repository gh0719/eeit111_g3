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
@Table(name = "assess")
public class Assess {
	@Id
	@Column(name = "assess_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assessId;
	
	@Column(name = "assess_msg")
	private String assessMsg;
	
	@Column(name = "assess_grade")
	private String assessGrade;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public int getAssessId() {
		return assessId;
	}

	public void setAssessId(int assessId) {
		this.assessId = assessId;
	}

	public String getAssessMsg() {
		return assessMsg;
	}

	public void setAssessMsg(String assessMsg) {
		this.assessMsg = assessMsg;
	}

	public String getAssessGrade() {
		return assessGrade;
	}

	public void setAssessGrade(String assessGrade) {
		this.assessGrade = assessGrade;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
