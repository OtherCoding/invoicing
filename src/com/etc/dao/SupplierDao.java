package com.etc.dao;
import java.util.List;
import com.etc.entity.Supplier;

public interface SupplierDao {
	List<Supplier> querySupplierAll();
	
	int AddSupplier(Supplier supplier);
	
	int DeleteSupplier(Supplier supplier);
	
	int EditorSupplier(Supplier supplier);
}
