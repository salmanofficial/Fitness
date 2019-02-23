package com.gms.user.beans;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.gms.validators.checkWithExistIds;

public class UserBean {

	private Integer userSrno;
	@NotNull@NotEmpty
	@Pattern(regexp="^[a-zA-Z][a-zA-Z0-9_]*$")
	private String loginId;
	@NotEmpty
	@NotNull
	private String loginPassword;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-z]*$")
	private String firstName;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-z]*$")
	private String lastName;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date dob;
	private Long mobileNo;
	private Integer langCd;
	
	private Integer genderCd;
	private String userType;
	
	public UserBean() {
		
	}


	public Integer getUserSrno() {
		return userSrno;
	}


	public void setUserSrno(Integer userSrno) {
		this.userSrno = userSrno;
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


	public Long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public Integer getLangCd() {
		return langCd;
	}


	public void setLangCd(Integer langCd) {
		this.langCd = langCd;
	}

	public Integer getGenderCd() {
		return genderCd;
	}


	public void setGenderCd(Integer genderCd) {
		this.genderCd = genderCd;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		UserBean userBean = (UserBean)obj;
		return (this.loginId).equals(userBean.loginId);
	}
	@Override
	public int hashCode() {
		return loginId.hashCode();
	}
}
