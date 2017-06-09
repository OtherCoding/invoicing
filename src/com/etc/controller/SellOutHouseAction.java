package com.etc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etc.biz.SellBiz;
import com.etc.biz.SellOutHouseBiz;
import com.etc.entity.Sell;
import com.etc.entity.SellOutHouse;

//销售出库单控制层
@Controller
public class SellOutHouseAction {
	@Autowired
	private SellOutHouseBiz sellOutHouseBiz;
	@Autowired
	private SellBiz sellBiz;
	
	//添加销售出库单
	@RequestMapping("/addSellOutHouse")
	public ModelAndView addSellOutHouse(HttpServletRequest request){
		System.out.println("进入addSellOutHouse控制器  ");
		//获取值
		int addSellOutHouseSellId = Integer.valueOf(request.getParameter("addSellOutHouseSellId"));
		int addSellOutHouseCount = Integer.valueOf(request.getParameter("addSellOutHouseCount"));
		String addSellOutHouseDate = request.getParameter("addSellOutHouseDate");
		//转换时间
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(addSellOutHouseDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date date1 = new java.sql.Date(date.getTime());
		//通过销售表id查询销售表对象
		Sell sell = sellBiz.querySellSellId(addSellOutHouseSellId);
		
		SellOutHouse sellOutHouse = new SellOutHouse(0, date1, addSellOutHouseCount, sell);

		int result = sellOutHouseBiz.addSellOutHouse(sellOutHouse);
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("addSellOutHouseFlag", 1);//添加成功返回1
			System.out.println("添加销售出库单成功");
		}else{
			mav.addObject("addSellOutHouseFlag", 0);//添加失败返回0
			System.out.println("添加销售出库单失败");
		}
		return mav;
	}
	//查看所有出库单
	@RequestMapping("/showSellOutHouseAll")
	public ModelAndView showSellOutHouseAll(){
		//查询所有销售订单，方便添加时展示销售订单的下拉菜单
		List<Sell> sellList = sellBiz.querySellAll();
		
		System.out.println("进入showSellOutHouseAll控制器  ");
		List<SellOutHouse> sellOutHouseList = sellOutHouseBiz.querySellOutHouseAll();
		System.out.println("销售出库单的数量->"+sellOutHouseList.size());
		ModelAndView mav = new ModelAndView("sell");
		mav.addObject("sellOutHouseList", sellOutHouseList);
		mav.addObject("sellList", sellList);
		return mav;
	}
	
	//删除销售出库单
	@RequestMapping("/deleteSellOutHouse")
	public ModelAndView deleteSellOutHouse(HttpServletRequest request){
		
		int deleteSellOutHouseId = Integer.valueOf(request.getParameter("deleteSellOutHouseId"));
		System.out.println("进入deleteSellOutHouse控制器  ");
		int result = sellOutHouseBiz.deleteSellOutHouse(deleteSellOutHouseId);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("deleteSellOutHouseFlag", 1);//删除成功
			System.out.println("销售出库单删除成功");
		}else{
			mav.addObject("deleteSellOutHouseFlag", 0);//删除失败
			System.out.println("销售出库单删除失败");
		}
		return mav;
	}
	//修改销售出库单
	@RequestMapping("/editorSellOutHouse")
	public ModelAndView editorSellOutHouse(HttpServletRequest request){
		System.out.println("进入editorSellOutHouse控制器  ");
	
		int editorSellOutHouseId = Integer.valueOf(request.getParameter("editorSellOutHouseId"));//出库单编号
		System.out.println(editorSellOutHouseId);
		int editorSellOutHouseCount = Integer.valueOf(request.getParameter("editorSellOutHouseCount"));//销售出库数量
		System.out.println(editorSellOutHouseCount);
		String editorSellOutHouseDate = request.getParameter("editorSellOutHouseDate");
		System.out.println(editorSellOutHouseDate);
		
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(editorSellOutHouseDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	
		SellOutHouse sellOutHouse = new SellOutHouse(editorSellOutHouseId, sqlDate, editorSellOutHouseCount, null);
		int result = 0;
		result = sellOutHouseBiz.editorSellOutHouse(sellOutHouse);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("editorSellOutHouseFlag", 1);//修改成功
			System.out.println("修改销售出库单成功");
		}else{
			mav.addObject("editorSellOutHouseFlag", 0);//修改失败
			System.out.println("修改销售出库单失败");
		}
		return mav;
	}
	//通过销售出库Id 查出销售出库单
	@RequestMapping("/querySellOutHouse")
	public ModelAndView querySellOutHouse(HttpServletRequest request){
		System.out.println("进入querySellOutHouse控制器  ");
		
		int sellOutHouseId = Integer.valueOf(request.getParameter("sellOutHouseId"));//出库单编号
		SellOutHouse sellOutHouse = sellOutHouseBiz.querySellOutHouse(sellOutHouseId);
		ModelAndView mav = new ModelAndView("test");
		
		mav.addObject("sellOutHouse",sellOutHouse);
		return mav;
	}
}
