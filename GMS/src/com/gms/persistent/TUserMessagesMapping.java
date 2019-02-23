package com.gms.persistent;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_messages_mapping")
public class TUserMessagesMapping {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_MESSAGE_SRNO")
	private Integer userMessageSrNo;
	@Column(name="USER_SRNO")
	private Integer userSrNo;
	@Column(name="MESSAGE_SRNO")
	private Integer messageSrNo;
	@Column(name="MESSAGE_TYPE_CD")
	private Integer messageTypeCd;
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
	
	@ManyToMany
	@JoinColumn(name="MESSAGE_SRNO",insertable = false,updatable = false)
	private List<TMessagesInfo> tMessagesInfo;
	
	@Column(name = "INVITE_TO")
	private Integer invitedUser;
	
	
	public Integer getInvitedUser() {
		return invitedUser;
	}
	public void setInvitedUser(Integer invitedUser) {
		this.invitedUser = invitedUser;
	}
	public int getUserMessageSrNo() {
		return userMessageSrNo;
	}
	public void setUserMessageSrNo(int userMessageSrNo) {
		this.userMessageSrNo = userMessageSrNo;
	}
	public int getUserSrNo() {
		return userSrNo;
	}
	public void setUserSrNo(int userSrNo) {
		this.userSrNo = userSrNo;
	}
	public int getMessageSrNo() {
		return messageSrNo;
	}
	public void setMessageSrNo(int messageSrNo) {
		this.messageSrNo = messageSrNo;
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
	public List<TMessagesInfo> gettMessagesInfo() {
		return tMessagesInfo;
	}
	public void settMessagesInfo(List<TMessagesInfo> tMessagesInfo) {
		this.tMessagesInfo = tMessagesInfo;
	}
	public Integer getMessageTypeCd() {
		return messageTypeCd;
	}
	public void setMessageTypeCd(Integer messageTypeCd) {
		this.messageTypeCd = messageTypeCd;
	}
	public void setUserMessageSrNo(Integer userMessageSrNo) {
		this.userMessageSrNo = userMessageSrNo;
	}
	public void setUserSrNo(Integer userSrNo) {
		this.userSrNo = userSrNo;
	}
	public void setMessageSrNo(Integer messageSrNo) {
		this.messageSrNo = messageSrNo;
	}
	
	

}
