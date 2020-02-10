package com.fund.model.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.fund.model.Member;
import com.fund.model.Store;

public interface IMemberService {


	public void addMember(Member member); // 註冊帳號時 設定帳號狀態

	public void updateMember(Member member, Integer memberId);//更新帳號資料

	public List<Member> listFindMemberByEmail(String memberEmail);//取得會員資料listByEmail

	public Member findMember(Integer memberId);//取得會員資料 Member

	public List<Store> listFindStoreByMemberId(Integer memberId);//取得商店資料 listByMemberId

	public String addMemberPic(MultipartFile file, HttpServletRequest request);//存入照片

	public boolean deleteMemberPic(Integer memberId, HttpServletRequest request);//刪除照片

	public List<String> suggestAccount(Member member);//製造建議帳號

	public void addStoreIdSession(Integer memberId, HttpSession httpSession);//將StoreId 存Session

}
