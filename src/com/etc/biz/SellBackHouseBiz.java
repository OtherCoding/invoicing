package com.etc.biz;

import java.util.List;

import com.etc.entity.SellBackHouse;
/**
 * �����˻���ҵ���
 * @author Administrator
 *
 */
public interface SellBackHouseBiz {

	List<SellBackHouse> querySellBackHouseAll();

	int deleteSellBackHouse(int deleteSellBackHouseId);

	int editorSellBackHouse(SellBackHouse sellBackHouse);

	int addSellBackHouse(SellBackHouse sellBackHouse);
	
	//���������˻�����Ų������˻���
	SellBackHouse querySellBackHouse(int sellBackHouseId);
}
