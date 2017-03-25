package com.manment.bean;

import java.util.Date;

/**
 * ҩƷ
 * 
 * @author admin
 *
 */
public class Drugs {
	private int dID;
	private String dName;//药名
	private int dNumber;//数量
	private int shelfLife;//保质期
	private Date productionDate;//生产日期 
	private Date validUntil;//过期时间
	private float buyPrice;//进价
	private float price;//售价
	private int discount;//会员折扣（如果98折
	private int prescription;//是否处方药 0否，1是处方药
	public Drugs(String dName, int dNumber, int shelfLife, Date productionDate, Date validUntil, float buyPrice,
			float price, int discount, int prescription) {
		super();
		this.dName = dName;
		this.dNumber = dNumber;
		this.shelfLife = shelfLife;
		this.productionDate = productionDate;
		this.validUntil = validUntil;
		this.buyPrice = buyPrice;
		this.price = price;
		this.discount = discount;
		this.prescription = prescription;
	}
	public Drugs() {
		super();
	}
	public int getdID() {
		return dID;
	}
	public void setdID(int dID) {
		this.dID = dID;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public int getdNumber() {
		return dNumber;
	}
	public void setdNumber(int dNumber) {
		this.dNumber = dNumber;
	}
	public int getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	public Date getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}
	public float getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getPrescription() {
		return prescription;
	}
	public void setPrescription(int prescription) {
		this.prescription = prescription;
	}
	@Override
	public String toString() {
		return "Drugs [dID=" + dID + ", dName=" + dName + ", dNumber=" + dNumber + ", shelfLife=" + shelfLife
				+ ", productionDate=" + productionDate + ", validUntil=" + validUntil + ", buyPrice=" + buyPrice
				+ ", price=" + price + ", discount=" + discount + ", prescription=" + prescription + "]";
	}
}
