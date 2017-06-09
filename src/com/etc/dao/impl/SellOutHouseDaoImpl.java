package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.SellOutHouseDao;
import com.etc.entity.SellOutHouse;
@Service
public class SellOutHouseDaoImpl implements SellOutHouseDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<SellOutHouse> querySellOutHouseAll() {
		System.out.println("����querySellOutHouseAll�־ò�");
		String stm = "com.etc.mapping.sellOutHouseMapper.querySellOutHouseAll";
		List<SellOutHouse> list = sqlSessionTemplate.selectList(stm);
		return list;
	}
	@Override
	public int deleteSellOutHouse(int deleteSellOutHouseId) {
		System.out.println("����deleteSellOutHouse�־ò�");
		String stm = "com.etc.mapping.sellOutHouseMapper.deleteSellOutHouse";
		int result = sqlSessionTemplate.delete(stm, deleteSellOutHouseId);
		return result;
	}
	@Override
	public int editorSellOutHouse(SellOutHouse sellOutHouse) {
		System.out.println("����editorSellOutHouse�־ò�");
		String stm = "com.etc.mapping.sellOutHouseMapper.editorSellOutHouse";
		int result = sqlSessionTemplate.update(stm, sellOutHouse);
		return result;
	}
	@Override
	public int addSellOutHouse(SellOutHouse sellOutHouse) {
		System.out.println("����addSellOutHouse�־ò�");
		String stm = "com.etc.mapping.sellOutHouseMapper.addSellOutHouse";
		int result = sqlSessionTemplate.update(stm, sellOutHouse);
		return result;
	}
	@Override
	public SellOutHouse querySellOutHouse(int sellOutHouseId) {
		System.out.println("����querySellOutHouse�־ò�");
		String stm = "com.etc.mapping.sellOutHouseMapper.querySellOutHouse";
		SellOutHouse sellOutHouse = sqlSessionTemplate.selectOne(stm, sellOutHouseId);
		return sellOutHouse;
	}
	
}
