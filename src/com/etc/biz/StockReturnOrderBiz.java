package com.etc.biz;

import java.util.List;

import com.etc.entity.StockReturnOrder;

public interface StockReturnOrderBiz {

	List<StockReturnOrder> queryStockReturnOrderAll();

	int AddStockReturnOrder(StockReturnOrder stockReturnOrder);

	int delStockReturnOrder(StockReturnOrder stockReturnOrder);

	int updateStockReturnOrder(StockReturnOrder stockReturnOrder);

}
