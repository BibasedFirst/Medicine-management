package com.manment.bean;

/**
 * ÏÂµ¥±í
 * 
 * @author admin
 *
 */
public class Shopping {
	private int sID;
	private int uID;
	private int dID;
	private int Number;
	private float UnitPrice;

	public Shopping() {
		super();
	}

	public Shopping(int uID, int dID, int number, float unitPrice) {
		super();
		this.uID = uID;
		this.dID = dID;
		Number = number;
		UnitPrice = unitPrice;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public int getdID() {
		return dID;
	}

	public void setdID(int dID) {
		this.dID = dID;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Shopping [sID=" + sID + ", uID=" + uID + ", dID=" + dID + ", Number=" + Number + ", UnitPrice="
				+ UnitPrice + "]";
	}

}
