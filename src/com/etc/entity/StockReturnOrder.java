package com.etc.entity;

import java.sql.Date;

//NO 13 �ɹ��˻���StockReturnOrder
public class StockReturnOrder {
	// �ɹ��˻�����ţ���pk��
	private int stoReturnId;
	// ��Ʒ��ţ� (fk ��Ʒ��Ϣ��)
	private Goods goods;
	// Ա����� (fk Ա����)
	private Employees emp;
	// �ɹ��˻�����
	private Date stoReturnTime;
	// �˻�����
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
