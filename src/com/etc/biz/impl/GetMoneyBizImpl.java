package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.GetMoneyBiz;
import com.etc.dao.GetMoneyDao;
import com.etc.entity.GetMoney;
/**
 * 销售收款业务层
 * @author Administrator
 *
 */
@Service
public class GetMoneyBizImpl implements GetMoneyBiz {
	@Autowired
	private GetMoneyDao getMoneyDao;

	@Override
	public List<GetMoney> queryGetMoneyAll() {
		return getMoneyDao.queryGetMoneyAll();
	}

	@Override
	public int deleteGetMoney(int deleteGetMoneyId) {
		
		return getMoneyDao.deleteGetMoney(deleteGetMoneyId);
	}
	//修改销售收款单
	@Override
	public int editorGetMoney(GetMoney getMoney) {
		
		return getMoneyDao.editorGetMoney(getMoney);
	}

	@Override
	public int addGetMoney(GetMoney getMoney) {
		
		return getMoneyDao.addGetMoney(getMoney);
	}
	
}
