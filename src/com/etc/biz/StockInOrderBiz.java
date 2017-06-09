package com.etc.biz;

import java.util.List;

import com.etc.entity.StockInOrder;
import com.etc.entity.StockOrder;

//²É¹ºÈë¿âµ¥
public interface StockInOrderBiz {

	List<StockInOrder> queryStockInOrderAll();

	int AddStockInOrder(StockInOrder stockInOrder);

	int DelStockInOrder(StockInOrder stockInOrder);

	int updateStockInOrder(StockInOrder stockInOrder);

}
