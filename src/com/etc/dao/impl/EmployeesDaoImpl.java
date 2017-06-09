package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.EmployeesDao;
import com.etc.entity.Employees;
@Service
public class EmployeesDaoImpl implements EmployeesDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 

	@Override
	public List<Employees> queryEmployeesAll() {
		System.out.println("Ω¯»ÎEmployeesDaoImpl≥÷æ√≤„");
		String stm="com.etc.mapping.employeesMapper.queryEmployeesAll";
		List<Employees> list =sqlSessionTemplate.selectList(stm);
		System.out.println(list.size());
		return list;
	}

	@Override
	public Employees queryEmployeesAll(int stoId) {
		String stm="com.etc.mapping.employeesMapper.queryEmployees";
		Employees employees =sqlSessionTemplate.selectOne(stm, stoId);
		return employees;
	}
	
	@Override
	public int AddEmployees(Employees employees) {
		String stm="com.etc.mapping.employeesMapper.addEmployees";
		int num=sqlSessionTemplate.insert(stm,employees);
		return num;
	}

	@Override
	public int DeleteEmployees(Employees employees) {
		String stm="com.etc.mapping.employeesMapper.deleteEmployees";
		int num=sqlSessionTemplate.delete(stm,employees);
		return num;
	}

	@Override
	public int editorEmployees(Employees employees) {
		String stm="com.etc.mapping.employeesMapper.editorEmployees";
		int num=sqlSessionTemplate.update(stm,employees);
		return num;
	}

}
