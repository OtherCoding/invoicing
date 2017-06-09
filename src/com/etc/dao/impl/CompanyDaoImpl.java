package com.etc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.CompanyDao;
import com.etc.entity.Company;
@Service
public class CompanyDaoImpl implements CompanyDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<Company> queryCompanyAll() {
		String stm = "com.etc.mapping.companyMapper.queryCompanyAll";
		List<Company> companys = sqlSessionTemplate.selectList(stm);
		return companys;
	}
	@Override
	public int alterCompany(Company company) {
		String stm = "com.etc.mapping.companyMapper.alterCompany";
		int i = sqlSessionTemplate.update(stm, company);
		return i;
	}

}
