package com.fund.model.member.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fund.model.Member;
import com.fund.model.Store;
import com.fund.model.member.service.MemberServiceImpl;

@Controller
public class MemberController {

	@Autowired
	private MemberServiceImpl memberServiceImpl;

	/**
	 * @controller 註冊功能
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "registerMember", method = RequestMethod.POST)
	public String registerMember(Member member, Model model,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,HttpSession httpSession)
			throws Exception {
			if ((member.getMemberEmail().matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$"))
			 && (member.getMemberPwd() != null)   && (member.getMemberTwid().matches("^[A-Z]\\d{9}$"))
			 && (member.getMemberFname() != null) && (member.getMemberSname() != null)
			 && (member.getMemberGd() != null)    && (member.getMemberHb() != null)
		     && (member.getMemberCel().matches("^09[0-9]{8}$"))) {
				List<Member> listMember = memberServiceImpl.listFindMemberByEmail(member.getMemberEmail());		
				if (listMember==null) {
					if(!file.getOriginalFilename().isEmpty()) {
						String fileType = file.getContentType(); // 獲得檔案型別
						if (fileType.equals("image/jpeg") || fileType.equals("image/gif")) {
							String name = UUID.randomUUID().toString().replaceAll("-", "");// 使用UUID給圖片重新命名，並去掉四個“-”
					String ext = FilenameUtils.getExtension(file.getOriginalFilename());// 獲取檔案的副檔名
					String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images");// 設定圖片上傳路徑
					file.transferTo(new File(filePath + "/" + name + "." + ext));// 以絕對路徑儲存重名命後的圖片
					member.setMemberPic("images/" + name + "." + ext);// 把圖片儲存路徑儲存到資料庫
					memberServiceImpl.addMember(member);
						}else {
							System.out.println("輸入格式錯誤");
							return "error";
						}
					}else {
						member.setMemberPic("images/T1213121.jpg");// 把圖片儲存路徑儲存到資料庫
						memberServiceImpl.addMember(member);
					}
					return "save";//註冊成功
				} else {
					System.out.println("帳號已註冊");
					httpSession.setAttribute("name", member);// 將使用者輸入的Member存入Session
					httpSession.setAttribute("repeat", member.getMemberEmail()+ "已有人使用");// 將輸入MemberEmail存入Session
					return "redirect:/register.jsp";// 帳號已註冊
				}
			} else {
				System.out.println("輸入格式錯誤");
				return "error";
			}
		} 
	

	/**
	 * @controller 登入功能
	 */
	@RequestMapping(value = "/loginMember", method = RequestMethod.POST)
	public String loginMember(Member member, Model model, HttpSession httpSession) {
		String memberEmail = member.getMemberEmail();
		String pwd = member.getMemberPwd();
		if (memberEmail.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$") && pwd != null) {
			List<Member> listMember = memberServiceImpl.listFindMemberByEmail(memberEmail);
			if (listMember!=null) {
				String rpwd = listMember.get(0).getMemberPwd();
				if (pwd.equals(rpwd)) {
					int memberId = listMember.get(0).getMemberId();
					List<Store> listStore = memberServiceImpl.listFindStoreByMemberId(memberId);
					if(listStore!=null) {
							int storeId = listStore.get(0).getStoreId();
							httpSession.setAttribute("storeId",storeId);//將storeId	存入Session
					}
					httpSession.setAttribute("memberEamil", member.getMemberEmail());// 將MemberEmail存入Session
					httpSession.setAttribute("memberId",memberId);// 將MemberId存入Session
					httpSession.setAttribute("listMember",listMember.get(0));// 將Member存入Session
					System.out.println("登入成功 ");
					return "login";
				} else {
					System.out.println("登入失敗 密碼錯誤 ");
					return "redirect:/loginSystem.jsp";
				}
			} else {
				System.out.println("登入失敗  無此帳號");
				return "redirect:/loginSystem.jsp";
			}
		} else {
			System.out.println("登入失敗  格式錯誤");
			return "redirect:/loginSystem.jsp";
		}
	}

