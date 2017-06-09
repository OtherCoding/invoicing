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
		//���շ����Ĳ���
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
			System.out.println("�쳣֪ͨ");
			e.printStackTrace();
		}
		return ob;
	}
	/**
	 * ��Ӳɹ������˻����
	 * @param object
	 */
	private void addBuyIn(Object object){
		StorageInfo storageInfo=new StorageInfo();
		
		if(object instanceof StockInOrder){
			StockInOrder stockInOrder = (StockInOrder) object;
			Goods goods=stockInOrder.getStockOrder().getGoods();
			storageInfo.setInStorTime(stockInOrder.getStoArriveTime());
			storageInfo.setInStorCount(stockInOrder.getStoArriveNum());
			storageInfo.setStorageType("�ɹ����");
			storageInfo.setGoods(goods);
			//��ѯ��ⵥ�Ƿ��д���Ʒ
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
			storageInfo.setStorageType("�����˻����");
			this.addStorageIn(storageInfo);
			storageInfo.setStorageGoodCount(sellBackHouse.getCounts()+this.queryStorageGoodCount(goods.getGoodsId()));
			this.updateStorageCount(storageInfo);
		}
		
		
		
		
		
	}
	/**
	 * ������۳���
	 * @param object
	 */
	private void addSellOut(Object object){
		//��ӳ��ⵥ
		SellOutHouse sellOutHouse = (SellOutHouse) object;
		Goods goods=sellOutHouse.getSell().getGoods();
		StorageInfo storageInfo=new StorageInfo();
		
		storageInfo.setGoods(goods);
		storageInfo.setOutStorCount(sellOutHouse.getCounts());
		storageInfo.setOutStorTime(sellOutHouse.getSellDate());
		storageInfo.setStorageType("���۳���");
		
		this.addStorageOut(storageInfo);
		//����Ӧ��Ʒ�Ŀ��������ȥ���������
		storageInfo.setStorageGoodCount(this.queryStorageGoodCount(goods.getGoodsId())-sellOutHouse.getCounts());
		//���ݿ���и���
		this.updateStorageCount(storageInfo);
	}
	
	
	//��ӳ��ⵥ
	@Override
	public Integer addStorageOut(StorageInfo storageInfo) {
		return storageDao.addStorageOut(storageInfo);
	}

	/**
	 * ��ѯ��Ʒ�Ƿ����
	 * @param goodsid
	 * @return 0Ϊ������
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
	 * �鿴��Ӧ��Ʒ�Ŀ������
	 * @param goodsId
	 * @return
	 */
	@Override
	public Integer queryStorageGoodCount(int goodsId) {
		return storageDao.queryStorageGoodCount(goodsId);
	}

	/**
	 * �޸Ķ�Ӧ��Ʒ�Ŀ����
	 * @param storageInfo
	 * @return
	 */
	@Override
	public Integer updateStorageCount(StorageInfo storageInfo) {
		return storageDao.updateStorageCount(storageInfo);
	}

	
	
}
