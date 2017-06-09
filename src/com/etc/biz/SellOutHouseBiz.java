package com.etc.biz;

import java.util.List;

import com.etc.entity.SellOutHouse;
/**
 * 销售出库单业务层
 * @author Administrator
 *
 */
public interface SellOutHouseBiz {
	//查询所有销售出库单
	List<SellOutHouse> querySellOutHouseAll();
	//删除销售出库单
	int deleteSellOutHouse(int deleteSellOutHouseId);
	//修改销售出库单
	int editorSellOutHouse(SellOutHouse sellOutHouse);
	//添加销售出库单
	int addSellOutHouse(SellOutHouse sellOutHouse);
	//销售出货单id 查出货单对象
	SellOutHouse querySellOutHouse(int SellOutHouseId);
}
