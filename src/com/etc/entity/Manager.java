package com.etc.entity;

// NO 4 ����Ա��Ϣ��manager
public class Manager {
	// ����Ա��ţ�����
	private int managerId;
	// ����Ա����
	private String managerName;
	// Ա����ţ�����Ա��������
	private Employees emp;
	// ����Ա����
	private String managerPwd;
	// ����ԱȨ��
	private int permission;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Manager(int managerId, String managerName, Employees emp, String managerPwd, int permission) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.emp = emp;
		this.managerPwd = managerPwd;
		this.permission = permission;
	}



	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Employees getEmp() {
		return emp;
	}

	public void setEmp(Employees emp) {
		this.emp = emp;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

}
