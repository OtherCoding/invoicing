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
import com.etc.entity.Goods;
import com.etc.entity.Sell;

//销售单控制层
@Controller
public class SellAction {
	@Autowired
	private SellBiz sellBiz;
	
	//展示销售单
	@RequestMapping("/showSell")
	public ModelAndView showSell(){
		
		System.out.println("进入showSell控制器  ");
		List<Sell> sellList = sellBiz.querySellAll();
		System.out.println("销售单的数量->"+sellList.size());
		
		ModelAndView mav = new ModelAndView("sell");
		mav.addObject("sellList", sellList);
		return mav;
		
	}
	//展示所有商品
	public void showGoodsAll(){
		
	}
	//通过销售单编号查出销售单
	@RequestMapping("/querySell")
	public ModelAndView querySell(HttpServletRequest request){
		System.out.println("进入querySell控制器  ");

		int sellId = Integer.valueOf(request.getParameter("sellId"));
		Sell sell = sellBiz.querySellSellId(sellId);
		System.out.println("销售单的数量->"+sell);
		
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("sell",sell);
		return mav;
	}
	
	//添加销售单
	@RequestMapping("/addSell")
	public ModelAndView addSell(HttpServletRequest request){
		System.out.println("进入addSell控制器  ");
		//获取值
		int addSellGoodsId = Integer.valueOf(request.getParameter("addSellGoodsId"));
		double addSellSinglePrice = Double.valueOf(request.getParameter("addSellSinglePrice"));
		int addSellCounts = Integer.valueOf(request.getParameter("addSellCounts"));
		String addSellTime = request.getParameter("addSellTime");
		//转换时间
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(addSellTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date date1 = new java.sql.Date(date.getTime());
		
		Goods goods = new Goods();
		goods.setGoodsId(addSellGoodsId);
		Sell sell = new Sell(0, goods, addSellCounts, addSellSinglePrice,date1);

		int result = sellBiz.addSell(sell);
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("addSellflag", 1);//添加成功返回1
			System.out.println("添加销售单成功");
		}else{
			mav.addObject("addSellflag", 0);//添加失败返回0
			System.out.println("添加销售单失败");
		}
		return mav;
	}
	//修改销售单
	@RequestMapping("/editorSell")
	public ModelAndView editorSell(HttpServletRequest request){
		System.out.println("进入editorSell控制器  ");
	
		int editorSellId = Integer.valueOf(request.getParameter("editorSellId"));
		double editorSellSinglePrice = Double.valueOf(request.getParameter("editorSellSinglePrice"));
		int editorSellCounts = Integer.valueOf(request.getParameter("editorSellCounts"));
		String editorSellTime = request.getParameter("editorSellTime");
		
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(editorSellTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	
		Sell sell = new Sell(editorSellId, null, editorSellCounts, editorSellSinglePrice, sqlDate);
		int result = 0;
		result = sellBiz.editorSell(sell);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("editorSellFlag", 1);//修改成功
			System.out.println("修改销售单成功");
		}else{
			mav.addObject("editorFlag", 0);//修改失败
			System.out.println("修改销售单失败");
		}
		return mav;
	}
	
	//删除销售单
	@RequestMapping("/deleteSell")
	public ModelAndView deleteSell(HttpServletRequest request){
		
		int deleteSellId = Integer.valueOf(request.getParameter("deleteSellId"));
		System.out.println("进入deleteSell控制器  ");
		int result = sellBiz.deleteSell(deleteSellId);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("deleteSellFlag", 1);//删除成功
			System.out.println("销售单删除成功");
		}else{
			mav.addObject("deleteSellFlag", 0);//删除失败
			System.out.println("销售单删除失败");
		}
		return mav;
	}
	

	
	
}
