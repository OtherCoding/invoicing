package com.etc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etc.biz.GoodsBiz;
import com.etc.entity.Goods;
import com.etc.entity.GoodsType;
import com.etc.entity.Supplier;

@Controller
public class GoodsAction {
	@Autowired
	private GoodsBiz goodsBiz;

	@RequestMapping("/showGoods")
	public ModelAndView showGoods() {
		System.out.println("进入showGoods控制器");
		List<Goods> goodsList = goodsBiz.queryGoodsAll();
		System.out.println("共有商品——》" + goodsList.size() + "件");
		ModelAndView mav = new ModelAndView("basic");
		mav.addObject("goodsList", goodsList);
		return mav;

	}

	@RequestMapping("/AddGoods")
	public ModelAndView AddGoods(HttpServletRequest req) {
		System.out.println("进入AddGoods控制器");
		int addGoodsId = Integer.valueOf(req.getParameter("addGoodsId"));
		String addGoodsType = req.getParameter("addGoodsType");
		String addGoodsName = req.getParameter("addGoodsName");
		String addBrand = req.getParameter("addBrand");
		String addProductModel = req.getParameter("addProductModel");
		int addCostPrice = Integer.valueOf(req.getParameter("addCostPrice"));
		int addRetailPrice = Integer.valueOf(req.getParameter("addRetailPrice"));
		int addGoodsCode = Integer.valueOf(req.getParameter("addGoodsCode"));
		int addBarCode = Integer.valueOf(req.getParameter("addBarCode"));
		int addSupplierId = Integer.valueOf(req.getParameter("addSupplierId"));
		GoodsType goodsType = new GoodsType();
		goodsType.setGoodsType(addGoodsType);
		Supplier supplier = new Supplier();
		supplier.setSupplierId(addSupplierId);
		Goods goods = new Goods(addGoodsId, goodsType, addGoodsName, addBrand, addProductModel, addCostPrice,
				addRetailPrice, addGoodsCode, addBarCode, supplier);
		int num = goodsBiz.AddGoods(goods);
		ModelAndView mav = new ModelAndView("basic");
		if (num != 0) {
			mav.addObject("addGoodsflag", 1);
			System.out.println("添加商品成功");
		} else {
			mav.addObject("addGoodsflag", 0);
			System.out.println("添加商品失败");
		}

		return mav;
	}

	@RequestMapping("/deleteGoods")
	public ModelAndView deleteGoods(HttpServletRequest req) {
		System.out.println("进入deleteGoods控制器  ");
		int deletegoodsId = Integer.valueOf(req.getParameter("deletegoodsId"));
		Goods goods = new Goods();
		goods.setGoodsId(deletegoodsId);
		ModelAndView mav = new ModelAndView("basic");
		int num = goodsBiz.DeleteGoods(goods);
		if (num != 0) {
			mav.addObject("addGoodsflag", 1);
			System.out.println("删除商品成功");
		} else {
			mav.addObject("addGoodsflag", 0);
			System.out.println("删除商品失败");
		}
		return mav;
	}

	@RequestMapping("/editorGoods")
	public ModelAndView editorGoods(HttpServletRequest req) {
		System.out.println("进入editorGoods控制器");
		int editorGoodsId = Integer.valueOf(req.getParameter("editorGoodsId"));
		String editorGoodsType = req.getParameter("editorGoodsType");
		String editorGoodsName = req.getParameter("editorGoodsName");
		String editorBrand = req.getParameter("editorGoodsName");
		String editorProductModel = req.getParameter("editorProductModel");
		int editorCostPrice = Integer.valueOf(req.getParameter("editorCostPrice"));
		int editorRetailPrice = Integer.valueOf(req.getParameter("editorRetailPrice"));
		int editorGoodsCode = Integer.valueOf(req.getParameter("editorGoodsCode"));
		int editorBarCode = Integer.valueOf(req.getParameter("editorBarCode"));
		int editorSupplierId = Integer.valueOf(req.getParameter("editorSupplier"));
		GoodsType goodsType = new GoodsType();
		goodsType.setGoodsType(editorGoodsType);
		Supplier supplier = new Supplier();
		supplier.setSupplierId(editorSupplierId);
		Goods goods = new Goods(editorGoodsId, goodsType, editorGoodsName, editorBrand, editorProductModel,
				editorCostPrice, editorRetailPrice, editorGoodsCode, editorBarCode, supplier);
		ModelAndView mav = new ModelAndView("basic");
		int num = goodsBiz.EditorGoods(goods);
		if (num != 0) {
			mav.addObject("editorGoodsflag", 1);
			System.out.println("删除商品成功");
		} else {
			mav.addObject("editorGoodsflag", 0);
			System.out.println("删除商品失败");
		}
		return mav;

	}

}
