package com.fund.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
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

import com.fund.ImplService.ManagerServiceImpl;
import com.fund.model.Announcement;
import com.fund.model.Manager;

@Controller
public class ManagerController {

	@Autowired
	private ManagerServiceImpl managerServiceImpl;

	/**
	 * @param 管理員登入
	 */
	@RequestMapping(value = "/getManagerByManagerAccount", method = RequestMethod.POST)
	public String getManagerByManagerAccount(Manager manager, HttpSession httpSession, Model model) {
		String account = manager.getManagerAccount();
		String pwd = manager.getManagerPwd();
		List<Manager> rManager = managerServiceImpl.getManagerByManagerAccount(account);

		if (rManager != null) {
			if (rManager.get(0).getManagerPwd().equals(pwd)) {
				httpSession.setAttribute("account", account);
				return getAnnouncements(model);
			} else {
				return "error";
			}
		} else {
			return "error";
		}
	}

	/**
	 * @param 存入公告
	 */
	@RequestMapping(value = "/initAnnouncement", method = RequestMethod.POST)
	public String initAnnouncement(Announcement announcement, HttpSession httpSession,Model model,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		String user = (String) httpSession.getAttribute("account");
		if (user != null) {
			if (!file.getOriginalFilename().isEmpty()) {
				String name = UUID.randomUUID().toString().replaceAll("-", "");// 使用UUID給圖片重新命名，並去掉四個“-”
				String imageName = file.getOriginalFilename();// 獲取圖片名稱
				// String contentType=file.getContentType(); //獲得檔案型別（可以判斷如果不是圖片，禁止上傳）
				String ext = FilenameUtils.getExtension(file.getOriginalFilename());// 獲取檔案的副檔名
				String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images");// 設定圖片上傳路徑
				file.transferTo(new File(filePath + "/" + name + "." + ext));// 以絕對路徑儲存重名命後的圖片
				announcement.setAnnouncementPic("images/" + name + "." + ext);// 把圖片儲存路徑儲存到資料庫
				String status = managerServiceImpl.initAnnouncement(announcement, httpSession);
				System.out.println(status);
			} else {
				String status = managerServiceImpl.initAnnouncement(announcement, httpSession);
				System.out.println(status);
			}
			
			return getAnnouncements(model);
		} else {
			return "redirect:/managerlogin.jsp";
		}
	}
	
    /**
     * @取得資料顯示
     */
	public String getAnnouncements(Model model) {
		List<Announcement> at = managerServiceImpl.getAnnouncement();
		Collections.reverse(at);//反向排序
		model.addAttribute("allAt", at);
		return "announcements";
	}
	
	/**
	 * @取得資料內容
	 */
	@RequestMapping(value = "/getAnnouncementById", method = RequestMethod.GET)
	public String getAnnouncementById(Model model,@RequestParam(name = "aaa", required = false) Integer id) {
		List<Announcement> at = managerServiceImpl.getAnnouncementById(id);
		model.addAttribute("allAt", at);
		return "announcementPf";
	}

}