package com.fund.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String memberTel;
	
	@Column(name = "member_cel")
	private String memberCel;
	
	@Column(name = "member_pic")
	private String memberPic;
	
	@Column(name = "member_status")
	private String memberStatus;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
	private Set<Store> stores = new HashSet<Store>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
	private Set<Order> orders = new HashSet<Order>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
	private Set<Msg> msgs = new HashSet<Msg>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
	private Set<Assess> assess = new HashSet<Assess>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
	private Set<FundOrder> fundOrders = new HashSet<FundOrder>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
	private Set<FundMsg> fundMsgs = new HashSet<FundMsg>();
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "member", cascade = CascadeType.ALL)
	private	Set<Report>	reports	 = new HashSet<Report>	();


	public Set<Report> getReports() {
		return reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

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



	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberCel() {
		return memberCel;
	}

	public void setMemberCel(String memberCel) {
		this.memberCel = memberCel;
	}

	public String getMemberPic() {
		return memberPic;
	}

	public void setMemberPic(String memberPic) {
		this.memberPic = memberPic;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Set<Store> getStores() {
		return stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
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
