package com.etc.entity;

//NO 2 ���ű�department
public class Department {
	
	// ���ű�ţ�������Ψһ,
	private int deptNo;
	// ��������
	private String deptName;
	// ��˾��ţ����ù�˾��Ϣ������
	private Company company;
	// ���Ÿ�����
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
