package com.etc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etc.biz.GetMoneyBiz;
import com.etc.biz.SellBiz;
import com.etc.entity.GetMoney;
import com.etc.entity.Sell;
import com.etc.entity.SellBackHouse;

/**
 * 销售收款单Controller
 * @author Administrator
 *
 */
@Controller
public class getMoneyAction {
	
	@Autowired
	private GetMoneyBiz getMoneyBiz;
	@Autowired
	private SellBiz sellBiz;
	
	//添加销售收款单
	@RequestMapping("/addGetMoney")
	public ModelAndView addGetMoney(HttpServletRequest request){
		System.out.println("进入addGetMoney控制器  ");
		//获取值
		int addGetMoneySellId = Integer.valueOf(request.getParameter("addGetMoneySellId"));
		double addGetMoneyShouldGetMoney = Double.valueOf(request.getParameter("addGetMoneyShouldGetMoney"));
		double addGetMoneyGetMoney = Double.valueOf(request.getParameter("addGetMoneyGetMoney"));
		
		GetMoney getMoney = new GetMoney(0, new Sell(addGetMoneySellId, null, 0, 0, null), addGetMoneyShouldGetMoney, addGetMoneyGetMoney);
		
		
		int result = getMoneyBiz.addGetMoney(getMoney);
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("addSellBackHouseFlag", 1);//添加成功返回1
			System.out.println("添加销售收款单成功");
		}else{
			mav.addObject("addSellBackHouseFlag", 0);//添加失败返回0
			System.out.println("添加销售收款单失败");
		}
		return mav;
	}
	
	//展示所有销售收款单
	@RequestMapping("/showGetMoney")
	public ModelAndView showGetMoney(){
		System.out.println("进入showGetMoney控制器  ");
		
		//查询所有销售订单，方便添加时展示销售订单的下拉菜单
		List<Sell> sellList = sellBiz.querySellAll();
		
		List<GetMoney> getMoneyList = getMoneyBiz.queryGetMoneyAll();
		System.out.println("收款单的数量->"+getMoneyList.size());
		ModelAndView mav = new ModelAndView("sell");
		mav.addObject("getMoneyList", getMoneyList);
		mav.addObject("sellList", sellList);
		return mav;
	}
	
	//删除销售收款单
	@RequestMapping("/deleteGetMoney")
	public ModelAndView deleteGetMoney(HttpServletRequest request){
		
		int deleteGetMoneyId = Integer.valueOf(request.getParameter("deleteGetMoneyId"));
		System.out.println("进入deleteGetMoney控制器  ");
		int result = getMoneyBiz.deleteGetMoney(deleteGetMoneyId);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("deleteGetMoneyFlag", 1);//删除成功
			System.out.println("收款单删除成功");
		}else{
			mav.addObject("deleteGetMoneyFlag", 0);//删除失败
			System.out.println("收款单删除失败");
		}
		return mav;
	}
	
	//修改销售收款单
	@RequestMapping("/editorGetMoney")
	public ModelAndView editorGetMoney(HttpServletRequest request){
		System.out.println("进入editorGetMoney控制器  ");
	
		int editorSellGetMoneySheetId = Integer.valueOf(request.getParameter("editorSellGetMoneySheetId"));//销售收款单编号
		System.out.println(editorSellGetMoneySheetId);
		int editorSellShouldGetMoney= Integer.valueOf(request.getParameter("editorSellShouldGetMoney"));//应收款
		System.out.println(editorSellShouldGetMoney);
		int editorSellGetMoney = Integer.valueOf(request.getParameter("editorSellGetMoney"));//实收款
		System.out.println(editorSellGetMoney);
		
		GetMoney getMoney = new GetMoney(editorSellGetMoneySheetId, null, editorSellShouldGetMoney, editorSellGetMoney);
		int result = 0;
		result = getMoneyBiz.editorGetMoney(getMoney);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("editorGetMoneyFlag", 1);//修改成功
			System.out.println("修改销售收款单成功");
		}else{
			mav.addObject("editorGetMoneyFlag", 0);//修改失败
			System.out.println("修改销售收款单失败");
		}
		return mav;
	}
}
