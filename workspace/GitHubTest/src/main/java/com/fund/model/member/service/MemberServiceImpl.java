package com.fund.model.member.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.fund.model.Member;
import com.fund.model.OrderDetail;
import com.fund.model.Store;
import com.fund.model.member.dao.MemberDaoImpl;

@Service
public class MemberServiceImpl {

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
	 * @Service 新增資料時 設定帳號狀態
	 */

	public void addMember(Member member) {
		if (member != null) {
			member.setMemberStatus("正常");
			String md5Password = DigestUtils.md5DigestAsHex(member.getMemberPwd().getBytes());
			member.setMemberPwd(md5Password);
			memberDaoImpl.addMember(member);
		}
	}

	/**
	 * @Service 更新帳號資料
	 */

	public void updateMember(Member member, String memberEmail) {
		
		if (member.getMemberPic() != null) {
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
			query.setParameter("email", memberEmail);
			memberDaoImpl.updateMember(query);
		} else {
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
			query.setParameter("email", memberEmail);
			memberDaoImpl.updateMember(query);
		}

	}

	/**
	 * @Service 取得會員資料
	 */
	public List<Member> listFindMemberByEmail(String memberEmail) {
		List<Member> listMember = memberDaoImpl.listFindMemberByEmail(memberEmail);
		return listMember;
	}
	
	/**
	 * @Service 取得商店資料
	 */
	public List<Store> listFindStoreByMemberId(Integer memberId){
		List<Store> listStore = memberDaoImpl.listFindStoreByMemberId(memberId);
		return listStore;
	}
	
	/**
	 * @Service 刪除照片
	 */
	
	  public boolean deleteMemberPic(String memberEmail,HttpServletRequest request){
		  List<Member> member = memberDaoImpl.listFindMemberByEmail(memberEmail);
		  String memberpic = member.get(0).getMemberPic();
		  if(memberpic!="images/T1213121.jsp") {
			   String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/");
		  String fileName = filePath+memberpic;
		   File file = new File(fileName);
		   if (file.isFile() && file.exists()) {
		  file.delete();//"刪除單個檔案"+name+"成功！"
		  return true;
		   }//"刪除單個檔案"+name+"失敗！"
		   return false;
		  }
		  return true;
		  }
	

	  
}
