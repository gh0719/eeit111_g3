package com.fund.model.manager.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fund.model.Announcement;
import com.fund.model.Manager;
import com.fund.model.manager.dao.ManagerDaoImpl;


@Service
public class ManagerServiceImpl {
	
	@Autowired
	private ManagerDaoImpl managerDaoImpl;
	
	/**
	 * @param 取得管理員資料
	 */
	public List<Manager> getManagerByManagerAccount(String account){
		List<Manager> manager = managerDaoImpl.getManagerByManagerAccount(account);
		return manager;
	}
	
	/**
	 * @param 存入公告
	 */
	public String initAnnouncement(Announcement announcement,HttpSession httpSession) {
		String account = (String) httpSession.getAttribute("account");
		List<Manager> manager = managerDaoImpl.getManagerByManagerAccount(account);
		announcement.setManager(manager.get(0));
		announcement.setAnnouncementStatus("正常");
		announcement.setAnnouncementDate(new Date());
		String status = managerDaoImpl.initAnnouncement(announcement);
		return status;
	}
	
    /**
     * @查詢公告
     */
	public List<Announcement> getAnnouncement(){
		List<Announcement> at = managerDaoImpl.getAnnouncement();
		return at;
	}
	
	/**
	 * @查詢公告內容
	 */
	public List<Announcement> getAnnouncementById(int id){
		List<Announcement> at = managerDaoImpl.getAnnouncementById(id);
		return at;
	}
}
