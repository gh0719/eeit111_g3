package com.fund.model.member.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.fund.model.Member;
import com.fund.model.Store;

public interface IMemberDao {

	public void addMember(Member member);//註冊帳號

	public void updateMember(Query query);//更新帳號資料
	
	public Member findMemberByEmail(String memberEmail);//取得會員資料
	
	public Member findMemberByMemberId(Integer memberId);//取得會員資料Member
	
	public Store findStoreByMemberId(Integer memberId);//取得商店資料list
	
	
	
	
}
