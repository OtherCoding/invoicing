package com.etc.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etc.biz.EmployeesBiz;
import com.etc.biz.StockInOrderBiz;
import com.etc.biz.StockOrderBiz;
import com.etc.biz.SupplierBiz;
import com.etc.entity.Employees;
import com.etc.entity.StockInOrder;
import com.etc.entity.StockOrder;
import com.etc.entity.Supplier;

@Controller
public class StockInOrderAction {
	@Autowired
	private StockInOrderBiz stockInOrderBiz;
	@Autowired
	private EmployeesBiz employeesBiz;
	@Autowired
	private SupplierBiz supplierBiz;
	@Autowired
	private StockOrderBiz stockOrderBiz;

	@RequestMapping("/stockInOrderShow")
	public ModelAndView stockInOrderShow() {
		List<StockInOrder> stockInOrderList = stockInOrderBiz.queryStockInOrderAll();
		List<Employees> employeesList = employeesBiz.queryEmployeesAll();
		List<Supplier> supplierList = supplierBiz.querySupplierAll();
		List<StockOrder> stockOrderList = stockOrderBiz.queryStockorderAll();
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("stockInOrderList", stockInOrderList);
		mav.addObject("employeesList", employeesList);
		mav.addObject("supplierList", supplierList);
		mav.addObject("stockOrderList", stockOrderList);
		return mav;
	}

	@RequestMapping("/stockInOrderAdd")
	public ModelAndView stockInOrderAdd(HttpServletRequest req) {
		System.out.println("进入控制层11");
		// 获得传入的参数
		int stoId = Integer.valueOf(req.getParameter("stoId"));
		Date stoArriveTime = Date.valueOf(req.getParameter("stoArriveTime"));
		int stoArriveNum = Integer.valueOf(req.getParameter("stoArriveNum"));
		// 实例Employees实体类
		Employees employees = employeesBiz.queryEmployees(stoId);
	
		// 实例StockOrder实体类
		StockOrder stockOrder = stockOrderBiz.queryStockOrder(stoId);
		
		// 实例StockInOrder实体类
		StockInOrder stockInOrder = new StockInOrder();
		stockInOrder.setEmp(employees);
		stockInOrder.setStockOrder(stockOrder);
		stockInOrder.setStoArriveTime(stoArriveTime);
		stockInOrder.setStoArriveNum(stoArriveNum);
		int num = stockInOrderBiz.AddStockInOrder(stockInOrder);
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("num", num);
		return mav;
	}

	@RequestMapping("/stockInOrderDel")
	public ModelAndView stockInOrderDel(HttpServletRequest req) {
		int stoArriveId = Integer.valueOf(req.getParameter("stoArriveId"));
		StockInOrder stockInOrder = new StockInOrder();
		stockInOrder.setStoArriveId(stoArriveId);
		Integer num = stockInOrderBiz.DelStockInOrder(stockInOrder);
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("num", num);
		return mav;

	}

	@RequestMapping("/stockInOrderUpdate")
	public ModelAndView stockInOrderUpdate(HttpServletRequest req) {
		int stoArriveId = Integer.valueOf(req.getParameter("stoArriveId"));
		int stoArriveNum = Integer.valueOf(req.getParameter("stoArriveNum"));
		System.out.println("控制层编号" + stoArriveId + "入库数量" + stoArriveNum);
		StockInOrder stockInOrder = new StockInOrder();
		stockInOrder.setStoArriveId(stoArriveId);
		stockInOrder.setStoArriveNum(stoArriveNum);
		int num = stockInOrderBiz.updateStockInOrder(stockInOrder);
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("num", num);
		return mav;

	}
}
