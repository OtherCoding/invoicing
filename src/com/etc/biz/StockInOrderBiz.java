package com.etc.biz;

import java.util.List;

import com.etc.entity.StockInOrder;
import com.etc.entity.StockOrder;

//�ɹ���ⵥ
public interface StockInOrderBiz {

	List<StockInOrder> queryStockInOrderAll();

	int AddStockInOrder(StockInOrder stockInOrder);

	int DelStockInOrder(StockInOrder stockInOrder);

	int updateStockInOrder(StockInOrder stockInOrder);

}
