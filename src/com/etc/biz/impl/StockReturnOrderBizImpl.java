package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.StockReturnOrderBiz;
import com.etc.dao.StockReturnOrderDao;
import com.etc.entity.StockReturnOrder;
@Service
public class StockReturnOrderBizImpl implements StockReturnOrderBiz {
	@Autowired
	private StockReturnOrderDao StockReturnOrderDao;

	@Override
	public List<StockReturnOrder> queryStockReturnOrderAll() {
		
		return StockReturnOrderDao.queryStockReturnOrderAll();
	}

	@Override
	public int AddStockReturnOrder(StockReturnOrder stockReturnOrder) {
	
		return StockReturnOrderDao.AddStockReturnOrder(stockReturnOrder);
	}

	@Override
	public int delStockReturnOrder(StockReturnOrder stockReturnOrder) {
	
		return StockReturnOrderDao.delStockReturnOrder(stockReturnOrder);
	}

	@Override
	public int updateStockReturnOrder(StockReturnOrder stockReturnOrder) {

		return StockReturnOrderDao.updateStockReturnOrder(stockReturnOrder);
	}

}
