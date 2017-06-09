package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.GoodsDao;
import com.etc.entity.Goods;

@Service
public class GoodsDaoImpl implements GoodsDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Goods> queryGoodsAll() {
		System.out.println("����GoodsDao�־ò�");
		String stm="com.etc.mapping.goodsMapper.queryGoodsAll";
		List<Goods>list=sqlSessionTemplate.selectList(stm);
		System.out.println(list.size());
		return list;
	} 
	@Override
	public int AddGoods(Goods goods) {
		System.out.println("����AddoodsDao�־ò�");
		String stm="com.etc.mapping.goodsMapper.addGoods";		
		int num=sqlSessionTemplate.insert(stm,goods);
		return num;
	}

	@Override
	public int EditorGoods(Goods goods) {
		System.out.println("����EditorGoods�־ò�");
		String stm="com.etc.mapping.goodsMapper.editorGoods";
		int num=sqlSessionTemplate.update(stm,goods);
		return num;
	}

	@Override
	public int DeleteGoods(Goods goods) {
		System.out.println("����DeleteGoods�־ò�");
		String stm="com.etc.mapping.goodsMapper.deleteGoods";
		int num=sqlSessionTemplate.delete(stm,goods);
		return num;
	} 
		

}
