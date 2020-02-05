package com.fund.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private String replyPic;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "msg_id")
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



	public String getReplyPic() {
		return replyPic;
	}

	public void setReplyPic(String replyPic) {
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
