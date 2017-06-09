package com.etc.entity;

// NO 7 ��Ʒ��Ϣgoods
public class Goods {

	// ��Ʒ��ţ�����
	private int goodsId;
	// ���ͱ�ţ�������Ʒ���ͱ�����
	private GoodsType goodsType;
	// ��Ʒ����
	private String goodsName;
	// Ʒ��
	private String brand;
	// �ͺ�
	private String productModel;
	// �����۸�
	private int costPrice;
	// ���ۼ۸�
	private int retailPrice;
	// ��Ʒ����
	private int goodsCode;
	// ������
	private int barCode;
	// ��Ӧ�̱�ţ����ù�Ӧ����Ϣ������
	private Supplier supplier;

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Goods(int goodsId, GoodsType goodsType, String goodsName, String brand, String productModel, int costPrice,
			int retailPrice, int goodsCode, int barCode, Supplier supplier) {
		super();
		this.goodsId = goodsId;
		this.goodsType = goodsType;
		this.goodsName = goodsName;
		this.brand = brand;
		this.productModel = productModel;
		this.costPrice = costPrice;
		this.retailPrice = retailPrice;
		this.goodsCode = goodsCode;
		this.barCode = barCode;
		this.supplier = supplier;
	}


	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}



	public GoodsType getGoodsType() {
		return goodsType;
	}



	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}



	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}

	public int getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(int retailPrice) {
		this.retailPrice = retailPrice;
	}

	public int getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}

	public int getBarCode() {
		return barCode;
	}

	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}








	public Supplier getSupplier() {
		return supplier;
	}








	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}



}
