package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.CompanyBiz;
import com.etc.dao.CompanyDao;
import com.etc.entity.Company;
@Service
public class CompanyBizImpl implements CompanyBiz {
	@Autowired
	private CompanyDao companyDao;
	@Override
	public List<Company> queryCompanyAll() {
		// TODO Auto-generated method stub
		return companyDao.queryCompanyAll();
	}
	@Override
	public int alterCompany(Company company) {
		// TODO Auto-generated method stub
		return companyDao.alterCompany(company);
	}

}
