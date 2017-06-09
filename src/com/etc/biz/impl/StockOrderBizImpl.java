package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.StockOrderBiz;
import com.etc.dao.StockOrderDao;
import com.etc.entity.StockOrder;
@Service
public class StockOrderBizImpl implements StockOrderBiz {
	@Autowired
	private StockOrderDao stockorderDao;

	@Override
	public List<StockOrder> queryStockorderAll() {
	
		return stockorderDao.queryStockorderAll();
	}

	@Override
	public Integer addStockorder(StockOrder stockOrder) {

		return stockorderDao.addStockorder(stockOrder);
	}

	@Override
	public Integer delStockorder(StockOrder stockOrder) {
		
		return stockorderDao.delStockorder(stockOrder);
	}

	@Override
	public Integer updateStockorder(StockOrder stockOrder) {
		System.out.println("ÒµÎñÂß¼­²ã"+stockOrder.getStoNum());
		return stockorderDao.updateStockorder(stockOrder);
	}

	@Override
	public StockOrder queryStockOrder(int sto_id) {
		
		return stockorderDao.queryStockOrder(sto_id);
	}

}
