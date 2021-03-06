package com.manment.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * �û���
 * 
 * @author admin
 *
 */
public class User {
	private Integer uID;
	private String uName;
	private String uPhone;
	private String question;
	private String answer;
	private Date freezingTime;
	private Integer uType;/*0代表管理 1代表进货员2代表会员*/
	private Integer isFreezing; /*0假1真*/
	private String uPwd;
	private String nickName;
	
	public User(Integer uID, String uName, String uPhone, String question, String answer, Date freezingTime,
			Integer uType, Integer isFreezing, String uPwd, String nickName) {
		super();
		this.uID = uID;
		this.uName = uName;
		this.uPhone = uPhone;
		this.question = question;
		this.answer = answer;
		this.freezingTime = freezingTime;
		this.uType = uType;
		this.isFreezing = isFreezing;
		this.uPwd = uPwd;
		this.nickName = nickName;
	}

	public User() {
		super();
	}

	public Integer getuID() {
		return uID;
	}

	public void setuID(Integer uID) {
		this.uID = uID;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getFreezingTime() {
		return freezingTime;
	}

	public void setFreezingTime(Date freezingTime) {
		this.freezingTime = freezingTime;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getIsFreezing() {
		return isFreezing;
	}

	public void setIsFreezing(Integer isFreezing) {
		this.isFreezing = isFreezing;
	}
	
	//管理员
	public static Integer getAdmin(){
		return 0;
	}
	//买方
	public static Integer getBuyer(){
		return 1;
	}
	//会员
	public static Integer getUser(){
		return 2;
	}

	@Override
	public String toString() {
		return "User [uID=" + uID + ", uName=" + uName + ", uPhone=" + uPhone + ", question=" + question + ", answer="
				+ answer + ", freezingTime=" + freezingTime + ", uType=" + uType + ", isFreeing=" + isFreezing
				+ ", uPwd=" + uPwd + ", nickName=" + nickName + "]";
	}

}
