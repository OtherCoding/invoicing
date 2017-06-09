package com.etc.entity;

import java.sql.Date;

//NO 15 采购入库表（StockInOrder
public class StockInOrder {
	// 采购入库表编号，主键
	private int stoArriveId;

	// 员工编号 (fk 员工表)
	private Employees emp;
	// 采购订单编号 (fk 采购订单表)
	private StockOrder stockOrder;
	// 采购日期
	private Date stoArriveTime;
	// 入库数量
	private int stoArriveNum;

	public StockInOrder() {
		super();
		// TODO Auto-generated constructor stub
	}



	public StockInOrder(int stoArriveId, Employees emp, StockOrder stockOrder, Date stoArriveTime, int stoArriveNum) {
		super();
		this.stoArriveId = stoArriveId;
		this.emp = emp;
		this.stockOrder = stockOrder;
		this.stoArriveTime = stoArriveTime;
		this.stoArriveNum = stoArriveNum;
	}



	public int getStoArriveId() {
		return stoArriveId;
	}



	public void setStoArriveId(int stoArriveId) {
		this.stoArriveId = stoArriveId;
	}

	public Employees getEmp() {
		return emp;
	}

	public void setEmp(Employees emp) {
		this.emp = emp;
	}


	public StockOrder getStockOrder() {
		return stockOrder;
	}

	public void setStockOrder(StockOrder stockOrder) {
		this.stockOrder = stockOrder;
	}


	public Date getStoArriveTime() {
		return stoArriveTime;
	}



	public void setStoArriveTime(Date stoArriveTime) {
		this.stoArriveTime = stoArriveTime;
	}



	public int getStoArriveNum() {
		return stoArriveNum;
	}



	public void setStoArriveNum(int stoArriveNum) {
		this.stoArriveNum = stoArriveNum;
	}


}
