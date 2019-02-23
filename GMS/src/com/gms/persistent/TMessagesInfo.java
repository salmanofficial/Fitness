package com.gms.persistent;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "t_messages_info")
public class TMessagesInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MESSAGE_SRNO")
	private Integer messageSrNo;
	@Column(name="SUBJECT")
	private String subject;
	@Column(name="MESSAGE")
	private String message;
	@Column(name="ATTACHMENT_PATH")
	private String attachmentPath;
	@Column(name="STATUS_CD")
	private Integer statusCd;
	@Column(name="LANG_CD")
	private Integer langCd;
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
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "tMessagesInfo")
	private List<TUserMessagesMapping> tUserMessagesMapping;
	
	public int getMessageSrNo() {
		return messageSrNo;
	}
	public void setMessageSrNo(int messageSrNo) {
		this.messageSrNo = messageSrNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public int getStatusCd() {
		return statusCd;
	}
	public void setStatusCd(int statusCd) {
		this.statusCd = statusCd;
	}
	public Integer getLangCd() {
		return langCd;
	}
	public void setLangCd(Integer langCd) {
		this.langCd = langCd;
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
	public List<TUserMessagesMapping> gettUserMessagesMapping() {
		return tUserMessagesMapping;
	}
	public void settUserMessagesMapping(List<TUserMessagesMapping> tUserMessagesMapping) {
		this.tUserMessagesMapping = tUserMessagesMapping;
	}

}
