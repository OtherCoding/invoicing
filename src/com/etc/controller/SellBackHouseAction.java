package com.etc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etc.biz.SellBackHouseBiz;
import com.etc.biz.SellBiz;
import com.etc.entity.Sell;
import com.etc.entity.SellBackHouse;
import com.etc.entity.SellOutHouse;

//销售退货单控制层
@Controller
public class SellBackHouseAction {
	@Autowired
	private SellBackHouseBiz sellBackHouseBiz;
	@Autowired
	private SellBiz sellBiz;

	//添加销售退货单
	@RequestMapping("/addSellBackHouse")
	public ModelAndView addSellBackHouse(HttpServletRequest request){
		System.out.println("进入addSellBackHouse控制器  ");
		//获取值
		int addSellBackHouseSellId = Integer.valueOf(request.getParameter("addSellBackHouseSellId"));
		int addSellBackHouseCounts = Integer.valueOf(request.getParameter("addSellBackHouseCounts"));
		String addSellBackHouseDate = request.getParameter("addSellBackHouseDate");
		//转换时间
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(addSellBackHouseDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date date1 = new java.sql.Date(date.getTime());
		//通过销售表id查询销售表对象
		Sell sell = sellBiz.querySellSellId(addSellBackHouseSellId);
		SellBackHouse sellBackHouse = new SellBackHouse(0, sell, addSellBackHouseCounts, date1);
		
		int result = sellBackHouseBiz.addSellBackHouse(sellBackHouse);
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("addSellBackHouseFlag", 1);//添加成功返回1
			System.out.println("添加销售退货单成功");
		}else{
			mav.addObject("addSellBackHouseFlag", 0);//添加失败返回0
			System.out.println("添加销售退货单失败");
		}
		return mav;
	}
	//展示所有销售退货单
	@RequestMapping("/showSellBackHouseAll")
	public ModelAndView showSellBackHouseAll(){
		System.out.println("进入showSellBackHouseAll控制器 ");
		
		//查询所有销售订单，方便添加时展示销售订单的下拉菜单
		List<Sell> sellList = sellBiz.querySellAll();
		List<SellBackHouse> backHouseList = sellBackHouseBiz.querySellBackHouseAll();
		
		System.out.println("销售退货单的数量->"+backHouseList.size());
		ModelAndView mav = new ModelAndView("sell");
		mav.addObject("backHouseList", backHouseList);
		mav.addObject("sellList", sellList);
		return mav;
	}
	
	//删除销售退货单
	@RequestMapping("/deleteSellBackHouse")
	public ModelAndView deleteSellBackHouse(HttpServletRequest request){
		
		int deleteSellBackHouseId = Integer.valueOf(request.getParameter("deleteSellBackHouseId"));
		System.out.println("进入deleteSellBackHouse控制器  ");
		int result = sellBackHouseBiz.deleteSellBackHouse(deleteSellBackHouseId);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("deleteSellBackHouseFlag", 1);//删除成功
			System.out.println("销售退货单删除成功");
		}else{
			mav.addObject("deleteSellBackHouseFlag", 0);//删除失败
			System.out.println("销售退货单删除失败");
		}
		return mav;
	}
	//修改销售退货单
	@RequestMapping("/editorSellBackHouse")
	public ModelAndView editorSellBackHouse(HttpServletRequest request){
		System.out.println("进入editorSellBackHouse控制器  ");
	
		int editorSellBackHouseId = Integer.valueOf(request.getParameter("editorSellBackHouseId"));//出库单编号
		System.out.println(editorSellBackHouseId);
		int editorSellBackHouseCount = Integer.valueOf(request.getParameter("editorSellBackHouseCount"));//销售出库数量
		System.out.println(editorSellBackHouseCount);
		String editorSellBackHouseTime = request.getParameter("editorSellBackHouseTime");
		System.out.println(editorSellBackHouseTime);
		
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(editorSellBackHouseTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	
		SellBackHouse sellBackHouse = new SellBackHouse(editorSellBackHouseId, null, editorSellBackHouseCount, sqlDate);
		int result = 0;
		result = sellBackHouseBiz.editorSellBackHouse(sellBackHouse);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("editorSellOutHouseFlag", 1);//修改成功
			System.out.println("修改销售退库单成功");
		}else{
			mav.addObject("editorSellOutHouseFlag", 0);//修改失败
			System.out.println("修改销售退库单失败");
		}
		return mav;
	}
	//通过销售出库Id 查出销售出库单
	@RequestMapping("/querySellBackHouse")
	public ModelAndView querySellBackHouse(HttpServletRequest request){
		System.out.println("进入querySellBackHouse控制器  ");
		
		int sellBackHouseId = Integer.valueOf(request.getParameter("sellBackHouseId"));//出库单编号
		SellBackHouse sellBackHouse = sellBackHouseBiz.querySellBackHouse(sellBackHouseId);
		ModelAndView mav = new ModelAndView("test");
		
		mav.addObject("sellBackHouse",sellBackHouse);
		return mav;
	}
}
