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

//���۳��ⵥ���Ʋ�
@Controller
public class SellOutHouseAction {
	@Autowired
	private SellOutHouseBiz sellOutHouseBiz;
	@Autowired
	private SellBiz sellBiz;
	
	//������۳��ⵥ
	@RequestMapping("/addSellOutHouse")
	public ModelAndView addSellOutHouse(HttpServletRequest request){
		System.out.println("����addSellOutHouse������  ");
		//��ȡֵ
		int addSellOutHouseSellId = Integer.valueOf(request.getParameter("addSellOutHouseSellId"));
		int addSellOutHouseCount = Integer.valueOf(request.getParameter("addSellOutHouseCount"));
		String addSellOutHouseDate = request.getParameter("addSellOutHouseDate");
		//ת��ʱ��
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(addSellOutHouseDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date date1 = new java.sql.Date(date.getTime());
		//ͨ�����۱�id��ѯ���۱����
		Sell sell = sellBiz.querySellSellId(addSellOutHouseSellId);
		
		SellOutHouse sellOutHouse = new SellOutHouse(0, date1, addSellOutHouseCount, sell);

		int result = sellOutHouseBiz.addSellOutHouse(sellOutHouse);
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("addSellOutHouseFlag", 1);//��ӳɹ�����1
			System.out.println("������۳��ⵥ�ɹ�");
		}else{
			mav.addObject("addSellOutHouseFlag", 0);//���ʧ�ܷ���0
			System.out.println("������۳��ⵥʧ��");
		}
		return mav;
	}
	//�鿴���г��ⵥ
	@RequestMapping("/showSellOutHouseAll")
	public ModelAndView showSellOutHouseAll(){
		//��ѯ�������۶������������ʱչʾ���۶����������˵�
		List<Sell> sellList = sellBiz.querySellAll();
		
		System.out.println("����showSellOutHouseAll������  ");
		List<SellOutHouse> sellOutHouseList = sellOutHouseBiz.querySellOutHouseAll();
		System.out.println("���۳��ⵥ������->"+sellOutHouseList.size());
		ModelAndView mav = new ModelAndView("sell");
		mav.addObject("sellOutHouseList", sellOutHouseList);
		mav.addObject("sellList", sellList);
		return mav;
	}
	
	//ɾ�����۳��ⵥ
	@RequestMapping("/deleteSellOutHouse")
	public ModelAndView deleteSellOutHouse(HttpServletRequest request){
		
		int deleteSellOutHouseId = Integer.valueOf(request.getParameter("deleteSellOutHouseId"));
		System.out.println("����deleteSellOutHouse������  ");
		int result = sellOutHouseBiz.deleteSellOutHouse(deleteSellOutHouseId);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("deleteSellOutHouseFlag", 1);//ɾ���ɹ�
			System.out.println("���۳��ⵥɾ���ɹ�");
		}else{
			mav.addObject("deleteSellOutHouseFlag", 0);//ɾ��ʧ��
			System.out.println("���۳��ⵥɾ��ʧ��");
		}
		return mav;
	}
	//�޸����۳��ⵥ
	@RequestMapping("/editorSellOutHouse")
	public ModelAndView editorSellOutHouse(HttpServletRequest request){
		System.out.println("����editorSellOutHouse������  ");
	
		int editorSellOutHouseId = Integer.valueOf(request.getParameter("editorSellOutHouseId"));//���ⵥ���
		System.out.println(editorSellOutHouseId);
		int editorSellOutHouseCount = Integer.valueOf(request.getParameter("editorSellOutHouseCount"));//���۳�������
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
			mav.addObject("editorSellOutHouseFlag", 1);//�޸ĳɹ�
			System.out.println("�޸����۳��ⵥ�ɹ�");
		}else{
			mav.addObject("editorSellOutHouseFlag", 0);//�޸�ʧ��
			System.out.println("�޸����۳��ⵥʧ��");
		}
		return mav;
	}
	//ͨ�����۳���Id ������۳��ⵥ
	@RequestMapping("/querySellOutHouse")
	public ModelAndView querySellOutHouse(HttpServletRequest request){
		System.out.println("����querySellOutHouse������  ");
		
		int sellOutHouseId = Integer.valueOf(request.getParameter("sellOutHouseId"));//���ⵥ���
		SellOutHouse sellOutHouse = sellOutHouseBiz.querySellOutHouse(sellOutHouseId);
		ModelAndView mav = new ModelAndView("test");
		
		mav.addObject("sellOutHouse",sellOutHouse);
		return mav;
	}
}
