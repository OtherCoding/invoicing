package com.etc.entity;

import java.sql.Date;

// NO 9 ���۵���Sell��
public class Sell {

	// ���۵���ţ�pk��
	private int sellId;
	// ��Ʒ��ţ�fk ��Ʒ��Ϣ��
	private Goods goods;
	// ����
	private int counts;
	// ���۵���
	private double sellSinglePrice;
	// ����ʱ��
	private Date sellTime;

	public Sell() {
		super();
	}

	public Sell(int sellId, Goods goods, int counts, double sellSinglePrice, Date sellTime) {
		super();
		this.sellId = sellId;
		this.goods = goods;
		this.counts = counts;
		this.sellSinglePrice = sellSinglePrice;
		this.sellTime = sellTime;
	}



	public int getSellId() {
		return sellId;
	}

	public void setSellId(int sellId) {
		this.sellId = sellId;
	}


	public Goods getGoods() {
		return goods;
	}



	public void setGoods(Goods goods) {
		this.goods = goods;
	}



	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public double getSellSinglePrice() {
		return sellSinglePrice;
	}

	public void setSellSinglePrice(double sellSinglePrice) {
		this.sellSinglePrice = sellSinglePrice;
	}

	public Date getSellTime() {
		return sellTime;
	}

	public void setSellTime(Date sellTime) {
		this.sellTime = sellTime;
	}

}
