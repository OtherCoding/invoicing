<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入库管理</title>
  	<link href="css/H-ui.min.css" type="text/css" rel="stylesheet"/>
	<script src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	<script src="js/H-ui.min.js"></script>
	<script type="text/javascript">
		
	
	</script>
</head>
<body >
	<h2>入库管理</h2>
	<form action="queryin" method="post">
		
		
		<select  name="goodsid">
			<option value="">请选择查看的商品</option>
			<c:if test="${empty goodsList }">
				<jsp:forward page="loadGoods"></jsp:forward>
			</c:if>
			<c:forEach items="${goodsList }" var="goods">
				<option value="${goods.goodsId }">${goods.goodsName }</option>
			</c:forEach>
		</select>
		
		<input type="radio"  name="storageType" value="采购入库" id="buyin"/><label for="buyin">采购入库</label>
		<input type="radio" name="storageType" value="销售退货入库" id="sellbackin"/><label for="sellbackin">销售退货入库</label>
		<input type="text" style="width: 120px" class="Wdate input-text" name="beginTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>开始时间
		<input type="text" style="width: 120px" class="Wdate input-text " name="endTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>结束时间
		<input type="submit" class="btn btn-primary size-M radius" value="查询"/>
	</form>
	
	
	<table class="table table-border table-bordered table-striped">
		<tr class="text-c">
			<th>序号</th>
			<th>商品</th>
			<th>品牌</th>
			<th>型号</th>
			<th>供应商</th>
			<th>类型</th>
			<th>入库数量</th>
			<th>入库日期</th>
		</tr>
		<c:if test="${!empty storageInfoList }">
			<c:forEach items="${storageInfoList }" var="storage" varStatus="sto">
			<tr>
				<td>${sto.count }</td>
				<td>${storage.goods.goodsName }</td>
				<td>${storage.goods.brand}</td>
				<td>${storage.goods.productModel }</td>
				<td>${storage.goods.supplier.supplierName }</td>
				<td>${storage.storageType }</td>
				<td>${storage.inStorCount}</td>
				<td>${storage.inStorTime }</td>
			</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>