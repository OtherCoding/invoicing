package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.GetMoneyDao;
import com.etc.entity.GetMoney;
import com.etc.entity.Sell;
@Service
public class GetMoneyDaoImpl implements GetMoneyDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<GetMoney> queryGetMoneyAll() {
		System.out.println("����GetMoneyDaoImpl�־ò�");
		String stm = "com.etc.mapping.getMoneyMapper.queryGetMoneyAll";
		List<GetMoney> list = sqlSessionTemplate.selectList(stm);
		return list;
	}
	@Override
	public int deleteGetMoney(int deleteGetMoneyId) {
		System.out.println("����GetMoneyDaoImpl�־ò�");
		String stm = "com.etc.mapping.getMoneyMapper.deleteGetMoney";
		int result = sqlSessionTemplate.delete(stm, deleteGetMoneyId);
		return result;
	}
	//�޸������տ
	@Override
	public int editorGetMoney(GetMoney getMoney) {
		System.out.println("����editorGetMoney�־ò�");
		String stm = "com.etc.mapping.getMoneyMapper.editorGetMoney";
		int result = sqlSessionTemplate.update(stm, getMoney);
		return result;
	}
	//��������տ
	@Override
	public int addGetMoney(GetMoney getMoney) {
		System.out.println("����addGetMoney�־ò�");
		String stm = "com.etc.mapping.getMoneyMapper.addGetMoney";
		int result = sqlSessionTemplate.insert(stm, getMoney);
		return result;
	}
	

}
