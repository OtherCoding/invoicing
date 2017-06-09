package com.etc.biz;

import java.util.List;

import com.etc.entity.Employees;
import com.etc.entity.Manager;

public interface ManagerBiz {
	List<Manager> queryManagerAll();

	int deleteManager(int i);

	List<Employees> queryEmp();

	int addManager(Manager manager);

	int checkLogin(Manager manager);
}
