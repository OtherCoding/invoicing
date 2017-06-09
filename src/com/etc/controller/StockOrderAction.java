package com.etc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etc.biz.EmployeesBiz;
import com.etc.biz.GoodsBiz;
import com.etc.biz.StockOrderBiz;
import com.etc.entity.Employees;
import com.etc.entity.Goods;
import com.etc.entity.StockOrder;

@Controller
public class StockOrderAction {

	@Autowired
	private StockOrderBiz stockOrderBiz;
	@Autowired
	private GoodsBiz goodsBiz;
	@Autowired
	private EmployeesBiz employeesBiz;
	
	@RequestMapping("/stockOrderShow")
	public ModelAndView stockOrderShow(){
		List<StockOrder> stockOrderList =stockOrderBiz.queryStockorderAll();
		List<Goods> goodsList=goodsBiz.queryGoodsAll();
		List<Employees>employeesList = employeesBiz.queryEmployeesAll();
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("stockOrderList", stockOrderList);
		mav.addObject("goodsList", goodsList);
		mav.addObject("employeesList", employeesList);
		return mav;
		
	}
	
	@RequestMapping("/stockOrderAdd")
	public ModelAndView stockOrderAdd(HttpServletRequest req){
		//获得传入的参数
		int goodsId=Integer.valueOf(req.getParameter("goodsId"));
		int empNo=Integer.valueOf(req.getParameter("empNo"));
		int stoNum=Integer.valueOf(req.getParameter("stoNum"));
		//获得goods实体类
		Goods goods=new Goods();
		goods.setGoodsId(goodsId);
		//获得Employees实体类
		Employees employees=new Employees();
		employees.setEmpNo(empNo);
		//获得StockOrder实体类
		
		StockOrder stockOrder=new StockOrder();
		stockOrder.setEmp(employees);
		stockOrder.setGoods(goods);
		stockOrder.setStoNum(stoNum);
		
		int num =stockOrderBiz.addStockorder(stockOrder);
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("num", num);
		
		return mav;
		
	}
	
	@RequestMapping("/stockOrderDel")
	public ModelAndView stockOrderDel(HttpServletRequest req){
		int stoId=Integer.valueOf(req.getParameter("stoId"));
		StockOrder stockOrder=new StockOrder();
		stockOrder.setStoId(stoId);
		int num =stockOrderBiz.delStockorder(stockOrder);
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("num", num);
		return mav;
		
	}
	
	@RequestMapping("/stockOrderUpdate")
	public ModelAndView stockOrderUpdate(HttpServletRequest req){
		int stoId=Integer.valueOf(req.getParameter("stoId"));
		int stoNum=Integer.valueOf(req.getParameter("stoNum"));
		System.out.println("编号"+stoId+"采购数量"+stoNum);
		StockOrder stockOrder=new StockOrder();
		stockOrder.setStoId(stoId);
		stockOrder.setStoNum(stoNum);
		int num =stockOrderBiz.updateStockorder(stockOrder);
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("num", num);
		return mav;
		
	}
}
