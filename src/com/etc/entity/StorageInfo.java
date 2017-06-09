package com.etc.entity;

import java.sql.Date;

//NO 16 �����ϸ��StorageInfo��
public class StorageInfo {
	// �����ϸ����,��/������pk��
	private int storageId;
	// ��Ʒ��ţ���Ʒ��Ϣgoods���(fk)
	private Goods goods;
	// ����
	private int storageGoodCount;
	//�������
	private int inStorCount;
	//��������
	private int outStorCount;
	//�������
	private String storageType;
	// ���ʱ��
	private Date inStorTime;
	// ����ʱ��
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
