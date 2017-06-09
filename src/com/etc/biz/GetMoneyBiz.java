package com.etc.biz;

import java.util.List;

import com.etc.entity.GetMoney;


/**
 * 销售收款单业务层
 * @author Administrator
 *
 */
public interface GetMoneyBiz {

	List<GetMoney> queryGetMoneyAll();

	int deleteGetMoney(int deleteGetMoneyId);

	int editorGetMoney(GetMoney getMoney);

	int addGetMoney(GetMoney getMoney);

}
