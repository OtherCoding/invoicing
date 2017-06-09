package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.ManagerBiz;
import com.etc.dao.ManagerDao;
import com.etc.entity.Employees;
import com.etc.entity.Manager;
@Service
public class ManagerBizImpl implements ManagerBiz {
	@Autowired
	private ManagerDao managerDao;
	@Override
	public List<Manager> queryManagerAll() {
		
		return managerDao.queryManagerAll();
	}

	@Override
	public int deleteManager(int i) {
		// TODO Auto-generated method stub
		return managerDao.deleteManager(i);
	}

	@Override
	public List<Employees> queryEmp() {
		// TODO Auto-generated method stub
		return managerDao.queryEmp();
	}



	@Override
	public int addManager(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.addManager(manager);
	}

	@Override
	public int checkLogin(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.checkLogin(manager);
	}

}
