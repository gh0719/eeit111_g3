package com.fund.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "announcements")
public class Announcement {
	@Id
	@Column(name = "announcement_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	int	announcementId	;
	
	@Column(name = "announcement_tital")
	private	String	announcementTital	;
	
	@Column(name = "announcement_pf")
	private	String	announcementPf	;
	
	@Column(name = "announcement_pic")
	private	String	announcementPic	;
	
	@Column(name = "announcement_status")
	private	String	announcementStatus	;
	
	@Column(name = "announcement_date")
	private	Date	announcementDate	;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private	Manager	manager	;

	public int getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}

	public String getAnnouncementTital() {
		return announcementTital;
	}

	public void setAnnouncementTital(String announcementTital) {
		this.announcementTital = announcementTital;
	}

	public String getAnnouncementPf() {
		return announcementPf;
	}

	public void setAnnouncementPf(String announcementPf) {
		this.announcementPf = announcementPf;
	}

	public String getAnnouncementPic() {
		return announcementPic;
	}

	public void setAnnouncementPic(String announcementPic) {
		this.announcementPic = announcementPic;
	}

	public String getAnnouncementStatus() {
		return announcementStatus;
	}

	public void setAnnouncementStatus(String announcementStatus) {
		this.announcementStatus = announcementStatus;
	}

	public Date getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	

}
