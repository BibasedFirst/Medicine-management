package com.manment.bean;

import java.util.Date;

/**
 * �ۿ۱�
 * 
 * @author admin
 *
 */
public class Memberday {
	private int mID;
	private Date memberDay;//会员折扣日期
	private int isEnable;//是否启用

	public Memberday() {
		super();
	}

	public Memberday(int mID, Date memberDay, int isEnable) {
		super();
		this.mID = mID;
		this.memberDay = memberDay;
		this.isEnable = isEnable;
	}

	public Memberday(Date memberDay, int isEnable) {
		super();
		this.memberDay = memberDay;
		this.isEnable = isEnable;
	}

	public int getmID() {
		return mID;
	}

	public void setmID(int mID) {
		this.mID = mID;
	}

	public Date getMemberDay() {
		return memberDay;
	}

	public void setMemberDay(Date memberDay) {
		this.memberDay = memberDay;
	}

	public int getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}

	@Override
	public String toString() {
		return "Memberday [mID=" + mID + ", memberDay=" + memberDay + ", isEnable=" + isEnable + "]";
	}

	 
}
