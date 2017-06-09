package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.ManagerDao;
import com.etc.entity.Employees;
import com.etc.entity.Manager;
@Service
public class ManagerDaoImpl implements ManagerDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<Manager> queryManagerAll() {
		String stm = "com.etc.mapping.managerMapper.queryManagerAll";
		List<Manager> managers = sqlSessionTemplate.selectList(stm);
		return managers;
	}

	@Override
	public int deleteManager(int i) {
		String stm = "com.etc.mapping.managerMapper.deleteManager";
		int num = sqlSessionTemplate.delete(stm, i);
		return num;
	}

	@Override
	public List<Employees> queryEmp() {
		String stm = "com.etc.mapping.managerMapper.queryEmp";
		List<Employees> employees = sqlSessionTemplate.selectList(stm);
		return employees;
	}

	@Override
	public int addManager(Manager manager) {
		String stm = "com.etc.mapping.managerMapper.addManager";
		//System.out.println(manager.getManagerName());
		int i = sqlSessionTemplate.insert(stm, manager);
		return i;
	}

	@Override
	public int checkLogin(Manager manager) {
		String stm = "com.etc.mapping.managerMapper.checkLogin";
		//System.out.println(manager.getManagerName());
		int i = sqlSessionTemplate.selectOne(stm, manager);
		return i;
	}

	

}
