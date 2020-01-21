package moderl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private Store store;
	@ManyToOne
	private Msg msg;

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

	public Msg getMsg() {
		return msg;
	}

	public void setMsg(Msg msg) {
		this.msg = msg;
	}

}
