package com.etc.entity;

//NO 14 �ɹ����� StockOrder
public class StockOrder {
	// �ɹ�������ţ�����(pk)
	private int stoId;
	// ��Ʒ��ţ���Ʒ��Ϣgoods���
	private Goods goods;
	// Ա����� ��fk��Ա��������
	private Employees emp;
	// �ɹ�����
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
