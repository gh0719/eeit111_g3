package com.fund.model.member.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.fund.model.Member;
import com.fund.model.Store;

public interface IMemberDao {

	public void addMember(Member member);//註冊帳號

	public void updateMember(Query query);//更新帳號資料
	
	public List<Member> listFindMemberByEmail(String memberEmail);//取得會員資料list
	
	public Member findMember(Integer memberId);//取得會員資料Member
	
	public List<Store> listFindStoreByMemberId(Integer memberId);//取得商店資料list
	
	
	
	
}
