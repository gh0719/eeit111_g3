package com.fund.interfaceService;

import java.util.List;

import com.fund.model.Member;

public interface MemberService {

	public void setInsertMember(Member member) ;
	
	public void setUpdateMember(Member member,String user) ;
	
	public List<Member> getMemberService(String user);
}
