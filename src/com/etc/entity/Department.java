package com.etc.entity;

//NO 2 部门表department
public class Department {
	
	// 部门编号，主键，唯一,
	private int deptNo;
	// 部门名称
	private String deptName;
	// 公司编号，引用公司信息表主键
	private Company company;
	// 部门负责人
	private String deptHeader;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int deptNo, String deptName, Company company, String deptHeader) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.company = company;
		this.deptHeader = deptHeader;
	}

	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	public String getDeptHeader() {
		return deptHeader;
	}
	public void setDeptHeader(String deptHeader) {
		this.deptHeader = deptHeader;
	}

	
}
