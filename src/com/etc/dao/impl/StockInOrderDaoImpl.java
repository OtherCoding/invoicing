package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.StockInOrderDao;
import com.etc.entity.StockInOrder;
@Service
public class StockInOrderDaoImpl implements StockInOrderDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<StockInOrder> queryStockInOrderAll() {
		String stm = "com.etc.mapping.stockInOrderMapper.getStockInOrderAll";
		List<StockInOrder> list = sqlSessionTemplate.selectList(stm);
		System.out.println("queryStockInOrderAll:"+list.size());
		return list;
	}
	@Override
	public int AddStockInOrder(StockInOrder stockInOrder) {
		System.out.println("进入持久层");
		String stm = "com.etc.mapping.stockInOrderMapper.AddStockInOrder";
		int num=sqlSessionTemplate.insert(stm, stockInOrder);
		return num;
	}
	@Override
	public int DelStockInOrder(StockInOrder stockInOrder) {
		String stm = "com.etc.mapping.stockInOrderMapper.DelStockInOrder";
		int num=sqlSessionTemplate.delete(stm, stockInOrder);
		return num;
	}
	@Override
	public int updateStockInOrder(StockInOrder stockInOrder) {
		System.out.println("控制层stockInOrder"+stockInOrder.getStoArriveNum());
		String stm = "com.etc.mapping.stockInOrderMapper.updateStockInOrder";
		int num=sqlSessionTemplate.delete(stm, stockInOrder);
		return num;
	}

}
