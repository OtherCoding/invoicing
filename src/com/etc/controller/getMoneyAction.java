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
 * �����տController
 * @author Administrator
 *
 */
@Controller
public class getMoneyAction {
	
	@Autowired
	private GetMoneyBiz getMoneyBiz;
	@Autowired
	private SellBiz sellBiz;
	
	//��������տ
	@RequestMapping("/addGetMoney")
	public ModelAndView addGetMoney(HttpServletRequest request){
		System.out.println("����addGetMoney������  ");
		//��ȡֵ
		int addGetMoneySellId = Integer.valueOf(request.getParameter("addGetMoneySellId"));
		double addGetMoneyShouldGetMoney = Double.valueOf(request.getParameter("addGetMoneyShouldGetMoney"));
		double addGetMoneyGetMoney = Double.valueOf(request.getParameter("addGetMoneyGetMoney"));
		
		GetMoney getMoney = new GetMoney(0, new Sell(addGetMoneySellId, null, 0, 0, null), addGetMoneyShouldGetMoney, addGetMoneyGetMoney);
		
		
		int result = getMoneyBiz.addGetMoney(getMoney);
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("addSellBackHouseFlag", 1);//��ӳɹ�����1
			System.out.println("��������տ�ɹ�");
		}else{
			mav.addObject("addSellBackHouseFlag", 0);//���ʧ�ܷ���0
			System.out.println("��������տʧ��");
		}
		return mav;
	}
	
	//չʾ���������տ
	@RequestMapping("/showGetMoney")
	public ModelAndView showGetMoney(){
		System.out.println("����showGetMoney������  ");
		
		//��ѯ�������۶������������ʱչʾ���۶����������˵�
		List<Sell> sellList = sellBiz.querySellAll();
		
		List<GetMoney> getMoneyList = getMoneyBiz.queryGetMoneyAll();
		System.out.println("�տ������->"+getMoneyList.size());
		ModelAndView mav = new ModelAndView("sell");
		mav.addObject("getMoneyList", getMoneyList);
		mav.addObject("sellList", sellList);
		return mav;
	}
	
	//ɾ�������տ
	@RequestMapping("/deleteGetMoney")
	public ModelAndView deleteGetMoney(HttpServletRequest request){
		
		int deleteGetMoneyId = Integer.valueOf(request.getParameter("deleteGetMoneyId"));
		System.out.println("����deleteGetMoney������  ");
		int result = getMoneyBiz.deleteGetMoney(deleteGetMoneyId);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("deleteGetMoneyFlag", 1);//ɾ���ɹ�
			System.out.println("�տɾ���ɹ�");
		}else{
			mav.addObject("deleteGetMoneyFlag", 0);//ɾ��ʧ��
			System.out.println("�տɾ��ʧ��");
		}
		return mav;
	}
	
	//�޸������տ
	@RequestMapping("/editorGetMoney")
	public ModelAndView editorGetMoney(HttpServletRequest request){
		System.out.println("����editorGetMoney������  ");
	
		int editorSellGetMoneySheetId = Integer.valueOf(request.getParameter("editorSellGetMoneySheetId"));//�����տ���
		System.out.println(editorSellGetMoneySheetId);
		int editorSellShouldGetMoney= Integer.valueOf(request.getParameter("editorSellShouldGetMoney"));//Ӧ�տ�
		System.out.println(editorSellShouldGetMoney);
		int editorSellGetMoney = Integer.valueOf(request.getParameter("editorSellGetMoney"));//ʵ�տ�
		System.out.println(editorSellGetMoney);
		
		GetMoney getMoney = new GetMoney(editorSellGetMoneySheetId, null, editorSellShouldGetMoney, editorSellGetMoney);
		int result = 0;
		result = getMoneyBiz.editorGetMoney(getMoney);
		
		ModelAndView mav = new ModelAndView("sell");
		if(result!=0){
			mav.addObject("editorGetMoneyFlag", 1);//�޸ĳɹ�
			System.out.println("�޸������տ�ɹ�");
		}else{
			mav.addObject("editorGetMoneyFlag", 0);//�޸�ʧ��
			System.out.println("�޸������տʧ��");
		}
		return mav;
	}
}
