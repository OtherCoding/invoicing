package com.etc.biz;

import java.util.List;

import com.etc.entity.GetMoney;


/**
 * �����տҵ���
 * @author Administrator
 *
 */
public interface GetMoneyBiz {

	List<GetMoney> queryGetMoneyAll();

	int deleteGetMoney(int deleteGetMoneyId);

	int editorGetMoney(GetMoney getMoney);

	int addGetMoney(GetMoney getMoney);

}
