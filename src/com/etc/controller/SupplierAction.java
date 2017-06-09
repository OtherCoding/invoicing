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
	
	//展示供应商
	@RequestMapping("/showSupplier")
	public ModelAndView showSupplier(){
		System.out.println("进入SupplierListSell控制器  ");
		List<Supplier> supplierList = supplierBiz.querySupplierAll();
		
		System.out.println("共有供应商->"+supplierList.size());
		ModelAndView mav = new ModelAndView("basic");
		mav.addObject("supplierList", supplierList);
		return mav;
	}
	@RequestMapping("/addSupplier")
	public ModelAndView addSupplier(HttpServletRequest req) throws UnsupportedEncodingException{
		System.out.println("进入addSupplier控制器 ");
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
			System.out.println("添加供货商成功");
		}else{
			mav.addObject("addSupplierflag",0);
			System.out.println("添加供货商失败");
		}
		
		
		return mav;
		
	}
	@RequestMapping("/deleteSupplier")
	public ModelAndView deleteSupplier(HttpServletRequest req){
		System.out.println("进入deleteSupplier控制器  ");
		int deleteSupplierid=Integer.valueOf(req.getParameter("deleteSupplierid"));
		Supplier supplier=new Supplier();
		supplier.setSupplierId(deleteSupplierid);
		ModelAndView mav = new ModelAndView("basic");
		int num=supplierBiz.DeleteSupplier(supplier);
		if(num!=0){
			mav.addObject("addSupplierflag",1);
			System.out.println("删除供应商成功");
		}else{
			mav.addObject("addSupplierflag",0);
			System.out.println("删除供应商失败");
		}
		return mav;
	}
	@RequestMapping("/editorSupplier")
	public ModelAndView editorSupplier(HttpServletRequest req) throws UnsupportedEncodingException{
		System.out.println("进入editorSupplier控制器 ");
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
			System.out.println("修改供货商信息成功");
		}else{
			mav.addObject("addSupplierflag",0);
			System.out.println("修改供货商信息失败");
		}
		
		
		return mav;
		
	}

	
	
}
