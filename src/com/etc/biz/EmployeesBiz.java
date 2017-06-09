package com.etc.biz;

import java.util.List;

import com.etc.entity.Employees;

public interface EmployeesBiz {
	List<Employees> queryEmployeesAll();

	Employees queryEmployees(int stoId);
	
	int AddEmployees(Employees employees);
	
	int DeleteEmployees(Employees employees);
	
	int editorEmployees(Employees employees);

	
}
