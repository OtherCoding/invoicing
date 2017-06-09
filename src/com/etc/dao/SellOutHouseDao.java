package com.etc.dao;

import java.util.List;

import com.etc.entity.SellOutHouse;

public interface SellOutHouseDao {

	List<SellOutHouse> querySellOutHouseAll();

	int deleteSellOutHouse(int deleteSellOutHouseId);

	int editorSellOutHouse(SellOutHouse sellOutHouse);

	int addSellOutHouse(SellOutHouse sellOutHouse);

	SellOutHouse querySellOutHouse(int sellOutHouseId);

}
