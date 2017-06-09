package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etc.dao.SupplierDao;
import com.etc.entity.Supplier;

@Service
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 
	
	@Override
	public List<Supplier> querySupplierAll() {
		System.out.println("进入SellSupplierImpl持久层");
		String stm = "com.etc.mapping.supplierMapper.querySupplierAll";
		List<Supplier> list = sqlSessionTemplate.selectList(stm);
		return list;
	}
	@Override
	public int AddSupplier(Supplier supplier) {
		System.out.println("进入AddSupplier持久层");
		String stm="com.etc.mapping.supplierMapper.addSupplier";
		int num=sqlSessionTemplate.insert(stm,supplier);
		return num;
	}

	@Override
	public int DeleteSupplier(Supplier supplier) {
		System.out.println("进入DeleteSupplier持久层");
		String stm="com.etc.mapping.supplierMapper.deleteSupplier";
		int num=sqlSessionTemplate.delete(stm,supplier);
		return num;
	}

	@Override
	public int EditorSupplier(Supplier supplier) {
		System.out.println("进入EditorSupplier持久层");
		String stm="com.etc.mapping.supplierMapper.editorSupplier";
		int num=sqlSessionTemplate.update(stm,supplier);
		return num;
	}

}