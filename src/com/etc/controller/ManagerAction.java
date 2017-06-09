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
	//展示管理员
	@RequestMapping("/showManager")
	public ModelAndView showManager(){
		List<Manager> managers = managerBiz.queryManagerAll();
		ModelAndView mav = new ModelAndView("sysmanager");
		mav.addObject("managers", managers);
		
		//展示员工
		List<Employees> employees  = managerBiz.queryEmp();
		mav.addObject("employees", employees);
		return mav;
	}
	//删除管理员
	@RequestMapping("/deleteManager")
	public ModelAndView deleteManager(HttpServletRequest request){
		int i = Integer.valueOf(request.getParameter("sysmanager"));
		int j = managerBiz.deleteManager(i);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("j", j);
		return mav;
	}
	//查看员工编号及姓名
	@RequestMapping("/queryEmp")
	public ModelAndView queryEmp(){
		List<Employees> employees  = managerBiz.queryEmp();
		ModelAndView mav = new ModelAndView("sysmanager");
		mav.addObject("employees", employees);
		return mav;
	}
	//添加管理员
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
	//登录
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
