package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.SellDao;
import com.etc.entity.Sell;
@Service
public class SellDaoImpl implements SellDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 

	@Override
	public List<Sell> querySellAll() {
		System.out.println("����SellDaoImpl�־ò�");
		String stm = "com.etc.mapping.sellMapper.querySellAll";
		List<Sell> list = sqlSessionTemplate.selectList(stm);
		//System.out.println(list.size());
		return list;
	}

	@Override
	public int deleteSell(int deleteSellId) {
		System.out.println("����deleteSell�־ò�");
		String stm = "com.etc.mapping.sellMapper.deleteSell";
		int result = sqlSessionTemplate.delete(stm, deleteSellId);
		return result;
	}

	@Override
	public int editorSell(Sell sell) {
		System.out.println("����editorSell�־ò�");
		String stm = "com.etc.mapping.sellMapper.editorSell";
		int result = sqlSessionTemplate.update(stm, sell);
		return result;
	}

	@Override
	public int addSell(Sell sell) {
		System.out.println("����addSell�־ò�");
		String stm = "com.etc.mapping.sellMapper.addSell";
		int result = sqlSessionTemplate.insert(stm, sell);
		return result;
	}
	//�������۵�Id�����۵�
	@Override
	public Sell querySellSellId(int sellId) {
		String stm = "com.etc.mapping.sellMapper.querySellSellId";
		Sell sell = sqlSessionTemplate.selectOne(stm, sellId);
		return sell;
	}


}
