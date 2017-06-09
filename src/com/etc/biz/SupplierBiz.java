package com.etc.biz;

import java.util.List;

import com.etc.entity.Supplier;

public interface SupplierBiz {
	List<Supplier> querySupplierAll();

	int AddSupplier(Supplier supplier);
	int DeleteSupplier(Supplier supplier);
	
	int EditorSupplier(Supplier supplier);
}
