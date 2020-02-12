package com.fund.controller.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fund.model.Member;
import com.fund.model.Store;
import com.fund.model.store.service.StoreServiceImpl;
import com.fund.util.Regular;

@Controller
public class StoreController {

	@Autowired
	private StoreServiceImpl storeServiceImpl;

	/**
	 * @controller 商家註冊
	 */
	@RequestMapping(path = "/addStore")
	public String addStore(Store store, Model model, @RequestParam(value = "file", required = false) MultipartFile file,
		HttpServletRequest request, HttpSession httpSession) {
		Member memberSession = (Member) httpSession.getAttribute("memberSession");// 取得Session的Member
		Store storeidSession = (Store) httpSession.getAttribute("storeSession");// 取得Session的storeId
		model.addAttribute("storeInput", store);//如果輸入錯誤 將原本值返回頁面
		if (memberSession == null && storeidSession != null) {// 如果有登入 且沒註冊過商家話
			return "MemberSystem/noLogin";
		} else if (store.getStoreName().isEmpty()) {
			model.addAttribute("errorName", "商家名不可為空白");
			return "Store/storeRegister";
		} else if (store.getStorePf().isEmpty()) {
			model.addAttribute("errorPf", "商家簡介不可為空白");
			return "Store/storeRegister";
		} else if (store.getStoreTel().isEmpty()) {
			model.addAttribute("errorTel", "商家電話不可為空白");
			return "Store/storeRegister";
		} else if (store.getStoreNumber().isEmpty()) {
			model.addAttribute("errorNumber", "商家行號不可為空白");
			return "Store/storeRegister";
		} else if (store.getStoreAccount().isEmpty()) {
			model.addAttribute("errorAccount", "商家帳號不可為空白");
			return "Store/storeRegister";
		} else if (store.getStorePiName().isEmpty()) {
			model.addAttribute("errorPiName", "負責人姓名不可為空白");
			return "Store/storeRegister";
		} else if (store.getStorePiTwid().isEmpty()) {
			model.addAttribute("errorPiTwid", "負責人身分證不可為空白");
			return "Store/storeRegister";
		} else if (store.getStorePiTel().isEmpty()) {
			model.addAttribute("errorPiTel", "負責人電話不可為空白");
			return "Store/storeRegister";
		} else if (store.getStorePiAddress().isEmpty()) {
			model.addAttribute("errorPiAddress", "負責人地址不可為空白");
			return "Store/storeRegister";
		} else if (storeServiceImpl.findStoreByStoreName(store) != null) {// 檢查商家名稱是否註冊過
			model.addAttribute("errorRepeat", "商家名子重複");
			return "Store/storeRegister";
		} else {
			String pic = storeServiceImpl.addStorePic(file, request);// 圖片存檔
			if (!pic.equals("errorPic")) {// 圖片存取正常
				store.setStorePic(pic);// 設定圖片路徑
				String status = storeServiceImpl.addStore(store, httpSession);// 存入資料庫
				if (status == null) {
					Store newStore = storeServiceImpl.findStoreByStoreName(store);// 取出鋼註冊好的store
					httpSession.setAttribute("store", newStore);// 將註冊好的Store 存入Session
					return "Store/save";// 註冊成功
				} else {
					return "MemberSystem/noLogin";
				}
			} else {
				model.addAttribute("errorPicFormat", "輸入圖片格式錯誤  請確認");
				return "Store/storeRegister";
			}
		}
	}

	/**
	 * @Controller 查詢店家資料 顯示資訊頁
	 */

	@RequestMapping(path = "/findStore")
	public String findStore(HttpSession httpSession, Model model) {
		Store storeSession = (Store) httpSession.getAttribute("storeSession");
		if (storeSession != null) {
			Store getstore = storeServiceImpl.findStore(storeSession.getStoreId());
			httpSession.setAttribute("storeSession", getstore);//存入將更改後的Store存到Session
			model.addAttribute("getstore", getstore);
			return "Store/stInformation";
		} else {
			return "MemberSystem/noLogin";
		}

	}

