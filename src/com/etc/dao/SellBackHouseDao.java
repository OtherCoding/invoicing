package com.etc.dao;

import java.util.List;

import com.etc.entity.SellBackHouse;

public interface SellBackHouseDao {

	List<SellBackHouse> querySellBackHouseAll();

	int deleteSellBackHouse(int deleteSellBackHouseId);

	int editorSellBackHouse(SellBackHouse sellBackHouse);

	int addSellBackHouse(SellBackHouse sellBackHouse);
	
	//根据销售退货单编号查销售退货单
	SellBackHouse querySellBackHouse(int sellBackHouseId);

}
