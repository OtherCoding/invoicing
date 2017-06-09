package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.StockInOrderBiz;
import com.etc.dao.StockInOrderDao;
import com.etc.entity.StockInOrder;
import com.etc.entity.StockOrder;
@Service
public class StockInOrderBizImpl implements StockInOrderBiz {

	@Autowired
	private StockInOrderDao stockInOrderDao;
	@Override
	public List<StockInOrder> queryStockInOrderAll() {

		return stockInOrderDao.queryStockInOrderAll();
	}
	@Override
	public int AddStockInOrder(StockInOrder stockInOrder) {
	
		return stockInOrderDao.AddStockInOrder(stockInOrder);
	}
	@Override
	public int DelStockInOrder(StockInOrder stockInOrder) {

		return stockInOrderDao.DelStockInOrder(stockInOrder);
	}
	@Override
	public int updateStockInOrder(StockInOrder stockInOrder) {

		return stockInOrderDao.updateStockInOrder(stockInOrder);
	}

}
