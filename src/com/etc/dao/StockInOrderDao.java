package com.etc.dao;

import java.util.List;

import com.etc.entity.StockInOrder;

public interface StockInOrderDao {

	List<StockInOrder> queryStockInOrderAll();

	int AddStockInOrder(StockInOrder stockInOrder);

	int DelStockInOrder(StockInOrder stockInOrder);

	int updateStockInOrder(StockInOrder stockInOrder);

}
