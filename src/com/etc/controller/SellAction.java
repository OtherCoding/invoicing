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

//���۵����Ʋ�
@Controller
public class SellAction {
	@Autowired
	private SellBiz sellBiz;
	
	//չʾ���۵�
	@RequestMapping("/showSell")
	public ModelAndView showSell(){
		
		System.out.println("����showSell������  ");
		List<Sell> sellList = sellBiz.querySellAll();
		System.out.println("���۵�������->"+sellList.size());
		
		ModelAndView mav = new ModelAndView("sell");
		mav.addObject("sellList", sellList);
		return mav;
		
	}
	//չʾ������Ʒ
	public void showGoodsAll(){
		
	}
	//ͨ�����۵���Ų�����۵�
	@RequestMapping("/querySell")
	public ModelAndView querySell(HttpServletRequest request){
		System.out.println("����querySell������  ");

		int sellId = Integer.valueOf(request.getParameter("sellId"));
		Sell sell = sellBiz.querySellSellId(sellId);
		System.out.println("���۵�������->"+sell);
		
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("sell",sell);
		return mav;
	}
	
	//������۵�
	@RequestMapping("/addSell")
	public ModelAndView addSell(HttpServletRequest request){
		System.out.println("����addSell������  ");
		//��ȡֵ
		int addSellGoodsId = Integer.valueOf(request.getParameter("addSellGoodsId"));
		double addSellSinglePrice = Double.valueOf(request.getParameter("addSellSinglePrice"));
		int addSellCounts = Integer.valueOf(request.getParameter("addSellCounts"));
		String addSellTime = request.getParameter("addSellTime");
		//ת��ʱ��
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
			mav.addObject("addSellflag", 1);//��ӳɹ�����1
			System.out.println("������۵��ɹ�");
		}else{
			mav.addObject("addSellflag", 0);//���ʧ�ܷ���0
			System.out.println("������۵�ʧ��");
		}
		return mav;
	}
	//�޸����۵�
	@RequestMapping("/editorSell")
	public ModelAndView editorSell(HttpServletRequest request){
		System.out.println("����editorSell������  ");
	
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
			mav.addObject("editorSellFlag", 1);//�޸ĳɹ�
			System.out.println("�޸����۵��ɹ�");
		}else{
			mav.addObject("editorFlag", 0);//�޸�ʧ��
			System.out.println("�޸����۵�ʧ��");
		}
		return mav;
	}
	
	//ɾ�����۵�
	@RequestMapping("/deleteSell")
	public ModelAndView deleteSell(HttpServletRequest request){
		
		int deleteSellId = Integer.valueOf(request.getParameter("deleteSellId"));
		System.out.println("����deleteSell������  ");
		int result = sellBiz.deleteSell(deleteSellId);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("deleteSellFlag", 1);//ɾ���ɹ�
			System.out.println("���۵�ɾ���ɹ�");
		}else{
			mav.addObject("deleteSellFlag", 0);//ɾ��ʧ��
			System.out.println("���۵�ɾ��ʧ��");
		}
		return mav;
	}
	

	
	
}
