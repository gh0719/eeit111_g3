package com.fund.ImplService;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fund.ImplDao.MemberDaoImpl;
import com.fund.interfaceService.MemberService;
import com.fund.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDaoImpl memberDaoImpl;
	

	
	@Autowired
	private SessionFactory sessionFactory;

	// 獲取跟當前線程綁定的session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
//		return sessionFactory.openSession();
	}
	
	
	
    
	/**
	 * @ServiceImpl新增資料時設定帳號狀態
	 */
	@Override
	public void setInsertMember(Member member) {
		if(member != null) {
				member.setMemberStatus("正常");
				memberDaoImpl.insertMember(member);
		}
	}

	/**
	 * @ServiceImpl更新帳號資料
	 */
	@Override
	public void setUpdateMember(Member member,String user) {
		if(member.getMemberPic()!=null) {
			String hqlstr = "update Member m set m.memberFname=:fn,m.memberSname=:sn,m.memberTwid=:twid,"
				+ "m.memberGd=:gd,m.memberHb=:hb,m.memberTel=:tel,m.memberCel=:cel,m.memberPic=:pic where m.memberEmail=:email";
			Query query = getSession().createQuery(hqlstr);
			query.setParameter("fn", member.getMemberFname());
			query.setParameter("sn", member.getMemberSname());
			query.setParameter("twid", member.getMemberTwid());
			query.setParameter("gd", member.getMemberGd());
			query.setParameter("hb", member.getMemberHb());
			query.setParameter("tel", member.getMemberTel());
			query.setParameter("cel", member.getMemberCel());
			query.setParameter("pic", member.getMemberPic());
			query.setParameter("email", user);
		memberDaoImpl.updateMember(query);
		}else {
			String hqlstr = "update Member m set m.memberFname=:fn,m.memberSname=:sn,m.memberTwid=:twid,"
					+ "m.memberGd=:gd,m.memberHb=:hb,m.memberTel=:tel,m.memberCel=:cel where m.memberEmail=:email";
				Query query = getSession().createQuery(hqlstr);
				query.setParameter("fn", member.getMemberFname());
				query.setParameter("sn", member.getMemberSname());
				query.setParameter("twid", member.getMemberTwid());
				query.setParameter("gd", member.getMemberGd());
				query.setParameter("hb", member.getMemberHb());
				query.setParameter("tel", member.getMemberTel());
				query.setParameter("cel", member.getMemberCel());
				query.setParameter("email", user);
			memberDaoImpl.updateMember(query);
		}
		
	}
	

	/**
	 * @getMemberService 取得會員資料
	 */
	@Override
	public List<Member> getMemberService(String user) {
		List<Member> users = memberDaoImpl.getMemberDao(user);
		return users;
	}
	


}
