package com.etc.entity;

//NO 1  ��˾��Ϣ��company
public class Company {
	// ��˾��ţ�������Ψһ
	private int companyId;
	// ��λ����
	private String companyName;
	// ��ϵ�绰
	private String companyTel;
	// ����
	private String companyFax;
	// ��ϵ��ַ
	private String companyAddress;
	// ���˴���
	private String companyLegalPerson;
	// ��˾�ʺ�
	private String companyAccount;
	// ��˾����
	private String companyEmail;
	// ��ַ
	private String companyUrl;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Company(int companyId, String companyName, String companyTel, String companyFax, String companyAddress,
			String companyLegalPerson, String companyAccount, String companyEmail, String companyUrl) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyTel = companyTel;
		this.companyFax = companyFax;
		this.companyAddress = companyAddress;
		this.companyLegalPerson = companyLegalPerson;
		this.companyAccount = companyAccount;
		this.companyEmail = companyEmail;
		this.companyUrl = companyUrl;
	}


	public int getCompanyId() {
		return companyId;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyTel() {
		return companyTel;
	}


	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}


	public String getCompanyFax() {
		return companyFax;
	}


	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}


	public String getCompanyAddress() {
		return companyAddress;
	}


	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}


	public String getCompanyLegalPerson() {
		return companyLegalPerson;
	}


	public void setCompanyLegalPerson(String companyLegalPerson) {
		this.companyLegalPerson = companyLegalPerson;
	}


	public String getCompanyAccount() {
		return companyAccount;
	}


	public void setCompanyAccount(String companyAccount) {
		this.companyAccount = companyAccount;
	}


	public String getCompanyEmail() {
		return companyEmail;
	}


	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}


	public String getCompanyUrl() {
		return companyUrl;
	}


	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}



	

}
