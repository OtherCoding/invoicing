package com.etc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.etc.biz.GoodsBiz;
import com.etc.biz.StorageBiz;
import com.etc.entity.Goods;
import com.etc.entity.StorageInfo;

@Controller
public class StorageAction {
	
	@Autowired
	private StorageBiz storageBiz;
	@Autowired
	private GoodsBiz goodsBiz;
	
	@RequestMapping("/queryin")
	public ModelAndView queryIn(@RequestParam(value="goodsid",required=false) String goodsid,@RequestParam(value="storageType",required=false) String storageType,@RequestParam(value="beginTime",required=false) String beginTime,@RequestParam(value="endTime",required=false) String endTime){
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("goodsid",goodsid);
		map.put("storageType", storageType);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		
		List<StorageInfo> storageInfoList=storageBiz.queryStorageInfo(map);
		ModelAndView mav = new ModelAndView("storagein");
		mav.addObject("storageInfoList", storageInfoList);
		return mav;
	}
	
	@RequestMapping("/queryout")
	public ModelAndView queryOut(@RequestParam(value="goodsid",required=false) String goodsid,@RequestParam(value="storageType",required=false) String storageType,@RequestParam(value="beginTime",required=false) String beginTime,@RequestParam(value="endTime",required=false) String endTime){
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("goodsid",goodsid);
		map.put("storageType", storageType);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		
		List<StorageInfo> storageInfoList=storageBiz.queryStorageOutInfo(map);
		ModelAndView mav = new ModelAndView("storageout");
		mav.addObject("storageInfoList", storageInfoList);
		return mav;
	}
	@RequestMapping("loadGoods")
	public ModelAndView loadGoods(){
		List<Goods> goods = goodsBiz.queryGoodsAll();
		ModelAndView mav=new ModelAndView("storagein");
		mav.addObject("goodsList", goods);
		
		
		return mav;
		
	}
	@RequestMapping("loadGoodsOut")
	public ModelAndView loadGoodsOut(){
		List<Goods> goods = goodsBiz.queryGoodsAll();
		ModelAndView mav=new ModelAndView("storageout");
		mav.addObject("goodsList", goods);
		return mav;
		
	}

}
