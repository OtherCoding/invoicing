package com.etc.biz;

import java.util.List;
import java.util.Map;

import com.etc.entity.StockInOrder;
import com.etc.entity.StorageInfo;

public interface StorageBiz {

	List<StorageInfo> queryStorageInfo(Map<String, Object> map);
	
	List<StorageInfo> queryStorageOutInfo(Map<String, Object> map);
	
	/**
	 * �����ⵥ
	 * @param storageInfo
	 * @return
	 */
	Integer addStorageIn(StorageInfo storageInfo);
	
	/**
	 * ��ӳ��ⵥ
	 * @param storageInfo
	 * @return
	 */
	Integer addStorageOut(StorageInfo storageInfo);
	/**
	 * ��ѯ��Ʒ�Ƿ����
	 * @param goodsid
	 * @return
	 */
	Integer queryGoods(int goodsid);
	/**
	 * �����Ʒ�����ڣ�����Ӵ���Ʒ
	 * @param storageInfo
	 * @return
	 */
	Integer addStorageInFirst(StorageInfo storageInfo);
	/**
	 * �鿴��Ӧ��Ʒ�Ŀ��
	 * @param goodsId
	 * @return
	 */
	Integer queryStorageGoodCount(int goodsId);
	/**
	 * �޸Ķ�Ӧ��Ʒ�Ŀ����
	 * @param storageInfo
	 * @return
	 */
	Integer updateStorageCount(StorageInfo storageInfo);
}
