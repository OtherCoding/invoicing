package com.etc.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etc.biz.EmployeesBiz;
import com.etc.biz.GoodsBiz;
import com.etc.biz.StockReturnOrderBiz;
import com.etc.entity.Employees;
import com.etc.entity.Goods;
import com.etc.entity.StockReturnOrder;

@Controller
public class StockReturnOrderAction {

	@Autowired
	private StockReturnOrderBiz stockReturnOrderBiz;
	@Autowired
	private GoodsBiz goodsBiz;
	@Autowired
	private EmployeesBiz employeesBiz;

	@RequestMapping("/stockReturnOrderShow")
	public ModelAndView stockReturnOrderShow() {
		List<StockReturnOrder> stockReturnOrderList = stockReturnOrderBiz.queryStockReturnOrderAll();
		List<Goods> goodsList = goodsBiz.queryGoodsAll();
		List<Employees> employeesList = employeesBiz.queryEmployeesAll();

		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("stockReturnOrderList", stockReturnOrderList);
		mav.addObject("goodsList", goodsList);
		mav.addObject("employeesList", employeesList);

		return mav;

	}

	@RequestMapping("/stockReturnOrderAdd")
	public ModelAndView stockReturnOrderAdd(HttpServletRequest req) {
		// 获得传入的参数
		int goodsId = Integer.valueOf(req.getParameter("goodsId"));
		int empNo = Integer.valueOf(req.getParameter("empNo"));
		Date stoReturnTime = Date.valueOf(req.getParameter("stoReturnTime"));
		int stoReturnNum = Integer.valueOf(req.getParameter("stoReturnNum"));
		// 实例Employees实体类
		Employees employees = new Employees();
		employees.setEmpNo(empNo);
		// 实例Goods实体类
		Goods goods = new Goods();
		goods.setGoodsId(goodsId);
		// 实例StockReturnOrderAdd实体类
		StockReturnOrder stockReturnOrder = new StockReturnOrder();
		stockReturnOrder.setGoods(goods);
		stockReturnOrder.setEmp(employees);
		stockReturnOrder.setStoReturnTime(stoReturnTime);
		stockReturnOrder.setStoReturnNum(stoReturnNum);
		// 将stockReturnOrder作为参数传入业务层
		Integer num = stockReturnOrderBiz.AddStockReturnOrder(stockReturnOrder);
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("num", num);
		return mav;

	}

	@RequestMapping("/stockReturnOrderDel")
	public ModelAndView stockReturnOrderDel(HttpServletRequest req) {
		int stoReturnId = Integer.valueOf(req.getParameter("stoReturnId"));
		StockReturnOrder stockReturnOrder = new StockReturnOrder();
		stockReturnOrder.setStoReturnId(stoReturnId);
		int num = stockReturnOrderBiz.delStockReturnOrder(stockReturnOrder);
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("num", num);
		return mav;

	}

	@RequestMapping("/stockReturnOrderUpdate")
	public ModelAndView stockReturnOrderUpdate(HttpServletRequest req) {
		int stoReturnId = Integer.valueOf(req.getParameter("stoReturnId"));
		int stoReturnNum = Integer.valueOf(req.getParameter("stoReturnNum"));
		StockReturnOrder stockReturnOrder = new StockReturnOrder();
		stockReturnOrder.setStoReturnId(stoReturnId);
		stockReturnOrder.setStoReturnNum(stoReturnNum);
		int num = stockReturnOrderBiz.updateStockReturnOrder(stockReturnOrder);
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("num", num);
		return mav;
	}
}