package com.fund.model.store.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.fund.model.Member;
import com.fund.model.Store;
import com.fund.model.store.dao.StoreDaoImpl;

@Service
public class StoreServiceImpl {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
//		return sessionFactory.openSession();
	}
	
	@Autowired
	private StoreDaoImpl storeSDapImpl;
	

	/**
	 * @Service 註冊商家時 設定商家狀態
	 */

	public void addStore(Store store,HttpSession httpSession) {
		Member memberSession = (Member) httpSession.getAttribute("memberInformation");// 取得Session的Member
		Integer memberId = memberSession.getMemberId();
		if (store != null) {
			store.setStoreStatus("正常");
			store.setMember(memberSession);
			storeSDapImpl.addStore(store);
		}
	}
	
	/**
	 * @Service 查詢StoreName是否存在
	 */
	public Store findStoreByName(Store store){
		return storeSDapImpl.findStoreByName(store);
	}
	
	
	/**
	 *@Service 查詢商店資料
	 */
	public Store findStore(Integer storeId) {	
		return storeSDapImpl.findStore(storeId);
	}
	
	/**
	 * @Servic 存入照片
	 * @param file
	 * @param request
	 * @return
	 */

	public String addStorePic(MultipartFile file, HttpServletRequest request) {
		if (!file.getOriginalFilename().isEmpty()) {
			String fileType = file.getContentType(); // 獲得檔案型別
			if (fileType.equals("image/jpeg") || fileType.equals("image/gif")) {
				String name = UUID.randomUUID().toString().replaceAll("-", "");// 使用UUID給圖片重新命名，並去掉四個“-”
				String ext = FilenameUtils.getExtension(file.getOriginalFilename());// 獲取檔案的副檔名
				String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images/storePic");// 設定圖片上傳路徑
				try {
					file.transferTo(new File(filePath + "/" + name + "." + ext));// 以絕對路徑儲存重名命後的圖片
				} catch (Exception e) {
					e.printStackTrace();
				}
				String path = "images/storePic/" + name + "." + ext;// 把圖片儲存路徑儲存到資料庫
				return path;
			} else {
				String errorPic = "errorPic";
				return errorPic;
			}
		} else {// 如果沒有傳圖片 存預設圖片路徑
			String presetPic = "images/storePic/T1213121.jpg";
			return presetPic;
		}
	}

	
	/**
	 * @Service 刪除照片
	 */

	public boolean deleteStorePic(Integer storeId, HttpServletRequest request) {
		Store store = storeSDapImpl.findStore(storeId);
		String storePic = store.getStorePic();
		if (!storePic.equals("/images/storePic/T1213121.jpg")) {
			String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/");
			String fileName = filePath + storePic;
			File file = new File(fileName);
			if (file.isFile() && file.exists()) {
				file.delete();// "刪除單個檔案"+name+"成功！"
				return true;
			} // "刪除單個檔案"+name+"失敗！"
			return false;
		}
		return true;
	}
	
	
	public void updateStore(Store store) {
		Store getStore = storeSDapImpl.findStoreByName(store);
		
	}
	

}
