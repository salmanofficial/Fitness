package com.gms.persistent;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_gender")
public class MGender {

	@Id
	@Column(name="GENDER_CD")
	private Integer genderCd;
	@Column(name="LANG_CD")
	private Integer langCd;
	@Column(name="GENDER_DESC")
	private String genderDesc;
	@Column(name="RECORD_STATUS")
	private String recordStatus;
	@Column(name="RECORD_CREATED_ON")
	private Date recordCreatedOn;
	@Column(name="RECORD_CREATED_BY")
	private Integer recordCreateBy;
	@Column(name="RECORD_UPDATED_ON")
	private Date recordUpdatedOn;
	@Column(name="RECORD_UPDATED_BY")
	private Integer recordUpdatedBy;
	public MGender() {
		
	}
	public Integer getGenderCd() {
		return genderCd;
	}
	public void setGenderCd(Integer genderCd) {
		this.genderCd = genderCd;
	}
	public Integer getLangCd() {
		return langCd;
	}
	public void setLangCd(Integer langCd) {
		this.langCd = langCd;
	}
	public String getGenderDesc() {
		return genderDesc;
	}
	public void setGenderDesc(String genderDesc) {
		this.genderDesc = genderDesc;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public Date getRecordCreatedOn() {
		return recordCreatedOn;
	}
	public void setRecordCreatedOn(Date recordCreatedOn) {
		this.recordCreatedOn = recordCreatedOn;
	}
	public Integer getRecordCreateBy() {
		return recordCreateBy;
	}
	public void setRecordCreateBy(Integer recordCreateBy) {
		this.recordCreateBy = recordCreateBy;
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
	
}
