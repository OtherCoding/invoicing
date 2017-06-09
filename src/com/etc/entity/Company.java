package com.etc.entity;

//NO 1  公司信息表company
public class Company {
	// 公司编号，主键，唯一
	private int companyId;
	// 单位名称
	private String companyName;
	// 联系电话
	private String companyTel;
	// 传真
	private String companyFax;
	// 联系地址
	private String companyAddress;
	// 法人代表
	private String companyLegalPerson;
	// 公司帐号
	private String companyAccount;
	// 公司邮箱
	private String companyEmail;
	// 网址
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
