package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.StockReturnOrderDao;
import com.etc.entity.StockReturnOrder;
@Service
public class StockReturnOrderDaoImpl implements StockReturnOrderDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<StockReturnOrder> queryStockReturnOrderAll() {
		String stm = "com.etc.mapping.stockReturnOrderMapper.getStockReturnOrderAll";
		List<StockReturnOrder> list = sqlSessionTemplate.selectList(stm);
		return list;
	}

	@Override
	public int AddStockReturnOrder(StockReturnOrder stockReturnOrder) {
		String stm = "com.etc.mapping.stockReturnOrderMapper.AddStockReturnOrder";
		int num = sqlSessionTemplate.insert(stm, stockReturnOrder);
		return num;
	}

	@Override
	public int delStockReturnOrder(StockReturnOrder stockReturnOrder) {
		String stm = "com.etc.mapping.stockReturnOrderMapper.delStockReturnOrder";
		int num = sqlSessionTemplate.delete(stm, stockReturnOrder);
		return num;
	}

	@Override
	public int updateStockReturnOrder(StockReturnOrder stockReturnOrder) {
		String stm = "com.etc.mapping.stockReturnOrderMapper.updateStockReturnOrder";
		int num = sqlSessionTemplate.update(stm, stockReturnOrder);
		return num;
	}

}
