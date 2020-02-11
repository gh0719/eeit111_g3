package com.fund.model.store.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fund.model.Store;

@Repository
public class StoreDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
//		return sessionFactory.openSession();
	}
	
	/**
	 * @Dao 註冊商家
	 */
  
	public void addStore(Store store) {
		try {
			getSession().save(store);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *@Dao 商家名稱是否重複
	 */

	public Store findStoreByName(Store store){
		String hqlstr = "From Store WHERE storeName=:Name";
		Query quert = getSession().createQuery(hqlstr).setParameter("Name", store.getStoreName());
		List<Store> listStore= quert.list();
		if(listStore.size()!=0) {
			Store getStore = listStore.get(0);
			return getStore;
		}else {
			return null;
		}
	}
	
	
	/**
	 *@Dao 查詢商店資料
	 */
	public Store findStore(Integer storeId) {	
		return getSession().get(Store.class, storeId);
	}
	
	
	/**
	 *@Dao 更改商家資料
	 */
	public void updateStore(Store store) {
		getSession().update(store);
	}

}
