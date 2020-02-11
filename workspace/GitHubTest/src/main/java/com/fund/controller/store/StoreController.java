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
		Member memberSession = (Member) httpSession.getAttribute("memberInformation");// 取得Session的Member
		Store storeidSession =   (Store) httpSession.getAttribute("store");// 取得Session的storeId
		if(memberSession!=null && storeidSession==null) {//如果有登入 且沒註冊過商家話
			if (!store.getStoreName().isEmpty()) {
			if (!store.getStorePf().isEmpty()) {
				if (!store.getStoreTel().isEmpty()) {
					if (!store.getStoreNumber().isEmpty()) {
						if (!store.getStoreAccount().isEmpty()) {
							if (!store.getStorePiName().isEmpty()) {
								if (!store.getStorePiTwid().isEmpty()) {
									if (!store.getStorePiTel().isEmpty()) {
										if (!store.getStorePiAddress().isEmpty()) {
											if (storeServiceImpl.findStoreByName(store) == null) {//檢查商家名稱是否註冊過
												String pic = storeServiceImpl.addStorePic(file, request);// 圖片存檔
												if (!pic.equals("errorPic")) {// 圖片存取正常
													store.setStorePic(pic);// 設定圖片路徑
													storeServiceImpl.addStore(store, httpSession);// 存入資料庫
													Store newStore = storeServiceImpl.findStoreByName(store);//取出鋼註冊好的store
													httpSession.setAttribute("store", newStore);// 將註冊好的StoreId 存入Session
													return "Store/save";// 註冊成功
												} else {
													model.addAttribute("storeInput", store);
													model.addAttribute("errorPicFormat", "輸入圖片格式錯誤  請確認");
													return "Store/storeRegister";
												}
											} else {
												model.addAttribute("storeInput", store);
												model.addAttribute("errorRepeat", "商家名子重複");
												return "Store/storeRegister";
											}
										} else {
											model.addAttribute("storeInput", store);
											model.addAttribute("errorPiAddress", "負責人地址不可為空白");
											return "Store/storeRegister";
										}
									} else {
										model.addAttribute("storeInput", store);
										model.addAttribute("errorPiTel", "負責人電話不可為空白");
										return "Store/storeRegister";
									}
								} else {
									model.addAttribute("storeInput", store);
									model.addAttribute("errorPiTwid", "負責人身分證不可為空白");
									return "Store/storeRegister";
								}
							} else {
								model.addAttribute("storeInput", store);
								model.addAttribute("errorPiName", "負責人姓名不可為空白");
								return "Store/storeRegister";
							}
						} else {
							model.addAttribute("storeInput", store);
							model.addAttribute("errorAccount", "商家帳號不可為空白");
							return "Store/storeRegister";
						}
					} else {
						model.addAttribute("storeInput", store);
						model.addAttribute("errorNumber", "商家帳戶不可為空白");
						return "Store/storeRegister";
					}
				} else {
					model.addAttribute("storeInput", store);
					model.addAttribute("errorTel", "商家電話不可為空白");
					return "Store/storeRegister";
				}
			} else {
				model.addAttribute("storeInput", store);
				model.addAttribute("errorPf", "商家簡介不可為空白");
				return "Store/storeRegister";
			}
		} else {
			model.addAttribute("storeInput", store);
			model.addAttribute("errorName", "商家名不可為空白");
			return "Store/storeRegister";
		}
		}else {
			return "MemberSystem/noLogin";
		}	
	}
	
	
	/**
	 *@Controller 查詢店家資料 顯示資訊頁
	 */
	
	@RequestMapping(path = "/findStore")
	public String findStore(HttpSession httpSession, Model model) {
		Store store =  (Store) httpSession.getAttribute("store");
		if(store!=null) {
				Store getstore = storeServiceImpl.findStore(store.getStoreId());
		model.addAttribute("getstore", getstore);
		return "Store/stInformation";
		}else {
			return "MemberSystem/noLogin";
		}
	
	}
	
	/**
	 *@Controller 查詢店家資料來進行update
	 */
	
	@RequestMapping(path = "/findStoreToUpdate")
	public String findStoreToUpdate(HttpSession httpSession, Model model) {
		Integer storeId = (Integer) httpSession.getAttribute("storeId");
		if(storeId!=null) {
		Store getstore = storeServiceImpl.findStore(storeId);
		model.addAttribute("getstore", getstore);
		return "Store/updateStore";
		}else {
			return "MemberSystem/noLogin";
		}
	}
	
	
	/**
	 * 
	 */
    public String updateStore(Store store,HttpSession httpSession,Model model, @RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		Member memberSession = (Member) httpSession.getAttribute("memberInformation");// 取得Session的Member
		Store storeidSession =   (Store) httpSession.getAttribute("store");// 取得Session的storeId
    	if(memberSession!=null&&storeidSession!=null) {//如果有登入 且註冊過商家話
			if (!store.getStoreName().isEmpty()) {
			if (!store.getStorePf().isEmpty()) {
				if (!store.getStoreTel().isEmpty()) {
					if (!store.getStoreNumber().isEmpty()) {
						if (!store.getStoreAccount().isEmpty()) {
							if (!store.getStorePiName().isEmpty()) {
								if (!store.getStorePiTwid().isEmpty()) {
									if (!store.getStorePiTel().isEmpty()) {
										if (!store.getStorePiAddress().isEmpty()) {
											if (storeServiceImpl.findStoreByName(store) == null) {//檢查商家名稱是否註冊過
												storeServiceImpl.deleteStorePic(storeidSession.getStoreId(), request);//刪除照片
												String pic = storeServiceImpl.addStorePic(file, request);// 圖片存檔
												if (!pic.equals("errorPic")) {// 圖片存取正常
													store.setStorePic(pic);// 設定圖片路徑
													
				
													return "Store/stInformation";// 更改成功
												} else {
													model.addAttribute("storeInput", store);
													model.addAttribute("errorPicFormat", "輸入圖片格式錯誤  請確認");
													return "Store/storeRegister";
												}
											} else {
												model.addAttribute("storeInput", store);
												model.addAttribute("errorRepeat", "商家名子重複");
												return "Store/storeRegister";
											}
										} else {
											model.addAttribute("storeInput", store);
											model.addAttribute("errorPiAddress", "負責人地址不可為空白");
											return "Store/storeRegister";
										}
									} else {
										model.addAttribute("storeInput", store);
										model.addAttribute("errorPiTel", "負責人電話不可為空白");
										return "Store/storeRegister";
									}
								} else {
									model.addAttribute("storeInput", store);
									model.addAttribute("errorPiTwid", "負責人身分證不可為空白");
									return "Store/storeRegister";
								}
							} else {
								model.addAttribute("storeInput", store);
								model.addAttribute("errorPiName", "負責人姓名不可為空白");
								return "Store/storeRegister";
							}
						} else {
							model.addAttribute("storeInput", store);
							model.addAttribute("errorAccount", "商家帳號不可為空白");
							return "Store/storeRegister";
						}
					} else {
						model.addAttribute("storeInput", store);
						model.addAttribute("errorNumber", "商家帳戶不可為空白");
						return "Store/storeRegister";
					}
				} else {
					model.addAttribute("storeInput", store);
					model.addAttribute("errorTel", "商家電話不可為空白");
					return "Store/storeRegister";
				}
			} else {
				model.addAttribute("storeInput", store);
				model.addAttribute("errorPf", "商家簡介不可為空白");
				return "Store/storeRegister";
			}
		} else {
			model.addAttribute("storeInput", store);
			model.addAttribute("errorName", "商家名不可為空白");
			return "Store/storeRegister";
		}
		}else {
			return "MemberSystem/noLogin";
		}
    }
	

}
