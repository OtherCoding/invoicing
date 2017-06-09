package com.etc.entity;

// NO 12 收款单表（GetMoney）
public class GetMoney {
	// 收款单编号（pk）
	private int getMoneySheetId;
	// 销售单编号（fk 销售单表）
	private Sell sell;
	// 应收款
	private double shouldGetMoney;
	// 收款
	private double getMoney;

	public GetMoney() {
		super();
	}

	public GetMoney(int getMoneySheetId, Sell sell, double shouldGetMoney, double getMoney) {
		super();
		this.getMoneySheetId = getMoneySheetId;
		this.sell = sell;
		this.shouldGetMoney = shouldGetMoney;
		this.getMoney = getMoney;
	}

	public int getGetMoneySheetId() {
		return getMoneySheetId;
	}

	public void setGetMoneySheetId(int getMoneySheetId) {
		this.getMoneySheetId = getMoneySheetId;
	}

	public Sell getSell() {
		return sell;
	}

	public void setSell(Sell sell) {
		this.sell = sell;
	}

	public double getShouldGetMoney() {
		return shouldGetMoney;
	}

	public void setShouldGetMoney(double shouldGetMoney) {
		this.shouldGetMoney = shouldGetMoney;
	}

	public double getGetMoney() {
		return getMoney;
	}

	public void setGetMoney(double getMoney) {
		this.getMoney = getMoney;
	}



}
