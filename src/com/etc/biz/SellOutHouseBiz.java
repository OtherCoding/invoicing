package com.etc.biz;

import java.util.List;

import com.etc.entity.SellOutHouse;
/**
 * ���۳��ⵥҵ���
 * @author Administrator
 *
 */
public interface SellOutHouseBiz {
	//��ѯ�������۳��ⵥ
	List<SellOutHouse> querySellOutHouseAll();
	//ɾ�����۳��ⵥ
	int deleteSellOutHouse(int deleteSellOutHouseId);
	//�޸����۳��ⵥ
	int editorSellOutHouse(SellOutHouse sellOutHouse);
	//������۳��ⵥ
	int addSellOutHouse(SellOutHouse sellOutHouse);
	//���۳�����id �����������
	SellOutHouse querySellOutHouse(int SellOutHouseId);
}
