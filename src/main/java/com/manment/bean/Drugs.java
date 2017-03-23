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
	private String dName;
	private int dNumber;
	private int ShelfLife;
	private Date ProductionDate;
	private Date ValidUntil;
	private float BuyPrice;
	private float Price;
	private int Discount;

	public Drugs(String dName, int dNumber, int shelfLife, Date productionDate, Date validUntil, float buyPrice,
			float price, int discount) {
		super();
		this.dName = dName;
		this.dNumber = dNumber;
		ShelfLife = shelfLife;
		ProductionDate = productionDate;
		ValidUntil = validUntil;
		BuyPrice = buyPrice;
		Price = price;
		Discount = discount;
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
		return ShelfLife;
	}

	public void setShelfLife(int shelfLife) {
		ShelfLife = shelfLife;
	}

	public Date getProductionDate() {
		return ProductionDate;
	}

	public void setProductionDate(Date productionDate) {
		ProductionDate = productionDate;
	}

	public Date getValidUntil() {
		return ValidUntil;
	}

	public void setValidUntil(Date validUntil) {
		ValidUntil = validUntil;
	}

	public float getBuyPrice() {
		return BuyPrice;
	}

	public void setBuyPrice(float buyPrice) {
		BuyPrice = buyPrice;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public int getDiscount() {
		return Discount;
	}

	public void setDiscount(int discount) {
		Discount = discount;
	}

	@Override
	public String toString() {
		return "Drugs [dID=" + dID + ", dName=" + dName + ", dNumber=" + dNumber + ", ShelfLife=" + ShelfLife
				+ ", ProductionDate=" + ProductionDate + ", ValidUntil=" + ValidUntil + ", BuyPrice=" + BuyPrice
				+ ", Price=" + Price + ", Discount=" + Discount + "]";
	}

}
