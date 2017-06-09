<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<!--[if lt IE 9]>
		<script type="text/javascript" src="Lib/html5shi.js"></script>
		<![endif]-->

<link href="css/H-ui.min.css" type="text/css" rel="stylesheet" />
<link href="css/index.css" type="text/css" rel="stylesheet" />
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/html5shiv.js"></script>
<script src="js/H-ui.min.js"></script>
<script src="js/index.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<style type="text/css">
	.div-application {
		width: 1000px;
		
		margin: 0 auto;
		margin-bottom: 20px;
	}
	
	.div-title { /*功能名样式*/
		border-bottom: #ccc solid 1px;
		width: 900px;
		height: 50px;
		margin: 0 auto;
		cursor: pointer;
		line-height: 50px;
		color: #ccc;
		font-weight: 700;
		font-size: 24px;
		text-align: center;
		margin-bottom: 20px;
	}
	
	.div-table { /*表格的框*/
		width: 900px;
		
		margin: 0 auto;
	}
</style>
<script type="text/javascript">
	//采购订单编辑栏
	$(function() {
		$("#editorform-div").hide();
		$(".alter").each(function(index) {
		$(this).on('click',function(event) {
			event.stopPropagation();
			$("#editorform-div").show();
			$(" .aaa  .bbb").each(function() {
				var $index = $(this).index();
				$(this).find(".input-text").val($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq($index).text());
				$(this).find(".input-hidden").val($(".alter").eq(index).parents(".alterTr").find('.alterInput').val());
			});
		});

	});

});

	$(function() {
		$(".cancel").click(function() {
			$("#editorform-div").hide();
		});
	});

	//采购入库单编辑栏
	$(function() {
		$("#editorform-div1").hide();
		$(".alter1").each(function(index) {
		$(this).on('click',function(event) {
			event.stopPropagation();
			$("#editorform-div1").show();
			$(" .aaa1  .bbb1").each(function() {
				var $index = $(this).index();
				$(this).find(".input-text1").val($(".alter1").eq(index).parents(".alterTr1").find('.alterTd1').eq($index).text());
				$(this).find(".input-hidden1").val($(".alter1").eq(index).parents(".alterTr1").find('.alterInput1').val());
			});
		});

	});

});

	$(function() {
		$(".cancel1").click(function() {
			$("#editorform-div1").hide();
		});
	});
	
	//退货订单编辑栏
	$(function() {
		$("#editorform-div2").hide();
		$(".alter2").each(function(index) {
		$(this).on('click',function(event) {
			event.stopPropagation();
			$("#editorform-div2").show();
			$(" .aaa2  .bbb2").each(function() {
				var $index = $(this).index();
				$(this).find(".input-text2").val($(".alter2").eq(index).parents(".alterTr2").find('.alterTd2').eq($index).text());
				$(this).find(".input-hidden2").val($(".alter2").eq(index).parents(".alterTr2").find('.alterInput2').val());
			});
		});

	});

});

	$(function() {
		$(".cancel2").click(function() {
			$("#editorform-div2").hide();
		});
	});
	
	

</script>

