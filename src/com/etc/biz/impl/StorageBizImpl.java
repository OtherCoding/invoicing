package com.etc.biz.impl;

import java.util.List;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.etc.biz.StorageBiz;
import com.etc.dao.StorageDao;
import com.etc.entity.Goods;
import com.etc.entity.SellBackHouse;
import com.etc.entity.SellOutHouse;
import com.etc.entity.StockInOrder;
import com.etc.entity.StorageInfo;



@Service
@Aspect
public class StorageBizImpl implements StorageBiz {
	
	@Autowired
	private StorageDao storageDao;
	
	
	
	@Override
	public List<StorageInfo> queryStorageInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return storageDao.queryStorageInfo(map);
	}


	@Override
	public List<StorageInfo> queryStorageOutInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return storageDao.queryStorageOutInfo(map);
	}


	@Override
	public Integer addStorageIn(StorageInfo storageInfo) {
		
		
		return storageDao.addStorageIn(storageInfo);
	}
	
	
	
	@Around(value="execution(* com.etc.biz.impl.*.*(*))")
	public Object addStorage(ProceedingJoinPoint pjp) {
		Object ob=null;
		//接收方法的参数
		Object object=null;
		try {
			
			ob=pjp.proceed();
			if("AddStockInOrder".equals(pjp.getSignature().getName())){
				object = pjp.getArgs()[0];
				addBuyIn(object);
			}else if("addSellOutHouse".equals(pjp.getSignature().getName())){
				object = pjp.getArgs()[0];
				addSellOut(object);
			}else if("addSellBackHouse".equals(pjp.getSignature().getName())){
				object = pjp.getArgs()[0];
				addBuyIn(object);
			}
			
		} catch (Throwable e) {
			System.out.println("异常通知");
			e.printStackTrace();
		}
		return ob;
	}
	/**
	 * 添加采购入库和退货入库
	 * @param object
	 */
	private void addBuyIn(Object object){
		StorageInfo storageInfo=new StorageInfo();
		
		if(object instanceof StockInOrder){
			StockInOrder stockInOrder = (StockInOrder) object;
			Goods goods=stockInOrder.getStockOrder().getGoods();
			storageInfo.setInStorTime(stockInOrder.getStoArriveTime());
			storageInfo.setInStorCount(stockInOrder.getStoArriveNum());
			storageInfo.setStorageType("采购入库");
			storageInfo.setGoods(goods);
			//查询入库单是否有此商品
			int num = this.queryGoods(goods.getGoodsId());
			if(num==0){
				this.addStorageIn(storageInfo);
				storageInfo.setStorageGoodCount(stockInOrder.getStoArriveNum());
				this.addStorageInFirst(storageInfo);
			}else{
				this.addStorageIn(storageInfo);
				storageInfo.setStorageGoodCount(stockInOrder.getStoArriveNum()+this.queryStorageGoodCount(goods.getGoodsId()));
				this.updateStorageCount(storageInfo);
			}
		}else if(object instanceof SellBackHouse){
			SellBackHouse sellBackHouse=(SellBackHouse) object;
			Goods goods=sellBackHouse.getSell().getGoods();
			storageInfo.setGoods(goods);
			storageInfo.setInStorCount(sellBackHouse.getCounts());
			storageInfo.setInStorTime(sellBackHouse.getBackGoodsTime());
			storageInfo.setStorageType("销售退货入库");
			this.addStorageIn(storageInfo);
			storageInfo.setStorageGoodCount(sellBackHouse.getCounts()+this.queryStorageGoodCount(goods.getGoodsId()));
			this.updateStorageCount(storageInfo);
		}
		
		
		
		
		
	}
	/**
	 * 添加销售出库
	 * @param object
	 */
	private void addSellOut(Object object){
		//添加出库单
		SellOutHouse sellOutHouse = (SellOutHouse) object;
		Goods goods=sellOutHouse.getSell().getGoods();
		StorageInfo storageInfo=new StorageInfo();
		
		storageInfo.setGoods(goods);
		storageInfo.setOutStorCount(sellOutHouse.getCounts());
		storageInfo.setOutStorTime(sellOutHouse.getSellDate());
		storageInfo.setStorageType("销售出库");
		
		this.addStorageOut(storageInfo);
		//将对应商品的库存数量减去出库的数量
		storageInfo.setStorageGoodCount(this.queryStorageGoodCount(goods.getGoodsId())-sellOutHouse.getCounts());
		//数据库进行更新
		this.updateStorageCount(storageInfo);
	}
	
	
	//添加出库单
	@Override
	public Integer addStorageOut(StorageInfo storageInfo) {
		return storageDao.addStorageOut(storageInfo);
	}

	/**
	 * 查询商品是否存在
	 * @param goodsid
	 * @return 0为不存在
	 */
	@Override
	public Integer queryGoods(int goodsid) {
		return storageDao.queryGoods(goodsid);
	}


	@Override
	public Integer addStorageInFirst(StorageInfo storageInfo) {
		return storageDao.addStorageInFirst(storageInfo);
	}


	/**
	 * 查看对应商品的库存数量
	 * @param goodsId
	 * @return
	 */
	@Override
	public Integer queryStorageGoodCount(int goodsId) {
		return storageDao.queryStorageGoodCount(goodsId);
	}

	/**
	 * 修改对应商品的库存数
	 * @param storageInfo
	 * @return
	 */
	@Override
	public Integer updateStorageCount(StorageInfo storageInfo) {
		return storageDao.updateStorageCount(storageInfo);
	}

	
	
}
