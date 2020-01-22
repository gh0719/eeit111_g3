package model;

import java.util.Date;
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
@Table(name = "msgs")
public class Msg {
	@Id
	@Column(name = "msg_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int msgId;
	
	@Column(name = "msg_tital")
	private String msgTital;
	
	@Column(name = "msg_pf")
	private String msgPf;
	
	@Column(name = "msg_pic")
	private byte msgPic;
	
	@Column(name = "msg_date")
	private Date msgDate;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "msg", cascade = CascadeType.ALL)
	private Set<Reply> replys = new HashSet<Reply>();

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public String getMsgTital() {
		return msgTital;
	}

	public void setMsgTital(String msgTital) {
		this.msgTital = msgTital;
	}

	public String getMsgPf() {
		return msgPf;
	}

	public void setMsgPf(String msgPf) {
		this.msgPf = msgPf;
	}

	public byte getMsgPic() {
		return msgPic;
	}

	public void setMsgPic(byte msgPic) {
		this.msgPic = msgPic;
	}

	public Date getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
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

	public Set<Reply> getReplys() {
		return replys;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}

}
