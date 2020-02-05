package com.fund.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager {
	@Id
	@Column(name = "manager_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ManagerId;

	@Column(name = "manager_account")
	private String managerAccount;

	@Column(name = "manager_pwd")
	private String managerPwd;

	@OneToMany(mappedBy = "manager")
	private Set<Announcement> announcement = new HashSet<Announcement>();

	public int getManagerId() {
		return ManagerId;
	}

	public void setManagerId(int managerId) {
		ManagerId = managerId;
	}

	public String getManagerAccount() {
		return managerAccount;
	}

	public void setManagerAccount(String managerAccount) {
		this.managerAccount = managerAccount;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	public Set<Announcement> getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Set<Announcement> announcement) {
		this.announcement = announcement;
	}



}
