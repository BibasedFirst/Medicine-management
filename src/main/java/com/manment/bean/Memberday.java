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
	private Date MemberDay;//��Ա�ۿ�����
	private int IsEnable;//�Ƿ�����

	public Memberday() {
		super();
	}

	public Memberday(Date memberDay, int isEnable) {
		super();
		MemberDay = memberDay;
		IsEnable = isEnable;
	}

	public Memberday(int mID, Date memberDay, int isEnable) {
		super();
		this.mID = mID;
		MemberDay = memberDay;
		IsEnable = isEnable;
	}

	public int getmID() {
		return mID;
	}

	public void setmID(int mID) {
		this.mID = mID;
	}

	public Date getMemberDay() {
		return MemberDay;
	}

	public void setMemberDay(Date memberDay) {
		MemberDay = memberDay;
	}

	public int getIsEnable() {
		return IsEnable;
	}

	public void setIsEnable(int isEnable) {
		IsEnable = isEnable;
	}

	@Override
	public String toString() {
		return "Memberday [mID=" + mID + ", MemberDay=" + MemberDay + ", IsEnable=" + IsEnable + "]";
	}

}
