package com.etc.entity;

import java.sql.Date;

//NO 15 �ɹ�����StockInOrder
public class StockInOrder {
	// �ɹ������ţ�����
	private int stoArriveId;

	// Ա����� (fk Ա����)
	private Employees emp;
	// �ɹ�������� (fk �ɹ�������)
	private StockOrder stockOrder;
	// �ɹ�����
	private Date stoArriveTime;
	// �������
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
