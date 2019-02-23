package com.gms.messges.bean;

import java.util.Date;

public class InboxBean {

	private Integer fromUserSrno;
	private String from;
	private String subject;
	private Integer messageSrNo;
	private Date receivedDate;
	private String message;
	private Integer coachId;
	private String coachName;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public Integer getCoachId() {
		return coachId;
	}
	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getMessageSrNo() {
		return messageSrNo;
	}
	public void setMessageSrNo(Integer messageSrNo) {
		this.messageSrNo = messageSrNo;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public Integer getFromUserSrno() {
		return fromUserSrno;
	}
	public void setFromUserSrno(Integer fromUserSrno) {
		this.fromUserSrno = fromUserSrno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
