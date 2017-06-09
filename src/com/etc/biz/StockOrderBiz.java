package com.etc.biz;

import java.util.List;

import com.etc.entity.StockOrder;
//²É¹ºµ¥
public interface StockOrderBiz {

	List<StockOrder> queryStockorderAll();

	Integer addStockorder(StockOrder stockOrder);

	Integer delStockorder(StockOrder stockOrder);

	Integer updateStockorder(StockOrder stockOrder);
	
	StockOrder queryStockOrder(int sid);

}
