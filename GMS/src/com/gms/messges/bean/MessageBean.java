package com.gms.messges.bean;

public class MessageBean {
	
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String message;
	private String attchmentPath;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAttchmentPath() {
		return attchmentPath;
	}
	public void setAttchmentPath(String attchmentPath) {
		this.attchmentPath = attchmentPath;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
