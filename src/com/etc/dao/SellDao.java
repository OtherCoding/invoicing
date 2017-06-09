package com.etc.dao;

import java.util.List;

import com.etc.entity.Sell;

public interface SellDao {

	List<Sell> querySellAll();

	int deleteSell(int deleteSellId);

	int editorSell(Sell sell);

	int addSell(Sell sell);

	Sell querySellSellId(int sellId);

}
