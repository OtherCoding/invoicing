package com.etc.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.StorageDao;
import com.etc.entity.StorageInfo;

@Service
public class StorageDaoImpl implements StorageDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public List<StorageInfo> queryStorageInfo(Map<String, Object> map) {
		String stm="com.etc.mapping.storageMapper.queryStorageIn";
		List<StorageInfo> sInfos=sqlSessionTemplate.selectList(stm,map);
		return sInfos;
	}


	@Override
	public List<StorageInfo> queryStorageOutInfo(Map<String, Object> map) {
		String stm="com.etc.mapping.storageMapper.queryStorageOut";
		List<StorageInfo> sInfos=sqlSessionTemplate.selectList(stm,map);
		return sInfos;
	}


	@Override
	public Integer addStorageOut(StorageInfo storageInfo) {
		String stm="com.etc.mapping.storageMapper.addStorageOut";
		Integer num = sqlSessionTemplate.insert(stm, storageInfo);
		return num;
	}


	@Override
	public Integer addStorageIn(StorageInfo storageInfo) {
		String stm="com.etc.mapping.storageMapper.addStorageIn";
		int num = sqlSessionTemplate.insert(stm, storageInfo);
		return num;
	}


	@Override
	public Integer queryGoods(int goodsid) {
		String stm="com.etc.mapping.storageMapper.queryGoods";
		int num = sqlSessionTemplate.selectOne(stm, goodsid);
		return num;
	}


	@Override
	public Integer addStorageInFirst(StorageInfo storageInfo) {
		String stm="com.etc.mapping.storageMapper.addStorageInFirst";
		int num = sqlSessionTemplate.insert(stm, storageInfo);
		return num;
	}


	@Override
	public Integer queryStorageGoodCount(int goodsId) {
		String stm="com.etc.mapping.storageMapper.queryStorageGoodCount";
		int num = sqlSessionTemplate.selectOne(stm, goodsId);
		return num;
	}


	@Override
	public Integer updateStorageCount(StorageInfo storageInfo) {
		String stm="com.etc.mapping.storageMapper.upStorageCount";
		int num = sqlSessionTemplate.update(stm, storageInfo);
		return num;
	}

	
}
