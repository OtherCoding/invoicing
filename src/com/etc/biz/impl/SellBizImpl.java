package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.SellBiz;
import com.etc.dao.SellDao;
import com.etc.entity.Sell;
@Service
public class SellBizImpl implements SellBiz {
	@Autowired
	private SellDao sellDao;
	
	@Override
	public List<Sell> querySellAll() {
		
		return sellDao.querySellAll();
	}

	@Override
	public int deleteSell(int deleteSellId) {
		
		return sellDao.deleteSell(deleteSellId);
	}

	@Override
	public int editorSell(Sell sell) {
		
		return sellDao.editorSell(sell);
	}

	@Override
	public int addSell(Sell sell) {
		
		return sellDao.addSell(sell);
	}

	@Override
	public Sell querySellSellId(int SellId) {
		
		return sellDao.querySellSellId(SellId);
	}


	
}
