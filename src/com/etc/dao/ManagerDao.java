package com.etc.dao;

import java.util.List;

import com.etc.entity.Employees;
import com.etc.entity.Manager;

public interface ManagerDao {

	List<Manager> queryManagerAll();

	int deleteManager(int i);

	List<Employees> queryEmp();

	int addManager(Manager manager);

	int checkLogin(Manager manager);

}
