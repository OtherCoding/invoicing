package com.etc.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etc.biz.CompanyBiz;
import com.etc.entity.Company;


@Controller
public class CompanyAction {
	@Autowired
	private CompanyBiz companyBiz;
	@RequestMapping("/showCompany")
	public ModelAndView showCompany(){
		List<Company> companys = companyBiz.queryCompanyAll();
		ModelAndView mav = new ModelAndView("sysmanager");
		mav.addObject("companys", companys);
		return mav;	
	}
	@RequestMapping("/alterCompany")
	public ModelAndView alterCompany(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int companyId = Integer.valueOf(request.getParameter("companyId"));
		String companyTel = request.getParameter("companyTel");
		String companyFax = request.getParameter("companyFax");
		String companyAddress = request.getParameter("companyAddress");
	
//		System.out.println(companyAddress);
//		System.out.println(companyTel);
//		System.out.println(companyFax);
//		System.out.println(companyId);
		String companyEmail = request.getParameter("companyEmail");
		
		//Company company = new Company(companyId, companyName, companyTel, companyFax, companyAddress, companyLegalPerson, companyAccount, companyEmail, companyUrl);
		
		Company company = new Company();
		company.setCompanyId(companyId);
		company.setCompanyTel(companyTel);
		company.setCompanyFax(companyFax);
		company.setCompanyAddress(companyAddress);
		company.setCompanyEmail(companyEmail);
		int i = companyBiz.alterCompany(company);
		ModelAndView mav = new ModelAndView("sysmanager");
		mav.addObject("i", i);
		return mav;	
	}
}
