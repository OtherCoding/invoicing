package com.etc.dao;

import java.util.List;

import com.etc.entity.GetMoney;

public interface GetMoneyDao {

	List<GetMoney> queryGetMoneyAll();

	int deleteGetMoney(int deleteGetMoneyId);

	int editorGetMoney(GetMoney getMoney);

	int addGetMoney(GetMoney getMoney);

}
