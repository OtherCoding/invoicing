package com.etc.entity;

import java.sql.Date;

//NO 16 库存明细表（StorageInfo）
public class StorageInfo {
	// 库存明细表编号,否/主键（pk）
	private int storageId;
	// 商品编号，商品信息goods外键(fk)
	private Goods goods;
	// 数量
	private int storageGoodCount;
	//入库数量
	private int inStorCount;
	//出库数量
	private int outStorCount;
	//库存类型
	private String storageType;
	// 入库时间
	private Date inStorTime;
	// 出库时间
	private Date outStorTime;
	

	public StorageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StorageInfo(int storageId, Goods goods, int storageGoodCount, int inStorCount, int outStorCount,
			String storageType, Date inStorTime, Date outStorTime) {
		super();
		this.storageId = storageId;
		this.goods = goods;
		this.storageGoodCount = storageGoodCount;
		this.inStorCount = inStorCount;
		this.outStorCount = outStorCount;
		this.storageType = storageType;
		this.inStorTime = inStorTime;
		this.outStorTime = outStorTime;
	}





	public int getStorageId() {
		return storageId;
	}


	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}


	public Goods getGoods() {
		return goods;
	}


	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	public int getStorageGoodCount() {
		return storageGoodCount;
	}


	public void setStorageGoodCount(int storageGoodCount) {
		this.storageGoodCount = storageGoodCount;
	}


	public int getInStorCount() {
		return inStorCount;
	}


	public void setInStorCount(int inStorCount) {
		this.inStorCount = inStorCount;
	}


	public int getOutStorCount() {
		return outStorCount;
	}


	public void setOutStorCount(int outStorCount) {
		this.outStorCount = outStorCount;
	}


	

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public Date getInStorTime() {
		return inStorTime;
	}


	public void setInStorTime(Date inStorTime) {
		this.inStorTime = inStorTime;
	}


	public Date getOutStorTime() {
		return outStorTime;
	}


	public void setOutStorTime(Date outStorTime) {
		this.outStorTime = outStorTime;
	}

	

}
