package com.etc.dao;

import java.util.List;
import java.util.Map;

import com.etc.entity.StorageInfo;

public interface StorageDao {

	List<StorageInfo> queryStorageInfo(Map<String, Object> map);

	List<StorageInfo> queryStorageOutInfo(Map<String, Object> map);
	/**
	 * 添加出库单
	 * @param storageInfo
	 * @return
	 */
	Integer addStorageOut(StorageInfo storageInfo);
	/**
	 * 添加入库单
	 * @param storageInfo
	 * @return
	 */
	Integer addStorageIn(StorageInfo storageInfo);
	/**
	 * 查询商品是否存在
	 * @param goodsid
	 * @return
	 */
	Integer queryGoods(int goodsid);
	/**
	 * 如果商品不存在，则添加此商品
	 * @param storageInfo
	 * @return
	 */
	Integer addStorageInFirst(StorageInfo storageInfo);
	/**
	 * 查看对应商品的库存数量
	 * @param goodsId
	 * @return
	 */
	Integer queryStorageGoodCount(int goodsId);
	/**
	 * 修改对应商品的库存数
	 * @param storageInfo
	 * @return
	 */
	Integer updateStorageCount(StorageInfo storageInfo);
}
