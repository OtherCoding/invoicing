package com.etc.entity;

// NO 5 ��Ʒ���ͱ�goodsType
public class GoodsType {

	// ���ͱ�ţ�����
	private int goodsTypeId;
	// ��������
	private String goodsType;

	public GoodsType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoodsType(int goodsTypeId, String goodsType) {
		super();
		this.goodsTypeId = goodsTypeId;
		this.goodsType = goodsType;
	}

	public int getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

}