	/**
	 * @Controller 查詢店家資料來進行update
	 */

	@RequestMapping(path = "/findStoreToUpdate")
	public String findStoreToUpdate(HttpSession httpSession, Model model) {
		Store storeSession = (Store) httpSession.getAttribute("storeSession");
		if (storeSession != null) {
			Store getstore = storeServiceImpl.findStore(storeSession.getStoreId());
			model.addAttribute("getstore", getstore);
			return "Store/updateStore";
		} else {
			return "MemberSystem/noLogin";
		}
	}

	/**
	 *@Controller 商成資料更新
	 */
	@RequestMapping(path = "/updateStore")
	public String updateStore(Store store, HttpSession httpSession, Model model,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
		Member memberSession = (Member) httpSession.getAttribute("memberSession");// 取得Session的Member
		Store storeSession = (Store) httpSession.getAttribute("storeSession");// 取得Session的storeId
		model.addAttribute("storeInput", store);//如果錯誤將原本值返回
		if (memberSession == null && storeSession == null) {// 如果有登入 且註冊過商家話
			System.out.println("未登入");
			return "MemberSystem/noLogin";
		}else if (store.getStoreName().isEmpty()) {
			model.addAttribute("errorName", "商家名不可為空白");
			return "Store/updateStore";
		}else if (store.getStorePf().isEmpty()) {
			model.addAttribute("errorPf", "商家簡介不可為空白");
			return "Store/updateStore";
		}else if (store.getStoreTel().isEmpty()) {
			model.addAttribute("errorTel", "商家電話不可為空白");
			return "Store/updateStore";
		}else if (store.getStoreNumber().isEmpty()) {
			model.addAttribute("errorNumber", "商家帳戶不可為空白");
			return "Store/updateStore";
		}else if (store.getStoreAccount().isEmpty()) {
			model.addAttribute("errorAccount", "商家帳號不可為空白");
			return "Store/updateStore";
		}else if (store.getStorePiName().isEmpty()) {
			model.addAttribute("errorPiName", "負責人姓名不可為空白");
			return "Store/updateStore";
		}else if (store.getStorePiTwid().isEmpty()) {
			model.addAttribute("errorPiTwid", "負責人身分證不可為空白");
			return "Store/updateStore";
		}else if (store.getStorePiTel().isEmpty()) {
			model.addAttribute("errorPiTel", "負責人電話不可為空白");
			return "Store/updateStore";
		}else if (store.getStorePiAddress().isEmpty()) {
			model.addAttribute("errorPiAddress", "負責人地址不可為空白");
			return "Store/updateStore";
		}else if (storeServiceImpl.findStoreByStoreName(store)!=null&&
				!storeServiceImpl.findStore(storeSession.getStoreId()).getStoreName().equals(store.getStoreName())) {
			// 檢查商家名稱是否註冊過  當輸入名存在於資料庫  且跟原本資料庫存在的商家名稱不相同時
			model.addAttribute("errorRepeat", "商家名子重複");
			return "Store/updateStore";
		}else if (!file.getOriginalFilename().isEmpty()) {//如果有傳入檔案
		String fileType = file.getContentType(); // 獲得檔案型別
		if (fileType.equals("image/jpeg")|| fileType.equals("image/gif")) {// 查看圖片資料類型
			storeServiceImpl.deleteStorePic(storeSession.getStoreId(),request);// 刪除原本照片
			String path = storeServiceImpl.addStorePic(file, request);// 新增照片
			store.setStorePic(path);// 把圖片儲存路徑儲存到資料庫
			storeServiceImpl.updateStore(store,httpSession);// 進行更新
			} else {
				model.addAttribute("errorPic", "照片格式錯誤");
				return "Store/updateStore";
			}
			} else {
			storeServiceImpl.updateStore(store,httpSession);// 沒修改照片話直接更新	
	        }
		    return "redirect:/findStore";// 更改成功		
	}
}
