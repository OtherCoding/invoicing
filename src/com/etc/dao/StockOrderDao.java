package com.etc.dao;

import java.util.List;

import com.etc.entity.StockOrder;

public interface StockOrderDao {

	List<StockOrder> queryStockorderAll();

	int addStockorder(StockOrder stockOrder);

	int delStockorder(StockOrder stockOrder);

	int updateStockorder(StockOrder stockOrder);

	StockOrder queryStockOrder(int sid);

}
