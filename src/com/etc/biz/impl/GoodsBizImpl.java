package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.GoodsBiz;
import com.etc.dao.GoodsDao;
import com.etc.entity.Goods;

@Service
public class GoodsBizImpl implements GoodsBiz{
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public List<Goods> queryGoodsAll() {
	
		return goodsDao.queryGoodsAll();
	}
	@Override
	public int AddGoods(Goods goods) {
		
		return goodsDao.AddGoods(goods);
	}

	@Override
	public int DeleteGoods(Goods goods) {

		return goodsDao.DeleteGoods(goods);
	}

	@Override
	public int EditorGoods(Goods goods) {
	
		return goodsDao.EditorGoods(goods);
	}

}
