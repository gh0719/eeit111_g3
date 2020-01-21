package moderl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class Member {
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberId;
	@Column(name = "member_email")
	private String memberEmail;
	@Column(name = "member_pwd")
	private String memberPwd;
	@Column(name = "member_fname")
	private String memberFname;
	@Column(name = "member_sname")
	private String memberSname;
	@Column(name = "member_twid")
	private String memberTwid;
	@Column(name = "member_hb")
	private String memberHb;
	@Column(name = "member_gd")
	private String memberGd;
	@Column(name = "member_tel")
	private int memberTel;
	@Column(name = "member_cel")
	private int memberCel;
	@Column(name = "member_pic")
	private byte memberPic;
	@Column(name = "member_status")
	private String memberStatus;
	@OneToMany(mappedBy = "member")
	private Set<Msg> msgs = new HashSet<Msg>();
	@OneToMany(mappedBy = "member")
	private Set<Assess> assess = new HashSet<Assess>();
	@OneToMany(mappedBy = "member")
	private Set<FundOrder> fundOrders = new HashSet<FundOrder>();
	@OneToMany(mappedBy = "member")
	private Set<FundMsg> fundMsgs = new HashSet<FundMsg>();
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberFname() {
		return memberFname;
	}
	public void setMemberFname(String memberFname) {
		this.memberFname = memberFname;
	}
	public String getMemberSname() {
		return memberSname;
	}
	public void setMemberSname(String memberSname) {
		this.memberSname = memberSname;
	}
	public String getMemberTwid() {
		return memberTwid;
	}
	public void setMemberTwid(String memberTwid) {
		this.memberTwid = memberTwid;
	}
	public String getMemberHb() {
		return memberHb;
	}
	public void setMemberHb(String memberHb) {
		this.memberHb = memberHb;
	}
	public String getMemberGd() {
		return memberGd;
	}
	public void setMemberGd(String memberGd) {
		this.memberGd = memberGd;
	}
	public int getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(int memberTel) {
		this.memberTel = memberTel;
	}
	public int getMemberCel() {
		return memberCel;
	}
	public void setMemberCel(int memberCel) {
		this.memberCel = memberCel;
	}
	public byte getMemberPic() {
		return memberPic;
	}
	public void setMemberPic(byte memberPic) {
		this.memberPic = memberPic;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public Set<Msg> getMsgs() {
		return msgs;
	}
	public void setMsgs(Set<Msg> msgs) {
		this.msgs = msgs;
	}
	public Set<Assess> getAssess() {
		return assess;
	}
	public void setAssess(Set<Assess> assess) {
		this.assess = assess;
	}
	public Set<FundOrder> getFundOrders() {
		return fundOrders;
	}
	public void setFundOrders(Set<FundOrder> fundOrders) {
		this.fundOrders = fundOrders;
	}
	public Set<FundMsg> getFundMsgs() {
		return fundMsgs;
	}
	public void setFundMsgs(Set<FundMsg> fundMsgs) {
		this.fundMsgs = fundMsgs;
	}
	
	

}
