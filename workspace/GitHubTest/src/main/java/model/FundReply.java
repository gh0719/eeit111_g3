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
@Table(name = "fund_replys")
public class FundReply {
	@Id
	@Column(name = "fund_reply_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fundReplyId;
	
	@Column(name = "fund_reply_pf")
	private String fundReplyPf;
	
	@Column(name = "fund_reply_pic")
	private byte fundReplyPic;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "fund_msg_id")
	private FundMsg fundMsg;

	public int getFundReplyId() {
		return fundReplyId;
	}

	public void setFundReplyId(int fundReplyId) {
		this.fundReplyId = fundReplyId;
	}

	public String getFundReplyPf() {
		return fundReplyPf;
	}

	public void setFundReplyPf(String fundReplyPf) {
		this.fundReplyPf = fundReplyPf;
	}

	public byte getFundReplyPic() {
		return fundReplyPic;
	}

	public void setFundReplyPic(byte fundReplyPic) {
		this.fundReplyPic = fundReplyPic;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public FundMsg getFundMsg() {
		return fundMsg;
	}

	public void setFundMsg(FundMsg fundMsg) {
		this.fundMsg = fundMsg;
	}

}
