package com.etc.biz;

import java.util.List;

import com.etc.entity.SellBackHouse;
/**
 * 销售退货单业务层
 * @author Administrator
 *
 */
public interface SellBackHouseBiz {

	List<SellBackHouse> querySellBackHouseAll();

	int deleteSellBackHouse(int deleteSellBackHouseId);

	int editorSellBackHouse(SellBackHouse sellBackHouse);

	int addSellBackHouse(SellBackHouse sellBackHouse);
	
	//根据销售退货单编号查销售退货单
	SellBackHouse querySellBackHouse(int sellBackHouseId);
}
