package com.etc.entity;

import java.sql.Date;

// NO 8 报价单表（GivePrice）
public class GivePrice {

	// 报价单单号（pk）
	private int givePriceId;
	// 报价员编号 （fk1 员工信息表 empNo）
	private Employees emp;
	// 日期
	private Date givePriceDate;
	// 商品编号（fk2 商品信息表 goodsId）
	private Goods goods;
	// 单价
	private int singlePrice;
	// 数量
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
