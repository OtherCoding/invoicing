package com.etc.entity;

import java.sql.Date;

// NO 10 ���۳����SellOutHouse��
public class SellOutHouse {
	// ���۳��ⵥ��ţ�pk��
	private int sellOutHouseId;
	// ����
	private Date sellDate;
	// ����
	private int counts;
	// ���۵���ţ�fk1 ���۵���
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
