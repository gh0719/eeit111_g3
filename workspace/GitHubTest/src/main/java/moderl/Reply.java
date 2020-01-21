package moderl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "replys")
public class Reply {
	@Id
	@Column(name = "reply_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int replyId;
	@Column(name = "reply_pf")
	private String replyPf;
	@Column(name = "reply_pic")
	private byte replyPic;
	@ManyToOne
	private Store store;
	@ManyToOne
	private Msg msg;

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyPf() {
		return replyPf;
	}

	public void setReplyPf(String replyPf) {
		this.replyPf = replyPf;
	}

	public byte getReplyPic() {
		return replyPic;
	}

	public void setReplyPic(byte replyPic) {
		this.replyPic = replyPic;
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