	/**
	 * @controller 取得會員資料來進行updata
	 */
	@RequestMapping(value = "/getMember", method = RequestMethod.GET)
	public String getMember(HttpSession httpSession, Model model) {
		String memberEmail = (String) httpSession.getAttribute("memberEamil");// 取得Session的帳號
		if (memberEmail != null) {
			List<Member> users = memberServiceImpl.listFindMemberByEmail(memberEmail);
			model.addAttribute("getMemberFname", users.get(0).getMemberFname());
			model.addAttribute("getMemberSname", users.get(0).getMemberSname());
			model.addAttribute("getMemberTwid", users.get(0).getMemberTwid());
			model.addAttribute("getMemberGd", users.get(0).getMemberGd());
			model.addAttribute("getMemberHb", users.get(0).getMemberHb());
			model.addAttribute("getMemberTel", users.get(0).getMemberTel());
			model.addAttribute("getMemberCel", users.get(0).getMemberCel());
			model.addAttribute("getMemberPic", users.get(0).getMemberPic());
			return "updateMember";
		} else {
			model.addAttribute("nologin", "請先登入 3秒後跳至首頁");
			return "noLogin";
		}
	}

	/**
	 * @controller 更新資料
	 */
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(HttpSession httpSession, Member member, Model model,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request)
			throws Exception {
		if ((member.getMemberTwid().matches("^[A-Z]\\d{9}$"))&& (!member.getMemberFname().isEmpty()) 
			 && (!member.getMemberSname().isEmpty())&& (!member.getMemberGd().isEmpty()) 
			 && (!member.getMemberHb().isEmpty()) && (member.getMemberCel().matches("^09[0-9]{8}$"))) {
			String memberEmail = (String) httpSession.getAttribute("memberEamil");//取得session的帳號
		if (memberEmail != null) {
			if (!file.getOriginalFilename().isEmpty()) {//檢驗看圖檔是否有上傳 有話存取
				String fileType = file.getContentType(); // 獲得檔案型別
				if (fileType.equals("image/jpeg") || fileType.equals("image/gif")) {
				boolean status =  memberServiceImpl.deleteMemberPic(memberEmail, request);//刪除照片
				System.out.println("照片刪除 = "+status);
			    String name = UUID.randomUUID().toString().replaceAll("-", "");// 使用UUID給圖片重新命名，並去掉四個“-”
				String imageName = file.getOriginalFilename();// 獲取圖片名稱
				String ext = FilenameUtils.getExtension(file.getOriginalFilename());// 獲取檔案的副檔名
				String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images");// 設定圖片上傳路徑
				file.transferTo(new File(filePath + "/" + name + "." + ext));// 以絕對路徑儲存重名命後的圖片
				member.setMemberPic("images/" + name + "." + ext);// 把圖片儲存路徑儲存到資料庫
				memberServiceImpl.updateMember(member, memberEmail);
				}else {
					System.out.println("輸入格式錯誤");
					return "error";
				}
			} else {
				memberServiceImpl.updateMember(member, memberEmail);
			}
			return "redirect:/getMember1";//更新完成後 返回  導回會員查詢頁面
		} else {
			return "noLogin";
		}}else {
			System.out.println("輸入格式錯誤");
			return "error";
		}
		
	}

	/**
	 * @controller 查詢會員資料直接顯示
	 */
	@RequestMapping(value = "/getMember1", method = RequestMethod.GET)
	public String getMember1(HttpSession httpSession, Model model) {
		
		String memberEmail = (String) httpSession.getAttribute("memberEamil");// 取得Session的帳號
		if (memberEmail != null) {
			List<Member> listMember = memberServiceImpl.listFindMemberByEmail(memberEmail);
			httpSession.setAttribute("listMember",listMember.get(0));// 將Member存入Session
			model.addAttribute("getMemberFname", listMember.get(0).getMemberFname());
			model.addAttribute("getMemberSname", listMember.get(0).getMemberSname());
			model.addAttribute("getMemberTwid", listMember.get(0).getMemberTwid());
			model.addAttribute("getMemberGd", listMember.get(0).getMemberGd());
			model.addAttribute("getMemberHb", listMember.get(0).getMemberHb());
			model.addAttribute("getMemberTel", listMember.get(0).getMemberTel());
			model.addAttribute("getMemberCel", listMember.get(0).getMemberCel());
			model.addAttribute("getMemberPic", listMember.get(0).getMemberPic());
			//System.out.println(listMember.get(0));
			return "mbInformation";
		} else {
			model.addAttribute("nologin", "請先登入 3秒後跳至首頁");
			return "noLogin";
		}
	}
	
	


}
