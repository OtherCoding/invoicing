package com.etc.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.etc.biz.SupplierBiz;
import com.etc.entity.Employees;
import com.etc.entity.Supplier;

@Controller
public class SupplierAction {
	@Autowired
	private SupplierBiz supplierBiz;
	
	//չʾ��Ӧ��
	@RequestMapping("/showSupplier")
	public ModelAndView showSupplier(){
		System.out.println("����SupplierListSell������  ");
		List<Supplier> supplierList = supplierBiz.querySupplierAll();
		
		System.out.println("���й�Ӧ��->"+supplierList.size());
		ModelAndView mav = new ModelAndView("basic");
		mav.addObject("supplierList", supplierList);
		return mav;
	}
	@RequestMapping("/addSupplier")
	public ModelAndView addSupplier(HttpServletRequest req) throws UnsupportedEncodingException{
		System.out.println("����addSupplier������ ");
		int addSupplierId=Integer.valueOf(req.getParameter("addSupplierId"));
		String addSupplierName=req.getParameter("addSupplierName");
		String addSupplierType=req.getParameter("addSupplierType");
		String addContacts=req.getParameter("addContacts");
		int addContactTel=Integer.valueOf(req.getParameter("addContactTel"));
		String addSupplierAddress=req.getParameter("addSupplierAddress");
		int addSupplierFax=Integer.valueOf(req.getParameter("addSupplierFax"));
		String addSupplierInfo=req.getParameter("addSupplierInfo");
		int addSupplierAssess=Integer.valueOf(req.getParameter("addSupplierAssess"));
		Supplier supplier=new Supplier(addSupplierId, addSupplierName, addSupplierType, addContacts, addContactTel, addSupplierAddress, addSupplierFax, addSupplierInfo, addSupplierAssess);
		int num=supplierBiz.AddSupplier(supplier);
		ModelAndView mav = new ModelAndView("basic");
		if(num!=0){
			mav.addObject("addSupplierflag",1);
			System.out.println("��ӹ����̳ɹ�");
		}else{
			mav.addObject("addSupplierflag",0);
			System.out.println("��ӹ�����ʧ��");
		}
		
		
		return mav;
		
	}
	@RequestMapping("/deleteSupplier")
	public ModelAndView deleteSupplier(HttpServletRequest req){
		System.out.println("����deleteSupplier������  ");
		int deleteSupplierid=Integer.valueOf(req.getParameter("deleteSupplierid"));
		Supplier supplier=new Supplier();
		supplier.setSupplierId(deleteSupplierid);
		ModelAndView mav = new ModelAndView("basic");
		int num=supplierBiz.DeleteSupplier(supplier);
		if(num!=0){
			mav.addObject("addSupplierflag",1);
			System.out.println("ɾ����Ӧ�̳ɹ�");
		}else{
			mav.addObject("addSupplierflag",0);
			System.out.println("ɾ����Ӧ��ʧ��");
		}
		return mav;
	}
	@RequestMapping("/editorSupplier")
	public ModelAndView editorSupplier(HttpServletRequest req) throws UnsupportedEncodingException{
		System.out.println("����editorSupplier������ ");
		int editorSupplierId=Integer.valueOf(req.getParameter("editorSupplierId"));
		String editorSupplierName=req.getParameter("editorSupplierName");
		String editorSupplierType=req.getParameter("editorSupplierType");
		String editorContacts=req.getParameter("editorContacts");
		int editorContactTel=Integer.valueOf( req.getParameter("editorContactTel"));
		String editorSupplierAddress=req.getParameter("editorSupplierAddress");
		int editorSupplierFax=Integer.valueOf(req.getParameter("editorSupplierFax"));
		String editorSupplierInfo=req.getParameter("editorSupplierInfo");
		int editorSupplierAssess=Integer.valueOf(req.getParameter("editorSupplierAssess"));		
		Supplier supplier=new Supplier(editorSupplierId, editorSupplierName, editorSupplierType, editorContacts, editorContactTel, editorSupplierAddress, editorSupplierFax, editorSupplierInfo, editorSupplierAssess);
		int num=supplierBiz.EditorSupplier(supplier);		
		ModelAndView mav = new ModelAndView("basic");
		if(num!=0){
			mav.addObject("addSupplierflag",1);
			System.out.println("�޸Ĺ�������Ϣ�ɹ�");
		}else{
			mav.addObject("addSupplierflag",0);
			System.out.println("�޸Ĺ�������Ϣʧ��");
		}
		
		
		return mav;
		
	}

	
	
}
