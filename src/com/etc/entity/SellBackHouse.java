package com.etc.entity;

import java.sql.Date;

// NO 11 销售退货表（SellBackHouse）
public class SellBackHouse {
	// 销售退后单编号(PK)
	private int sellbackSheetId;
	// 销售单_销售单编号（fk1 销售单表）
	private Sell sell;
	//退货数量
	private int counts;
	// 退货时间
	private Date backGoodsTime;
	//
	public SellBackHouse() {
		super();
		// TODO Auto-generated constructor stub
	}




	public SellBackHouse(int sellbackSheetId, Sell sell, int counts, Date backGoodsTime) {
		super();
		this.sellbackSheetId = sellbackSheetId;
		this.sell = sell;
		this.counts = counts;
		this.backGoodsTime = backGoodsTime;
	}




	public int getSellbackSheetId() {
		return sellbackSheetId;
	}

	public void setSellbackSheetId(int sellbackSheetId) {
		this.sellbackSheetId = sellbackSheetId;
	}


	public Sell getSell() {
		return sell;
	}



	public void setSell(Sell sell) {
		this.sell = sell;
	}


	public Date getBackGoodsTime() {
		return backGoodsTime;
	}

	public void setBackGoodsTime(Date backGoodsTime) {
		this.backGoodsTime = backGoodsTime;
	}

	public int getCounts() {
		return counts;
	}




	public void setCounts(int counts) {
		this.counts = counts;
	}
	

}
