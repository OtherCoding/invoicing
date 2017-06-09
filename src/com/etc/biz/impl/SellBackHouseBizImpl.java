package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.SellBackHouseBiz;
import com.etc.dao.SellBackHouseDao;
import com.etc.entity.SellBackHouse;
@Service
public class SellBackHouseBizImpl implements SellBackHouseBiz {
	@Autowired
	private SellBackHouseDao sellBackHouseDao;
	@Override
	public List<SellBackHouse> querySellBackHouseAll() {
		
		return sellBackHouseDao.querySellBackHouseAll();
	}
	@Override
	public int deleteSellBackHouse(int deleteSellBackHouseId) {
		
		return sellBackHouseDao.deleteSellBackHouse(deleteSellBackHouseId);
	}
	@Override
	public int editorSellBackHouse(SellBackHouse sellBackHouse) {
		
		return sellBackHouseDao.editorSellBackHouse(sellBackHouse);
	}
	@Override
	public int addSellBackHouse(SellBackHouse sellBackHouse) {

		return sellBackHouseDao.addSellBackHouse(sellBackHouse);
	}
	//根据销售退货单编号查销售退货单
	@Override
	public SellBackHouse querySellBackHouse(int sellBackHouseId) {
		
		return sellBackHouseDao.querySellBackHouse(sellBackHouseId);
	}

}
