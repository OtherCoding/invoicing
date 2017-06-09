package com.etc.entity;

import java.sql.Date;

// NO 10 销售出库表（SellOutHouse）
public class SellOutHouse {
	// 销售出库单编号（pk）
	private int sellOutHouseId;
	// 日期
	private Date sellDate;
	// 数量
	private int counts;
	// 销售单编号（fk1 销售单表）
	private Sell sell;


	public SellOutHouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SellOutHouse(int sellOutHouseId, Date sellDate, int counts, Sell sell) {
		super();
		this.sellOutHouseId = sellOutHouseId;
		this.sellDate = sellDate;
		this.counts = counts;
		this.sell = sell;

	}

	public int getSellOutHouseId() {
		return sellOutHouseId;
	}

	public void setSellOutHouseId(int sellOutHouseId) {
		this.sellOutHouseId = sellOutHouseId;
	}


	public Date getSellDate() {
		return sellDate;
	}



	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}



	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public Sell getSell() {
		return sell;
	}

	public void setSell(Sell sell) {
		this.sell = sell;
	}



}
