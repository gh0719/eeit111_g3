package com.fund.model.member.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fund.model.Member;
import com.fund.model.Store;
import com.fund.model.member.dao.MemberDaoImpl;

@Service
public class MemberServiceImpl {
	
//	private static final String PHONE = "";
//	private static final String EMAIL = "";
//	private static final String CELL = "";
//	private static final String ADDR = "";
	
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
	 * @Service 註冊帳號時 設定帳號狀態
	 */

	public void addMember(Member member) {
		if (member != null) {
			member.setMemberStatus("正常");
			String md5Password = DigestUtils.md5DigestAsHex(member.getMemberPwd().getBytes());//md5加密
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
		// new output()
		//output set output.setName(listMember.getName()) 要用甚麼存??
		//  return = output
		return listMember;
	}
	
	public Member findMember(Integer memberId) {
		return memberDaoImpl.findMember(memberId);
	}
	
	/**
	 * @Service 取得商店資料
	 */
	public List<Store> listFindStoreByMemberId(Integer memberId){
		List<Store> listStore = memberDaoImpl.listFindStoreByMemberId(memberId);
		return listStore;
	}
	
	/**
	 * @Servic 存入照片
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String adddeleteMemberPic(MultipartFile file,HttpServletRequest request) throws Exception {
		if(!file.getOriginalFilename().isEmpty()) {
			String fileType = file.getContentType(); // 獲得檔案型別
			if (fileType.equals("image/jpeg") || fileType.equals("image/gif")) {
		String name = UUID.randomUUID().toString().replaceAll("-", "");// 使用UUID給圖片重新命名，並去掉四個“-”
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());// 獲取檔案的副檔名
		String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images");// 設定圖片上傳路徑
		file.transferTo(new File(filePath + "/" + name + "." + ext));// 以絕對路徑儲存重名命後的圖片
		String path = "images/" + name + "." + ext;// 把圖片儲存路徑儲存到資料庫
		return path;
			}else {
				String errorPic = "errorPic";
				return errorPic;
			}
	}else {//如果沒有傳圖片 存預設圖片路徑
		String presetPic = "images/T1213121.jpg";
		return presetPic;
	}
		
	}
	
	
	/**
	 * @Service 刪除照片
	 */

	  public boolean deleteMemberPic(String memberEmail,HttpServletRequest request){
		  List<Member> member = memberDaoImpl.listFindMemberByEmail(memberEmail);
		  String memberpic = member.get(0).getMemberPic();
		  if(!memberpic.equals("images/T1213121.jpg")) {     
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
	  
	  
	 /**
	  * @Service 製造建議帳號
	  */
	  public String suggestAccount(Member member) {
			int random = (int)(Math.random()*(9999-1000+1))+1000;//設定亂數
			String accountFront=member.getMemberEmail().substring(0, member.getMemberEmail().indexOf("@"));//取前
			String accountBack =member.getMemberEmail().substring(member.getMemberEmail().indexOf("@"));//取後
			String newAccount = accountFront+random+accountBack;//產生建議帳號
			while(true) {
			if(memberDaoImpl.listFindMemberByEmail(newAccount)==null) {//如果帳號不存在
			break;			
				}
	  }
			return newAccount;
	  }

	  
}
