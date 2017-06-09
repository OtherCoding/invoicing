package com.etc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etc.biz.ManagerBiz;
import com.etc.entity.Employees;
import com.etc.entity.Manager;


@Controller
public class ManagerAction {
	@Autowired
	private ManagerBiz managerBiz;
	//չʾ����Ա
	@RequestMapping("/showManager")
	public ModelAndView showManager(){
		List<Manager> managers = managerBiz.queryManagerAll();
		ModelAndView mav = new ModelAndView("sysmanager");
		mav.addObject("managers", managers);
		
		//չʾԱ��
		List<Employees> employees  = managerBiz.queryEmp();
		mav.addObject("employees", employees);
		return mav;
	}
	//ɾ������Ա
	@RequestMapping("/deleteManager")
	public ModelAndView deleteManager(HttpServletRequest request){
		int i = Integer.valueOf(request.getParameter("sysmanager"));
		int j = managerBiz.deleteManager(i);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("j", j);
		return mav;
	}
	//�鿴Ա����ż�����
	@RequestMapping("/queryEmp")
	public ModelAndView queryEmp(){
		List<Employees> employees  = managerBiz.queryEmp();
		ModelAndView mav = new ModelAndView("sysmanager");
		mav.addObject("employees", employees);
		return mav;
	}
	//��ӹ���Ա
	@RequestMapping("/addManager")
	public ModelAndView addManager(HttpServletRequest request ){
		Manager manager = new Manager();
		String  managerName = request.getParameter("managerName");
		String managerPwd = request.getParameter("managerPwd");
		int empNo = Integer.valueOf(request.getParameter("empNo"));
		int permission= Integer.valueOf(request.getParameter("permission"));
		Employees employees = new Employees();
		employees.setEmpNo(empNo);
		manager.setManagerName(managerName);
		manager.setManagerPwd(managerPwd);
		manager.setEmp(employees);
		manager.setPermission(permission);
		int i = managerBiz.addManager(manager);
		ModelAndView mav = new ModelAndView("sysmanager");
		mav.addObject("i", i);
		return mav;
	}
	//��¼
	@RequestMapping("/CheckLogin")
	public ModelAndView CheckLogin(HttpServletRequest request){
		Manager manager = new Manager();
		String managerName = request.getParameter("username");
		String managerPwd =request.getParameter("password");
		manager.setManagerName(managerName);
		manager.setManagerPwd(managerPwd);
		int num  = managerBiz.checkLogin(manager);
		ModelAndView mav = new ModelAndView("sysmanager");
		mav.addObject("num", num);
		return mav;
	}
}
