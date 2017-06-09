package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.SellOutHouseBiz;
import com.etc.dao.SellOutHouseDao;
import com.etc.entity.SellOutHouse;
@Service
public class SellOutHouseBizImpl implements SellOutHouseBiz {
	@Autowired
	private SellOutHouseDao sellOutHouseDao;
	
	@Override
	public List<SellOutHouse> querySellOutHouseAll() {
		
		return sellOutHouseDao.querySellOutHouseAll();
	}

	@Override
	public int deleteSellOutHouse(int deleteSellOutHouseId) {

		return sellOutHouseDao.deleteSellOutHouse(deleteSellOutHouseId);
	}
	//修改销售出库单
	@Override
	public int editorSellOutHouse(SellOutHouse sellOutHouse) {
		
		return sellOutHouseDao.editorSellOutHouse(sellOutHouse);
	}

	@Override
	public int addSellOutHouse(SellOutHouse sellOutHouse) {
		
		return sellOutHouseDao.addSellOutHouse(sellOutHouse);
	}

	@Override
	public SellOutHouse querySellOutHouse(int SellOutHouseId) {
		
		return sellOutHouseDao.querySellOutHouse(SellOutHouseId);
	}

}
