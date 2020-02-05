package com.fund.interfaceDao;

import java.util.List;

import org.hibernate.query.Query;

import com.fund.model.Member;

public interface MemberDao {

	/**
	 * @Dao建立新增方法
	 */
	public void insertMember(Member member);

	/**
	 * @Dao建立新增更新
	 */
	public void updateMember(Query query);


	/**
	 * @param 查詢會員資料
	 */
	public List<Member> getMemberDao(String user);


}
