package com.etc.dao;

import java.util.List;

import com.etc.entity.StockReturnOrder;

public interface StockReturnOrderDao {

	List<StockReturnOrder> queryStockReturnOrderAll();

	int AddStockReturnOrder(StockReturnOrder stockReturnOrder);

	int delStockReturnOrder(StockReturnOrder stockReturnOrder);

	int updateStockReturnOrder(StockReturnOrder stockReturnOrder);

}
