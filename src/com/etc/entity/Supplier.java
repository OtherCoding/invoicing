package com.etc.entity;

// NO 6 ��Ӧ����Ϣsupplier
public class Supplier {

	// ��Ӧ�̱�ţ�����
	private int supplierId;
	// ��Ӧ������
	private String supplierName;
	// ���
	private String supplierType;
	// ��ϵ��
	private String contacts;
	// ��ϵ�绰
	private int contactTel;
	// ��ַ
	private String supplierAddress;
	// ����c
	private int supplierFax;
	// ˵��
	private String supplierInfo;
	// ��Ӧ����������
	private int supplierAssess;

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Supplier(int supplierId, String supplierName, String supplierType, String contacts, int contactTel,
			String supplierAddress, int supplierFax, String supplierInfo, int supplierAssess) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierType = supplierType;
		this.contacts = contacts;
		this.contactTel = contactTel;
		this.supplierAddress = supplierAddress;
		this.supplierFax = supplierFax;
		this.supplierInfo = supplierInfo;
		this.supplierAssess = supplierAssess;
	}


	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public int getContactTel() {
		return contactTel;
	}

	public void setContactTel(int contactTel) {
		this.contactTel = contactTel;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public int getSupplierFax() {
		return supplierFax;
	}

	public void setSupplierFax(int supplierFax) {
		this.supplierFax = supplierFax;
	}

	public String getSupplierInfo() {
		return supplierInfo;
	}

	public void setSupplierInfo(String supplierInfo) {
		this.supplierInfo = supplierInfo;
	}

	public int getSupplierAssess() {
		return supplierAssess;
	}

	public void setSupplierAssess(int supplierAssess) {
		this.supplierAssess = supplierAssess;
	}


}
