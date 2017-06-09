package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.EmployeesBiz;
import com.etc.dao.EmployeesDao;
import com.etc.entity.Employees;
@Service
public class EmployeesBizImpl implements EmployeesBiz {
	@Autowired
	private EmployeesDao employeesDao;
	@Override
	public List<Employees> queryEmployeesAll() {
	
		return employeesDao.queryEmployeesAll();
	}
	@Override
	public Employees queryEmployees(int stoId) {
		// TODO Auto-generated method stub
		return employeesDao.queryEmployeesAll(stoId);
	}
	
	@Override
	public int AddEmployees(Employees employees) {
		
		return employeesDao.AddEmployees(employees);
	}
	@Override
	public int DeleteEmployees(Employees employees) {
		
		return employeesDao.DeleteEmployees(employees);
	}
	@Override
	public int editorEmployees(Employees employees) {
		
		return employeesDao.editorEmployees(employees);
	}

}
