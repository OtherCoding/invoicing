package com.etc.biz;

import java.util.List;

import com.etc.entity.Sell;
/**
 * ���۵��ӿ�
 * @author Administrator
 *
 */
public interface SellBiz {

	List<Sell> querySellAll();

	int deleteSell(int deleteSellId);

	int editorSell(Sell sell);

	int addSell(Sell sell);
	//ͨ�����۵�ID�����۵�
	Sell querySellSellId(int SellId);

}
