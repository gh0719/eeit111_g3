package com.fund.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fund.ImplService.MemberServiceImpl;
import com.fund.model.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberServiceImpl memberServiceImpl;

	/**
	 * @param member controller 註冊功能
	 */
	@RequestMapping(value = "registerMember", method = RequestMethod.POST)
	public String registerMember(Member member, Model model,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request)
			throws Exception {
			if ((member.getMemberEmail().matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$"))
			 && (member.getMemberPwd() != null)   && (member.getMemberTwid().matches("^[A-Z]\\d{9}$"))
			 && (member.getMemberFname() != null) && (member.getMemberSname() != null)
			 && (member.getMemberGd() != null)    && (member.getMemberHb() != null)
		     && (member.getMemberCel().matches("^09[0-9]{8}$"))) {
				List<Member> rusers = memberServiceImpl.getMemberService(member.getMemberEmail());
				if (rusers==null) {
					if(!file.getOriginalFilename().isEmpty()) {
					String name = UUID.randomUUID().toString().replaceAll("-", "");// 使用UUID給圖片重新命名，並去掉四個“-”
					String imageName = file.getOriginalFilename();// 獲取圖片名稱
					// String contentType=file.getContentType(); //獲得檔案型別（可以判斷如果不是圖片，禁止上傳）
					String ext = FilenameUtils.getExtension(file.getOriginalFilename());// 獲取檔案的副檔名
					String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images");// 設定圖片上傳路徑
					file.transferTo(new File(filePath + "/" + name + "." + ext));// 以絕對路徑儲存重名命後的圖片
					member.setMemberPic("images/" + name + "." + ext);// 把圖片儲存路徑儲存到資料庫
					memberServiceImpl.setInsertMember(member);
					}else {
						String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images");// 設定圖片上傳路徑
						member.setMemberPic("images/T1213121.jpg");// 把圖片儲存路徑儲存到資料庫
						memberServiceImpl.setInsertMember(member);
					}
					model.addAttribute("success", "註冊成功");
					return "login";
				} else {
					System.out.println("帳號已註冊");
					return "error";// 帳號已註冊
				}
			} else {
				System.out.println("輸入格式錯誤");
				return "error";
			}
		} 
	

	/**
	 * @param memberEmail controller 登入功能
	 */
	@RequestMapping(value = "/loginMember", method = RequestMethod.POST)
	public String loginMember(Member member, Model model, HttpSession httpSession) {
		String user = member.getMemberEmail();
		String pwd = member.getMemberPwd();
		if (user.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$") && pwd != null) {
			List<Member> ruser = memberServiceImpl.getMemberService(user);
			if (ruser!=null) {
				String rpwd = ruser.get(0).getMemberPwd();
				if (pwd.equals(rpwd)) {
					httpSession.setAttribute("user", member.getMemberEmail());// 將帳號存入Session
					model.addAttribute("success", "登入成功  三秒後轉跳至首頁");
					System.out.println("登入成功 ");
					return "login";
				} else {
					System.out.println("登入失敗 密碼錯誤 ");
					model.addAttribute("error2", "登入失敗 帳號或密碼錯誤");
					return "redirect:/loginSystem.jsp";
				}
			} else {
				System.out.println("登入失敗  無此帳號");
				model.addAttribute("error2", "登入失敗 帳號或密碼錯誤");
				return "redirect:/loginSystem.jsp";
			}
		} else {
			System.out.println("登入失敗  格式錯誤");
			model.addAttribute("error1", "登入失敗  帳號格式輸入錯誤");
			return "redirect:/loginSystem.jsp";
		}
	}

	/**
	 * @param 取得會員資料來進行updata
	 */
	@RequestMapping(value = "/getMember", method = RequestMethod.GET)
	public String getMember(HttpSession httpSession, Model model) {
		String user = (String) httpSession.getAttribute("user");// 取得Session的帳號
		if (user != null) {
			List<Member> users = memberServiceImpl.getMemberService(user);
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
	 * @param 更新資料
	 */
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(HttpSession httpSession, Member member, Model model,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request)
			throws Exception {
		if ((member.getMemberTwid().matches("^[A-Z]\\d{9}$"))&& (!member.getMemberFname().isEmpty()) 
			 && (!member.getMemberSname().isEmpty())&& (!member.getMemberGd().isEmpty()) 
			 && (!member.getMemberHb().isEmpty()) && (member.getMemberCel().matches("^09[0-9]{8}$"))) {
			String user = (String) httpSession.getAttribute("user");//取得session的帳號
		if (user != null) {
			if (!file.getOriginalFilename().isEmpty()) {//檢驗看圖檔是否有上傳 有話存取
				String name = UUID.randomUUID().toString().replaceAll("-", "");// 使用UUID給圖片重新命名，並去掉四個“-”
				String imageName = file.getOriginalFilename();// 獲取圖片名稱
				// String contentType=file.getContentType(); //獲得檔案型別（可以判斷如果不是圖片，禁止上傳）
				String ext = FilenameUtils.getExtension(file.getOriginalFilename());// 獲取檔案的副檔名
				String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images");// 設定圖片上傳路徑
				// System.out.println(filePath);
				file.transferTo(new File(filePath + "/" + name + "." + ext));// 以絕對路徑儲存重名命後的圖片
				member.setMemberPic("images/" + name + "." + ext);// 把圖片儲存路徑儲存到資料庫
				memberServiceImpl.setUpdateMember(member, user);
				model.addAttribute("sname", "Hi~ " + member.getMemberSname());
			} else {
				memberServiceImpl.setUpdateMember(member, user);
				model.addAttribute("sname", "Hi~ " + member.getMemberSname());
			}
			return getMember1(httpSession, model);//更新完成後 返回getMember1 方法 導回會員查詢頁面
		} else {
			return "noLogin";
		}}else {
			return "noLogin";
		}
		
	}

	/**
	 * @param 查詢會員資料直接顯示
	 */
	@RequestMapping(value = "/getMember1", method = RequestMethod.GET)
	public String getMember1(HttpSession httpSession, Model model) {
		String user = (String) httpSession.getAttribute("user");// 取得Session的帳號
		if (user != null) {
			List<Member> users = memberServiceImpl.getMemberService(user);
			model.addAttribute("getMemberFname", users.get(0).getMemberFname());
			model.addAttribute("getMemberSname", users.get(0).getMemberSname());
			model.addAttribute("getMemberTwid", users.get(0).getMemberTwid());
			model.addAttribute("getMemberGd", users.get(0).getMemberGd());
			model.addAttribute("getMemberHb", users.get(0).getMemberHb());
			model.addAttribute("getMemberTel", users.get(0).getMemberTel());
			model.addAttribute("getMemberCel", users.get(0).getMemberCel());
			model.addAttribute("getMemberPic", users.get(0).getMemberPic());
			System.out.println(users.get(0).getMemberPic());
			return "mbInformation";
		} else {
			model.addAttribute("nologin", "請先登入 3秒後跳至首頁");
			return "noLogin";
		}
	}

}
