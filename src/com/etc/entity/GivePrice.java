package com.etc.entity;

import java.sql.Date;

// NO 8 ���۵���GivePrice��
public class GivePrice {

	// ���۵����ţ�pk��
	private int givePriceId;
	// ����Ա��� ��fk1 Ա����Ϣ�� empNo��
	private Employees emp;
	// ����
	private Date givePriceDate;
	// ��Ʒ��ţ�fk2 ��Ʒ��Ϣ�� goodsId��
	private Goods goods;
	// ����
	private int singlePrice;
	// ����
	private int goodsCount;

	public GivePrice() {
		super();
		// TODO Auto-generated constructor stub
	}



	public GivePrice(int givePriceId, Employees emp, Date givePriceDate, Goods goods, int singlePrice, int goodsCount) {
		super();
		this.givePriceId = givePriceId;
		this.emp = emp;
		this.givePriceDate = givePriceDate;
		this.goods = goods;
		this.singlePrice = singlePrice;
		this.goodsCount = goodsCount;
	}



	public int getGivePriceId() {
		return givePriceId;
	}

	public void setGivePriceId(int givePriceId) {
		this.givePriceId = givePriceId;
	}


	public Date getGivePriceDate() {
		return givePriceDate;
	}

	public void setGivePriceDate(Date givePriceDate) {
		this.givePriceDate = givePriceDate;
	}


	public int getSinglePrice() {
		return singlePrice;
	}

	public void setSinglePrice(int singlePrice) {
		this.singlePrice = singlePrice;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}



	public Employees getEmp() {
		return emp;
	}



	public void setEmp(Employees emp) {
		this.emp = emp;
	}



	public Goods getGoods() {
		return goods;
	}



	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	

}
