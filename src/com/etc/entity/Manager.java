package com.etc.entity;

// NO 4 管理员信息表manager
public class Manager {
	// 管理员编号，主键
	private int managerId;
	// 管理员名称
	private String managerName;
	// 员工编号，引用员工表主键
	private Employees emp;
	// 管理员密码
	private String managerPwd;
	// 管理员权限
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
