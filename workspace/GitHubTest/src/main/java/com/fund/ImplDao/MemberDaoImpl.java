package com.fund.ImplDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fund.interfaceDao.MemberDao;
import com.fund.model.Member;
import com.fund.model.Product;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SessionFactory sessionFactory;

	// 獲取跟當前線程綁定的session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
//		return sessionFactory.openSession();
	}

	/**
	 * @DaoImpl新增帳號
	 */
	@Override
	public void insertMember(Member member) {
		try {
			getSession().save(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * @DaoImpl更新帳號資料
	 */
	@Override //還原點
	public void updateMember(Query query) {
		query.executeUpdate();
	}


	/**
	 * @getMemberDao 取得會員資料
	 */
	@Override
	public List<Member> getMemberDao(String user) {
	
			String hqlstr = "From Member WHERE memberEmail=:email";
			Query query = getSession().createQuery(hqlstr).setParameter("email", user);
			List<Member> users = query.list();
			if(users.size()!=0) {
				return users;
			}else {
				return null;
			}
	}
	

}
