package com.etc.biz;

import java.util.List;

import com.etc.entity.Goods;

public interface GoodsBiz {
	List<Goods> queryGoodsAll();

	int AddGoods(Goods goods);
	int DeleteGoods(Goods goods);
	int EditorGoods(Goods goods);
}
