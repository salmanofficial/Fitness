package com.gms.persistent;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_user_info")
public class TUserInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_SRNO",updatable=false,nullable=false) 
	private Integer userSrno;
	@Column(name="LANG_CD") 
	private Integer langCd;
	@Column(name="LOGIN_ID")
	private String loginId;
	@Column(name="LOGIN_PASSWORD") 
	private String loginPassword;
	@Column(name="RECORD_STATUS")
	private Character recordStatus;
	@Column(name="RECORD_CREATED_ON")
	private Date recordCreatedOn;
	@Column(name="RECORD_CREATED_BY")
	private Integer recordCreatedBy;
	@Column(name="RECORD_UPDATED_ON")
	private Date recordUpdatedOn;
	@Column(name="RECORD_UPDATED_BY")
	private Integer recordUpdatedBy;
	
	@OneToOne(mappedBy = "tUserInfo")
	private TUserDtls tUserDtls;
	
	@Column(name = "USER_TYPE")
	private String userType;
	
	public TUserInfo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getUserSrno() {
		return userSrno;
	}

	public void setUserSrno(Integer userSrno) {
		this.userSrno = userSrno;
	}

	public Integer getLangCd() {
		return langCd;
	}

	public void setLangCd(Integer langCd) {
		this.langCd = langCd;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Character getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Character recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Date getRecordCreatedOn() {
		return recordCreatedOn;
	}

	public void setRecordCreatedOn(Date recordCreatedOn) {
		this.recordCreatedOn = recordCreatedOn;
	}

	public Integer getRecordCreatedBy() {
		return recordCreatedBy;
	}

	public void setRecordCreatedBy(Integer recordCreatedBy) {
		this.recordCreatedBy = recordCreatedBy;
	}

	public Date getRecordUpdatedOn() {
		return recordUpdatedOn;
	}

	public void setRecordUpdatedOn(Date recordUpdatedOn) {
		this.recordUpdatedOn = recordUpdatedOn;
	}

	public Integer getRecordUpdatedBy() {
		return recordUpdatedBy;
	}

	public void setRecordUpdatedBy(Integer recordUpdatedBy) {
		this.recordUpdatedBy = recordUpdatedBy;
	}

	public TUserDtls gettUserDtls() {
		return tUserDtls;
	}

	public void settUserDtls(TUserDtls tUserDtls) {
		this.tUserDtls = tUserDtls;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	

}