<body>
	<div id="tab_demo" class="HuiTab">
		<!--导航条信息-->
		<div class="tabBar clearfix">
			<a href="showEmployees"><span>基础信息</span></a>
			<a href="showCompany"><span>系统管理</span></a>
			<span class="current">采购管理</span> 
			<a href="showSell"><span>销售管理</span></a>
			<a href="storage.jsp"><span>库存管理</span></a>
		</div>

		<!--采购管理侧边栏 -->
		<div class="tabCon fl" id="col3" style="display:block">
			<ul id="Huifold1" class="Huifold">
				<li class="item">
					<h4><a href="stockOrderShow">采购订单</a></h4>
				</li>
				<li class="item">
					<h4><a href="stockInOrderShow">采购入库</a></h4>
				</li>
				<li class="item">
					<h4><a href="stockReturnOrderShow">采购退货</a></h4>
				</li>
			</ul>
		</div>
		
		<!-- *********************************************采购订单************************************************** -->
		<div class="right fl">
			<div class="div-application">
				<div class="div-title">添加采购订单</div>
				<div class="div-table">
					<form action="stockOrderAdd">
						<table class="table table-border table-bordered table-hover">

							<tr class="text-c">
								<td class="text-r">商品名：</td>
								<td><select class="select" size="1" id="goodsId"
									name="goodsId">
										<c:forEach items="${goodsList}" var="goods" varStatus="status">
											<option value="${goods.goodsId }">${goods.goodsName }</option>
										</c:forEach>
								</select></td>
								<td class="text-r">员工：</td>
								<td><select class="select" size="1" id="empNo" name="empNo">
										<c:forEach items="${employeesList}" var="employees"
											varStatus="status">
											<option value="${employees.empNo }">${employees.empName }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr class="text-c">
								<td class="text-r">商品数量：</td>
								<td colspan="3">
									<input type="text" id="stoNum" name="stoNum" class="input-text" />
								</td>
							</tr>
							<tr>
								<td class="text-r" colspan="4">
									<input class="btn btn-primary radius" type="submit" value="提交">
								</td>
							</tr>

						</table>
					</form>
				</div>

				<div class="div-title">采购订单信息</div>
				<div class="div-table">
					<table class="table table-border table-bordered table-hover">
						<tr class="text-c">
							<td>采购订单编号</td>
							<td>商品名</td>
							<td>采购人员</td>
							<td>采购数量</td>
							<td></td>
						</tr>
						<c:forEach items="${stockOrderList}" var="stockOrder"
							varStatus="status">
							<tr class="text-c alterTr">
								<td class="text-d alterTd">${stockOrder.stoId }</td>
								<td class="text-d alterTd">${stockOrder.goods.goodsName }</td>
								<td class="text-d alterTd">${stockOrder.emp.empName }</td>
								<td class="text-d alterTd">${stockOrder.stoNum}</td>
								<td>
									<!-- 思路：点击编辑按钮，对应行实现可编辑，编辑按钮隐藏，应用按钮从隐藏到高亮，输入要编辑的内容后，点击应用与后台交互，实时刷新 -->
									<a class="btn btn-primary radius alter" name="update">编辑</a> <a
									class="btn btn-primary radius"
									href="stockOrderDel?stoId=${stockOrder.stoId }">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- ***************************************采购订单-编辑栏 start*************************************** -->
				<form action="stockOrderUpdate" method="post">
					<table id="editorform-div"
						class="table table-border table-bordered table-hover">
						<tr class="text-c">
							<td></td>
							<td>商品名</td>
							<td>采购人员</td>
							<td>采购数量</td>
							<td></td>
						</tr>
						<tr class="text-c aaa">
							<td class="text-d bbb"><input type="hidden"
								class="input-text" id="stoId" name="stoId"></td>
							<td class="text-d bbb"><input type="text" class="input-text"
								id="goodsId" name="goodsId" disabled></td>
							<td class="text-d bbb"><input type="text" class="input-text"
								id="empNo" name="empNo" disabled></td>
							<td class="text-d bbb"><input type="text" class="input-text"
								id="stoNum" name="stoNum"></td>
							<td>
								<!-- 思路：点击编辑按钮，对应行实现可编辑，编辑按钮隐藏，应用按钮从隐藏到高亮，输入要编辑的内容后，点击应用与后台交互，实时刷新 -->
								<input class="btn btn-primary radius" type="submit" value="提交">
								<a class="btn btn-primary radius cancel">取消</a>
							</td>
						</tr>

					</table>
				</form>
				<!-- ***************************************采购订单-编辑栏 end*************************************** -->
			</div>
		</div>
		<!--**************************************************采购入库********************************************* -->
		<div class="right fl">
			<div class="div-application">
				<div class="div-title">添加采购入库订单</div>
				<div class="div-table">
					<form action="stockInOrderAdd">
						<table class="table table-border table-bordered table-hover">
							<tr class="text-c">
								<td class="text-r">采购订单：</td>
								<td>
									<select class="select" size="1" id="stoId" name="stoId">
										<c:forEach items="${stockOrderList}" var="stockOrder"
											varStatus="status">
											<option value="${stockOrder.stoId }">订单编号：${stockOrder.stoId }/商品名称：${stockOrder.goods.goodsName }</option>
										</c:forEach>
									</select>
								</td>
								<td class="text-r">日期：</td>
								<td>
									<input type="text" class="input-text" name="stoArriveTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
								</td>
							</tr>
							<tr>
								<td class="text-r">入库数量：</td>
								<td><input type="text" id="stoArriveNum"
									name="stoArriveNum" class="input-text" /></td>
								<td></td>
								<td class="text-r"><input class="btn btn-primary radius"
									type="submit" value="提交"></td>
							</tr>

						</table>
					</form>
				</div>

				<div class="div-title">采购入库订单信息</div>
				<div class="div-table">
					<table class="table table-border table-bordered table-hover">
						<tr class="text-c">
							<td>采购入库表编号</td>
							<td>员工</td>
							<td>商品名称</td>
							<td>采购订单编号</td>
							<td>入库日期</td>
							<td>入库数量</td>
							<td></td>

							<c:forEach items="${stockInOrderList}" var="stockInOrder"
								varStatus="status">
								<tr class="text-c alterTr1">
									<td class="text-d alterTd1">${stockInOrder.stoArriveId }</td>
									<td class="text-d alterTd1">${stockInOrder.emp.empName }</td>
									<td class="text-d alterTd1">${stockInOrder.stockOrder.goods.goodsName }</td>
									<td class="text-d alterTd1">${stockInOrder.stockOrder.stoId}</td>
									<td class="text-d alterTd1">${stockInOrder.stoArriveTime }</td>
									<td class="text-d alterTd1">${stockInOrder.stoArriveNum }</td>
									<td><a class="btn btn-primary radius alter1" name="update">编辑</a>
										<a class="btn btn-primary radius"
										href="stockInOrderDel?stoArriveId=${stockInOrder.stoArriveId}">删除</a></td>
								</tr>
							</c:forEach>
					</table>
				</div>
				<!-- ***************************************采购入库-编辑栏 start*************************************** -->
				<form action="stockInOrderUpdate" method="post">
					<table id="editorform-div1"
						class="table table-border table-bordered table-hover">
						<tr class="text-c">
							<td></td>
							<td>员工</td>
							<td>供应商</td>
							<td>采购订单编号</td>
							<td>采购日期</td>
							<td>入库数量</td>
							<td></td>
						</tr>
						<tr class="text-c aaa1">
							<td class="text-d bbb1"><input type="hidden"class="input-text1 input-text" id="stoArriveId" name="stoArriveId"></td>
							<td class="text-d bbb1"><input type="text" class="input-text1 input-text"id="empNo" name="empNo" disabled></td>
							<td class="text-d bbb1"><input type="text" class="input-text1 input-text"id="supplierId" name="supplierId" disabled></td>
							<td class="text-d bbb1"><input type="text" class="input-text1 input-text"id="stoId" name="stoId" disabled></td>
							<td class="text-d bbb1"><input type="text" class="input-text1 input-text"id="stoArriveTime" name="stoArriveTime" disabled></td>
							<td class="text-d bbb1"><input type="text" class="input-text1 input-text"id="stoArriveNum" name="stoArriveNum"></td>
							<td>
								<!-- 思路：点击编辑按钮，对应行实现可编辑，编辑按钮隐藏，应用按钮从隐藏到高亮，输入要编辑的内容后，点击应用与后台交互，实时刷新 -->
								<input class="btn btn-primary radius" type="submit" value="提交">
								<a class="btn btn-primary radius cancel1">取消</a>
							</td>
						</tr>

					</table>
				</form>
				<!-- ***************************************采购入库-编辑栏 end*************************************** -->


			</div>
		</div>
		<!-- ***********************************************采购退货**************************************************** -->
		<div class="right fl">
			<div class="div-application">
				<div class="div-title">添加采购退货订单</div>
				<div class="div-table">
					<form action="stockReturnOrderAdd">
						<table class="table table-border table-bordered table-hover">

							<tr class="text-c">
								<td class="text-r">退货商品：</td>
								<td><select class="select" size="1" id="goodsId"
									name="goodsId">
										<c:forEach items="${goodsList}" var="goods" varStatus="status">
											<option value="${goods.goodsId }">${goods.goodsName }</option>
										</c:forEach>
								</select></td>
								<td class="text-r">采购人员：</td>
								<td><select class="select" size="1" id="empNo" name="empNo">
										<c:forEach items="${employeesList}" var="employees"
											varStatus="status">
											<option value="${employees.empNo }">${employees.empName }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr class="text-c">
								<td class="text-r">日期：</td>
								<td>
									<input type="text" class="input-text" name="stoReturnTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
								</td>
								<td class="text-r">退货数量：</td>
								<td><input type="text" id="stoReturnNum"
									name="stoReturnNum" class="input-text" /></td>
							</tr>
							<tr>
								<td class="text-r"></td>
								<td></td>
								<td></td>
								<td class="text-r"><input class="btn btn-primary radius"
									type="submit" value="提交"></td>
							</tr>
						</table>
					</form>
				</div>

				<div class="div-title">采购退货订单信息</div>
				<div class="div-table">
					<table class="table table-border table-bordered table-hover">
						<tr class="text-c">
							<td>采购退货单编号</td>
							<td>商品</td>
							<td>员工</td>
							<td>采购退货日期</td>
							<td>退货数量</td>
							<td></td>

							<c:forEach items="${stockReturnOrderList}" var="stockReturnOrder"
								varStatus="status">
								<tr class="text-c alterTr2">
									<td class="text-d alterTd2">${stockReturnOrder.stoReturnId }</td>
									<td class="text-d alterTd2">${stockReturnOrder.goods.goodsName }</td>
									<td class="text-d alterTd2">${stockReturnOrder.emp.empName }</td>
									<td class="text-d alterTd2">${stockReturnOrder.stoReturnTime}</td>
									<td class="text-d alterTd2">${stockReturnOrder.stoReturnNum }</td>
									<td><input class="btn btn-primary radius alter2" type="button"
										value="编辑"> <a class="btn btn-primary radius"
										href="stockReturnOrderDel?stoReturnId=${stockReturnOrder.stoReturnId}">删除</a></td>
								</tr>
							</c:forEach>
					</table>
				</div>
				
				<!-- ***************************************采购退货-编辑栏 start*************************************** -->
				<form action="stockReturnOrderUpdate" method="post">
					<table id="editorform-div2"
						class="table table-border table-bordered table-hover">
						<tr class="text-c">
							<td></td>
							<td>商品</td>
							<td>员工</td>
							<td>采购退货日期</td>
							<td>退货数量</td>
							<td></td>
						</tr>
						<tr class="text-c aaa2">
							<td class="text-d bbb2"><input type="hidden"class="input-text2 input-text" id="stoReturnId" name="stoReturnId"></td>
							<td class="text-d bbb2"><input type="text" class="input-text2 input-text"id="goodsId" name="goodsId" disabled></td>
							<td class="text-d bbb2"><input type="text" class="input-text2 input-text" id="empNo" name="empNo" disabled></td>
							<td class="text-d bbb2"><input type="text" class="input-text2 input-text"id="stoReturnTime" name="stoReturnTime" disabled></td>
							<td class="text-d bbb2"><input type="text" class="input-text2 input-text"id="stoReturnNum" name="stoReturnNum"></td>
							<td>
								<!-- 思路：点击编辑按钮，对应行实现可编辑，编辑按钮隐藏，应用按钮从隐藏到高亮，输入要编辑的内容后，点击应用与后台交互，实时刷新 -->
								<input class="btn btn-primary radius" type="submit" value="提交">
								<a class="btn btn-primary radius cancel2">取消</a>
							</td>
						</tr>

					</table>
				</form>
				<!-- ***************************************采购退货-编辑栏 end*************************************** -->
			</div>
		</div>

	</div>
	<!--end of  tab_demo-->
	<script>
		$(function() {
			$.Huifold("#Huifold1 .item h4", "#Huifold1 .item .info", "fast", 2,"click"); /*5个参数顺序不可打乱，分别是：相应区,隐藏显示的内容,速度,类型,事件*/
		});
	</script>
	<script>
		$(function() {
			$.Huitab(".infos", ".right", "current","click", "2");
		});
	</script>
	<script>
		$(function() {
			$.Huitab("h4", ".right", "current", "click", "0");
		});
	</script>
	<script>
		total = document.documentElement.clientHeight;
		colHeight = total - 32;
		document.getElementById("col3").style.height = colHeight + "px";
	</script>
</body>
</html>