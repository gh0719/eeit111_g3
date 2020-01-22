package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager {
	@Id
	@Column(name = "manager_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ManagerId;
	
	@Column(name = "manager_account")
	private String ManagerAccount;
	
	@Column(name = "manager_pwd")
	private String ManagerPwd;

	public int getManagerId() {
		return ManagerId;
	}

	public void setManagerId(int managerId) {
		ManagerId = managerId;
	}

	public String getManagerAccount() {
		return ManagerAccount;
	}

	public void setManagerAccount(String managerAccount) {
		ManagerAccount = managerAccount;
	}

	public String getManagerPwd() {
		return ManagerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		ManagerPwd = managerPwd;
	}

}
