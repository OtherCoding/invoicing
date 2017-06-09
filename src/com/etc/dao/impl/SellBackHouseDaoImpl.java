package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.SellBackHouseDao;
import com.etc.entity.SellBackHouse;
@Service
public class SellBackHouseDaoImpl implements SellBackHouseDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<SellBackHouse> querySellBackHouseAll() {
		System.out.println("进入SellBackHouseDaoImpl持久层");
		String stm = "com.etc.mapping.sellBackHouseMapper.querySellBackHouseAll";
		List<SellBackHouse> list = sqlSessionTemplate.selectList(stm);
		return list;
	}

	@Override
	public int deleteSellBackHouse(int deleteSellBackHouseId) {
		System.out.println("进入deleteSellBackHouse持久层");
		String stm = "com.etc.mapping.sellBackHouseMapper.deleteSellBackHouse";
		int result = sqlSessionTemplate.delete(stm, deleteSellBackHouseId);
		return result;
	}

	@Override
	public int editorSellBackHouse(SellBackHouse sellBackHouse) {
		System.out.println("进入editorSellBackHouse持久层");
		String stm = "com.etc.mapping.sellBackHouseMapper.editorSellBackHouse";
		int result = sqlSessionTemplate.update(stm, sellBackHouse);
		return result;
	}

	@Override
	public int addSellBackHouse(SellBackHouse sellBackHouse) {
		System.out.println("进入addSellBackHouse持久层");
		String stm = "com.etc.mapping.sellBackHouseMapper.addSellBackHouse";
		int result = sqlSessionTemplate.insert(stm, sellBackHouse);
		return result;
	}

	@Override
	public SellBackHouse querySellBackHouse(int sellBackHouseId) {
		System.out.println("进入querySellBackHouse持久层");
		String stm = "com.etc.mapping.sellBackHouseMapper.querySellBackHouse";
		SellBackHouse sellBackHouse = sqlSessionTemplate.selectOne(stm,sellBackHouseId);
		return sellBackHouse;
	}

}
