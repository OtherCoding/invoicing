package com.etc.entity;

//NO 3 Ա����Ϣ��employees
public class Employees {
	
	// Ա����ţ�����������
	private int empNo;
	// Ա������
	private String empName;
	// Ա��н��
	private int salary;
	// Ա��ְλ
	private String job;
	// ���ű��,���ò��ű�����
	private Department dept;
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(int empNo, String empName, int salary, String job, Department dept) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
		this.job = job;
		this.dept = dept;
	}

	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	
}
