package com.etc.entity;

//NO 14 采购订单 StockOrder
public class StockOrder {
	// 采购订单编号，主键(pk)
	private int stoId;
	// 商品编号，商品信息goods外键
	private Goods goods;
	// 员工编号 （fk）员工表主键
	private Employees emp;
	// 采购数量
	private int stoNum;

	public StockOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockOrder(int stoId, Goods goods, Employees emp, int stoNum) {
		super();
		this.stoId = stoId;
		this.goods = goods;
		this.emp = emp;
		this.stoNum = stoNum;
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

	public int getStoId() {
		return stoId;
	}

	public void setStoId(int stoId) {
		this.stoId = stoId;
	}

	public int getStoNum() {
		return stoNum;
	}

	public void setStoNum(int stoNum) {
		this.stoNum = stoNum;
	}

}
