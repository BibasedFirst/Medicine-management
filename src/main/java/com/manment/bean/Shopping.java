package com.manment.bean;

/**
 * �µ���
 * 
 * @author admin
 *
 */
public class Shopping {
	private int sID;
	private int uID;
	private int dID;
	private int number;
	private float unitPrice;

	public Shopping() {
		super();
	}

	public Shopping(int uID, int dID, int number, float unitPrice) {
		super();
		this.uID = uID;
		this.dID = dID;
		this.number = number;
		this.unitPrice = unitPrice;
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
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Shopping [sID=" + sID + ", uID=" + uID + ", dID=" + dID + ", number=" + number + ", unitPrice="
				+ unitPrice + "]";
	}

	 
}
