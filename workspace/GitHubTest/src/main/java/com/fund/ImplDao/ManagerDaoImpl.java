package com.fund.ImplDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fund.model.Announcement;
import com.fund.model.Manager;

@Repository
public class ManagerDaoImpl {
	
	@Autowired
	private SessionFactory sessionFactory;

	// 獲取跟當前線程綁定的session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
//		return sessionFactory.openSession();
	}
	
	
	/**
	 * @getMemberDao 取得會員資料
	 */
	public List<Manager> getManagerByManagerAccount(String account) {
		String hqlstr = "From Manager WHERE managerAccount=:account";
		
			Query query = getSession().createQuery(hqlstr).setParameter("account", account);
			List<Manager> manager = query.list();	
			
			if(manager.size()==0) {
				return null;
			}else {
				return manager;
			}		
	}
	
	
    /**
     * @param 存入公告
     */
	public String initAnnouncement(Announcement announcement) {
		try {
			String success = "存檔成功";
			getSession().save(announcement);
			return success;
		} catch (Exception e) {
			String error = "存檔失敗";
			e.printStackTrace();
			return error;
		}
	}
	
	/**
	 * @return 取得全部公告
	 */
	public List<Announcement> getAnnouncement(){
		String hql = "From Announcement";
		Query query = getSession().createQuery(hql);
		
		List<Announcement> at= query.list();
		
		return at;
	}
	
	/**
	 * @取得公告內容
	 */
    public List<Announcement> getAnnouncementById(int id){
    	String hql = "From Announcement Where announcementId=:id";
    	Query query = getSession().createQuery(hql).setParameter("id", id);
    	List<Announcement> at= query.list();
		return at;
    }
}
