package com.etc.entity;

import java.sql.Date;

//NO 13 采购退货单StockReturnOrder
public class StockReturnOrder {
	// 采购退货单编号，（pk）
	private int stoReturnId;
	// 商品编号， (fk 商品信息表)
	private Goods goods;
	// 员工编号 (fk 员工表)
	private Employees emp;
	// 采购退货日期
	private Date stoReturnTime;
	// 退货数量
	private int stoReturnNum;

	public StockReturnOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockReturnOrder(int stoReturnId, Goods goods, Employees emp, Date stoReturnTime, int stoReturnNum) {
		super();
		this.stoReturnId = stoReturnId;
		this.goods = goods;
		this.emp = emp;
		this.stoReturnTime = stoReturnTime;
		this.stoReturnNum = stoReturnNum;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Employees getEmp() {
		return emp;
	}

	public void setEmp(Employees emp) {
		this.emp = emp;
	}

	public int getStoReturnId() {
		return stoReturnId;
	}



	public void setStoReturnId(int stoReturnId) {
		this.stoReturnId = stoReturnId;
	}



	public Date getStoReturnTime() {
		return stoReturnTime;
	}



	public void setStoReturnTime(Date stoReturnTime) {
		this.stoReturnTime = stoReturnTime;
	}



	public int getStoReturnNum() {
		return stoReturnNum;
	}



	public void setStoReturnNum(int stoReturnNum) {
		this.stoReturnNum = stoReturnNum;
	}


}
