package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etc.biz.SupplierBiz;
import com.etc.dao.SupplierDao;
import com.etc.entity.Supplier;


@Service
public class SupplierBizImpl implements SupplierBiz {
	@Autowired
	private SupplierDao supplierDao;
	
	@Override
	public List<Supplier> querySupplierAll() {
		return supplierDao.querySupplierAll();
	}

	@Override
	public int AddSupplier(Supplier supplier) {
		return supplierDao.AddSupplier(supplier);
	}

	@Override
	public int DeleteSupplier(Supplier supplier) {
		return supplierDao.DeleteSupplier(supplier);
	}

	@Override
	public int EditorSupplier(Supplier supplier) {
		return supplierDao.EditorSupplier(supplier);
	}
	
}
	
	
	
