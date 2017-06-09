package com.etc.dao;

import java.util.List;

import com.etc.entity.Company;

public interface CompanyDao {

	List<Company> queryCompanyAll();

	int alterCompany(Company company);

}
