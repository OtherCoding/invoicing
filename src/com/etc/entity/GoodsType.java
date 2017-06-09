package com.etc.entity;

// NO 5 商品类型表goodsType
public class GoodsType {

	// 类型编号，主键
	private int goodsTypeId;
	// 种类名称
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
