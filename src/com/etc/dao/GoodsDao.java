package com.etc.dao;

import java.util.List;

import com.etc.entity.Goods;

public interface GoodsDao {

	List<Goods> queryGoodsAll();

	int AddGoods(Goods goods);
	
	int DeleteGoods(Goods goods);
	
	int EditorGoods(Goods goods);
}
