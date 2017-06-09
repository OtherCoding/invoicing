package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.StockOrderDao;
import com.etc.entity.StockOrder;
@Service
public class StockOrderDaoImpl implements StockOrderDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<StockOrder> queryStockorderAll() {
		String stm = "com.etc.mapping.stockOrderMapper.getStockorderAll";
		List<StockOrder> list = sqlSessionTemplate.selectList(stm);
		return list;
	}

	@Override
	public int addStockorder(StockOrder stockOrder) {
		String stm = "com.etc.mapping.stockOrderMapper.addStockorder";
		int num=sqlSessionTemplate.insert(stm, stockOrder);
		System.out.println("进入持久层=-》"+num);
		return num;
	}

	@Override
	public int delStockorder(StockOrder stockOrder) {
		String stm = "com.etc.mapping.stockOrderMapper.delStockorder";
		int num=sqlSessionTemplate.delete(stm, stockOrder);
		
		return num;
	}

	@Override
	public int updateStockorder(StockOrder stockOrder) {
		String stm = "com.etc.mapping.stockOrderMapper.updateStockorder";
		int num=sqlSessionTemplate.update(stm, stockOrder);
		System.out.println("持久层"+stockOrder.getStoNum());
		return num;
	}

	@Override
	public StockOrder queryStockOrder(int sto_id) {
		String stm = "com.etc.mapping.stockOrderMapper.getStockorder";
		StockOrder stockOrder=sqlSessionTemplate.selectOne(stm, sto_id);
		
		return stockOrder;
	}

}
