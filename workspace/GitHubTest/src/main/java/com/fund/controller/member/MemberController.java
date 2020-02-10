package com.fund.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.fund.model.Member;
import com.fund.model.Store;
import com.fund.model.member.service.MemberServiceImpl;

@Controller
//@SessionAttributes(value = {"memberInformation","storeId"})
public class MemberController {

	@Autowired
	private MemberServiceImpl memberServiceImpl;

	/**
	 * @controller 註冊功能
	 */
	@RequestMapping(value = "registerMember", method = RequestMethod.POST)
	public String registerMember(Member member, Model model,@RequestParam(value = "confirmPwd", required = false)String confirmPwd,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request)
			throws Exception {
		    model.addAttribute("inputMember", member);//如果輸入錯誤 原本輸入的值導回 使用者不用重複書寫
			if ((member.getMemberEmail().matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$"))
			 && (member.getMemberPwd().matches( "^(?=^.{6,12}$)((?=.*[0-9])(?=.*[a-z|A-Z]))^.*$"))   && (member.getMemberTwid().matches("^[A-Z]\\d{9}$"))
			 && (member.getMemberFname() != null) && (member.getMemberSname() != null)
			 && (member.getMemberGd() != null)    && (member.getMemberHb() != null)
		     && (member.getMemberCel().matches("^09[0-9]{8}$"))) {
				if(confirmPwd.equals(member.getMemberPwd())){
					List<Member> listMember = memberServiceImpl.listFindMemberByEmail(member.getMemberEmail());	
				if (listMember==null) {//如果帳號不存在				
					String pic = memberServiceImpl.addMemberPic(file,request);//圖片存檔
					if(!pic.equals("errorPic")) {//圖片存取正常
						member.setMemberPic(pic);//設定圖片路徑
						memberServiceImpl.addMember(member);//存入資料庫
						return "MemberSystem/save";//註冊成功
					}else {
							model.addAttribute("errorPicFormat", "輸入圖片格式錯誤  請確認");
							return "MemberSystem/register";
					}} else {
					List<String> newAccount = memberServiceImpl.suggestAccount(member);//產生建議帳號
					model.addAttribute("errorAccount", newAccount);
					System.out.println("帳號已註冊   以下提供參考"+newAccount);
					return "MemberSystem/register";// 帳號已註冊
				}
				}else {
					System.out.println("兩次密碼輸入不符合");
					model.addAttribute("errorPwd", "兩次密碼輸入不符合" );
					return "MemberSystem/register";
				}		
			} else {
				System.out.println("資料輸入格式錯誤");
				model.addAttribute("errorFormat", "資料輸入格式錯誤" );
				return "MemberSystem/register";
			}
		} 
	

	/**
	 * @controller 登入功能
	 */
	@RequestMapping(value = "/loginMember", method = RequestMethod.POST)
	public String loginMember(Member member, Model model ,HttpSession httpSession) {
		String memberEmail = member.getMemberEmail();
		String pwd = DigestUtils.md5DigestAsHex(member.getMemberPwd().getBytes());//md5解密
		if (memberEmail.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$") && pwd != null) {
			List<Member> listMember = memberServiceImpl.listFindMemberByEmail(memberEmail);
			if (listMember!=null) {
				String rpwd = listMember.get(0).getMemberPwd();
				if (pwd.equals(rpwd)) {
					int memberId = listMember.get(0).getMemberId();
					Member memberInformation = memberServiceImpl.findMember(memberId);
					httpSession.setAttribute("memberInformation", memberInformation);//memberInformation 存入Session
					memberServiceImpl.addStoreIdSession(memberId, httpSession);//StoreId 存入Session
					System.out.println("登入成功 ");
					return "home";
				} else {
					System.out.println("登入失敗 密碼錯誤 ");
					model.addAttribute("errorPwd", "帳號或密碼錯誤");
					return "MemberSystem/loginSystem";
				}
			} else {
				System.out.println("登入失敗  無此帳號");
				model.addAttribute("errorAccount", "無此帳號");
				return "MemberSystem/loginSystem";
			}
		} else {
			System.out.println("登入失敗  格式錯誤");
			model.addAttribute("errorFormat", "帳號格式錯誤");
			return "MemberSystem/loginSystem";
		}
	}

	/**
	 * @controller 取得會員資料來進行updata
	 */
	@RequestMapping(value = "/getMemberToUpdate", method = RequestMethod.GET)
	public String getMember(HttpSession httpSession, Model model) {
		Member memberSession = (Member) httpSession.getAttribute("memberInformation");// 取得Session的Member
		if (memberSession != null) {
			Member member = memberServiceImpl.findMember(memberSession.getMemberId());//查資料庫會員資料
			model.addAttribute("getMember",member);
			return "MemberSystem/updateMember";
		} else {
			model.addAttribute("nologin", "請先登入 3秒後跳至首頁");
			return "MemberSystem/noLogin";
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
			Member memberSession = (Member) httpSession.getAttribute("memberInformation");// 取得Session的Member
		if (memberSession != null) {
			if (!file.getOriginalFilename().isEmpty()) {//檢驗看圖檔是否有上傳 
				String fileType = file.getContentType(); // 獲得檔案型別
				if (fileType.equals("image/jpeg") || fileType.equals("image/gif")) {//查看圖片資料類型
				memberServiceImpl.deleteMemberPic(memberSession.getMemberId(), request);//刪除原本照片
				String path = memberServiceImpl.addMemberPic(file, request);//新增照片
				member.setMemberPic(path);// 把圖片儲存路徑儲存到資料庫
				memberServiceImpl.updateMember(member, memberSession.getMemberId());//進行更新
				}else {
					System.out.println("輸入格式錯誤");
					return "MemberSystem/error";
				}
			} else {
				memberServiceImpl.updateMember(member, memberSession.getMemberId());//沒修改照片話直接更新
			}
			return "redirect:/getMember";//更新完成後 返回getMember 方法  導回會員查詢頁面
		} else {
			return "MemberSystem/noLogin";
		}}else {
			System.out.println("輸入格式錯誤");
			return "MemberSystem/error";
		}
		
	}

	/**
	 * @controller 查詢會員資料直接顯示
	 */
	@RequestMapping(value = "/getMember", method = RequestMethod.GET)
	public String getMemberToUpdate(HttpSession httpSession, Model model) {
		Member memberSession = (Member) httpSession.getAttribute("memberInformation");// 取得Session的Member
		if (memberSession != null) {
			Member member = memberServiceImpl.findMember(memberSession.getMemberId());
			httpSession.setAttribute("memberInformation", member);//將更改後memberInformation Session放入
			memberServiceImpl.addStoreIdSession(member.getMemberId(), httpSession);//StoreId 存入Session
			model.addAttribute("getMember", member);
			return "MemberSystem/mbInformation";
		} else {
			model.addAttribute("nologin", "請先登入 3秒後跳至首頁");
			return "MemberSystem/noLogin";
		}
	}
	
	public String findPwd() {
		
		return "";
	}
	

	
	/**
	 * @映射路徑到register
	 */
	@RequestMapping(path="/register")
	public String register() {
		return "MemberSystem/register";
	}
	
	/**
	 * @映射路徑到loginSystem
	 */
	@RequestMapping(path="/loginSystem")
	public String loginSystem() {
		return "MemberSystem/loginSystem";
	}


}
