package com.etc.biz;

import java.util.List;

import com.etc.entity.Company;

public interface CompanyBiz {

	List<Company> queryCompanyAll();

	int alterCompany(Company company);

}
