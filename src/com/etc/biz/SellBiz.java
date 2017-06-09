package com.etc.biz;

import java.util.List;

import com.etc.entity.Sell;
/**
 * 销售单接口
 * @author Administrator
 *
 */
public interface SellBiz {

	List<Sell> querySellAll();

	int deleteSell(int deleteSellId);

	int editorSell(Sell sell);

	int addSell(Sell sell);
	//通过销售单ID查销售单
	Sell querySellSellId(int SellId);

}
