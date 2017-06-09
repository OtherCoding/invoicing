package com.etc.dao;

import java.util.List;

import com.etc.entity.Employees;

public interface EmployeesDao {
	List<Employees>queryEmployeesAll();

	Employees queryEmployeesAll(int stoId);

	int AddEmployees(Employees employees);
	
	int DeleteEmployees(Employees employees);
	
	int editorEmployees(Employees employees);
	
}
