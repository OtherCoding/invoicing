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

//�����˻������Ʋ�
@Controller
public class SellBackHouseAction {
	@Autowired
	private SellBackHouseBiz sellBackHouseBiz;
	@Autowired
	private SellBiz sellBiz;

	//��������˻���
	@RequestMapping("/addSellBackHouse")
	public ModelAndView addSellBackHouse(HttpServletRequest request){
		System.out.println("����addSellBackHouse������  ");
		//��ȡֵ
		int addSellBackHouseSellId = Integer.valueOf(request.getParameter("addSellBackHouseSellId"));
		int addSellBackHouseCounts = Integer.valueOf(request.getParameter("addSellBackHouseCounts"));
		String addSellBackHouseDate = request.getParameter("addSellBackHouseDate");
		//ת��ʱ��
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(addSellBackHouseDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date date1 = new java.sql.Date(date.getTime());
		//ͨ�����۱�id��ѯ���۱����
		Sell sell = sellBiz.querySellSellId(addSellBackHouseSellId);
		SellBackHouse sellBackHouse = new SellBackHouse(0, sell, addSellBackHouseCounts, date1);
		
		int result = sellBackHouseBiz.addSellBackHouse(sellBackHouse);
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("addSellBackHouseFlag", 1);//��ӳɹ�����1
			System.out.println("��������˻����ɹ�");
		}else{
			mav.addObject("addSellBackHouseFlag", 0);//���ʧ�ܷ���0
			System.out.println("��������˻���ʧ��");
		}
		return mav;
	}
	//չʾ���������˻���
	@RequestMapping("/showSellBackHouseAll")
	public ModelAndView showSellBackHouseAll(){
		System.out.println("����showSellBackHouseAll������ ");
		
		//��ѯ�������۶������������ʱչʾ���۶����������˵�
		List<Sell> sellList = sellBiz.querySellAll();
		List<SellBackHouse> backHouseList = sellBackHouseBiz.querySellBackHouseAll();
		
		System.out.println("�����˻���������->"+backHouseList.size());
		ModelAndView mav = new ModelAndView("sell");
		mav.addObject("backHouseList", backHouseList);
		mav.addObject("sellList", sellList);
		return mav;
	}
	
	//ɾ�������˻���
	@RequestMapping("/deleteSellBackHouse")
	public ModelAndView deleteSellBackHouse(HttpServletRequest request){
		
		int deleteSellBackHouseId = Integer.valueOf(request.getParameter("deleteSellBackHouseId"));
		System.out.println("����deleteSellBackHouse������  ");
		int result = sellBackHouseBiz.deleteSellBackHouse(deleteSellBackHouseId);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("deleteSellBackHouseFlag", 1);//ɾ���ɹ�
			System.out.println("�����˻���ɾ���ɹ�");
		}else{
			mav.addObject("deleteSellBackHouseFlag", 0);//ɾ��ʧ��
			System.out.println("�����˻���ɾ��ʧ��");
		}
		return mav;
	}
	//�޸������˻���
	@RequestMapping("/editorSellBackHouse")
	public ModelAndView editorSellBackHouse(HttpServletRequest request){
		System.out.println("����editorSellBackHouse������  ");
	
		int editorSellBackHouseId = Integer.valueOf(request.getParameter("editorSellBackHouseId"));//���ⵥ���
		System.out.println(editorSellBackHouseId);
		int editorSellBackHouseCount = Integer.valueOf(request.getParameter("editorSellBackHouseCount"));//���۳�������
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
			mav.addObject("editorSellOutHouseFlag", 1);//�޸ĳɹ�
			System.out.println("�޸������˿ⵥ�ɹ�");
		}else{
			mav.addObject("editorSellOutHouseFlag", 0);//�޸�ʧ��
			System.out.println("�޸������˿ⵥʧ��");
		}
		return mav;
	}
	//ͨ�����۳���Id ������۳��ⵥ
	@RequestMapping("/querySellBackHouse")
	public ModelAndView querySellBackHouse(HttpServletRequest request){
		System.out.println("����querySellBackHouse������  ");
		
		int sellBackHouseId = Integer.valueOf(request.getParameter("sellBackHouseId"));//���ⵥ���
		SellBackHouse sellBackHouse = sellBackHouseBiz.querySellBackHouse(sellBackHouseId);
		ModelAndView mav = new ModelAndView("test");
		
		mav.addObject("sellBackHouse",sellBackHouse);
		return mav;
	}
}
