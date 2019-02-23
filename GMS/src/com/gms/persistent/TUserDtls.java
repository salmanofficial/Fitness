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
@Table(name="t_user_dtls")
public class TUserDtls {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_DTLS_SRNO")
	private Integer userDtlsSrno;
	@Column(name="LANG_CD")
	private Integer langCd;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_SRNO",insertable = false,updatable = false)
	private TUserInfo tUserInfo;
	@Column(name="USER_SRNO")
	private Integer userSrNo;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="DOB")
	private Date dob;
	@Column(name="GENDER_CD")
	private Integer genderCd;
	@Column(name="MOBILE_NO")
	private Long mobileNo;
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
	
	

	public TUserDtls() {
		// TODO Auto-generated constructor stub
	}

	public Integer getUserDtlsSrno() {
		return userDtlsSrno;
	}

	public void setUserDtlsSrno(Integer userDtlsSrno) {
		this.userDtlsSrno = userDtlsSrno;
	}

	public Integer getLangCd() {
		return langCd;
	}

	public void setLangCd(Integer langCd) {
		this.langCd = langCd;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getGenderCd() {
		return genderCd;
	}

	public void setGenderCd(Integer genderCd) {
		this.genderCd = genderCd;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
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

	public TUserInfo gettUserInfo() {
		return tUserInfo;
	}

	public void settUserInfo(TUserInfo tUserInfo) {
		this.tUserInfo = tUserInfo;
	}

	public Integer getUserSrNo() {
		return userSrNo;
	}

	public void setUserSrNo(Integer userSrNo) {
		this.userSrNo = userSrNo;
	}

	














}
