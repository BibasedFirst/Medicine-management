package com.manment.bean;

import java.util.Date;

/**
 * ”√ªß±Ì
 * @author admin
 *
 */
public class User {
  private int uID;
  private String uName;
  private String uPhone;
  private String question;
  private String answer;
  private Date freezingTime;
  private int uType;
  private int isFreeing;
  private String uPwd;
  private String nickName;
public User() {
	super();
}
public User(String uName, String uPhone, String question, String answer, Date freezingTime, int uType, int isFreeing,
		String uPwd, String nickName) {
	super();
	this.uName = uName;
	this.uPhone = uPhone;
	this.question = question;
	this.answer = answer;
	this.freezingTime = freezingTime;
	this.uType = uType;
	this.isFreeing = isFreeing;
	this.uPwd = uPwd;
	this.nickName = nickName;
}
public int getuID() {
	return uID;
}
public void setuID(int uID) {
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
public Date getFreezingTime() {
	return freezingTime;
}
public void setFreezingTime(Date freezingTime) {
	this.freezingTime = freezingTime;
}
public int getuType() {
	return uType;
}
public void setuType(int uType) {
	this.uType = uType;
}
public int getIsFreeing() {
	return isFreeing;
}
public void setIsFreeing(int isFreeing) {
	this.isFreeing = isFreeing;
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
@Override
public String toString() {
	return "User [uID=" + uID + ", uName=" + uName + ", uPhone=" + uPhone + ", question=" + question + ", answer="
			+ answer + ", freezingTime=" + freezingTime + ", uType=" + uType + ", isFreeing=" + isFreeing + ", uPwd="
			+ uPwd + ", nickName=" + nickName + "]";
}
  
}

