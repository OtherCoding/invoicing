<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>无标题文档</title>
        <!--[if lt IE 9]>
		<script type="text/javascript" src="js/html5shi.js"></script>
		<![endif]-->
        <link href="css/H-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="css/index.css" type="text/css" rel="stylesheet"/>
        <script src="js/jquery-1.8.3.min.js"></script>
        <script src="js/html5shiv.js"></script>
        <script src="js/H-ui.min.js"></script>
        <script src="js/sell.js"></script>
		<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
             	
    	<style type="text/css">
	    	.div-application{
	            width: 1000px;
	            
	            margin:0 auto;
	            margin-bottom: 20px;
	        }  
	        .div-title {/*功能名样式*/
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
	        .div-table{/*表格的框*/
	            width: 900px;
	            
	            margin:0 auto;
	        }
	    </style>
		<script type="text/javascript">
			/*
			$(function(){
				$(".datetimepicker1").datetimepicker({
					format: 'yyyy-mm-dd',
					minView: "month",
					todayBtn:  1,
					autoclose: 1
				}).on('hide',function(e) {
					//此处可以触发日期校验。
				});
			});
			*/
	    </script>
    </head>	
  

    <body>
    	<input type="hidden" value="${sellList }" id="sellList"/>
    	<input type="hidden" value="${sellOutHouseList }" id="sellOutHouseList"/>
    	<input type="hidden" value="${sellBackHouseList }" id="sellBackHouseList"/>
    	<input type="hidden" value="${getMoneyList }" id="getMoneyList"/>
    	
        <div id="tab_demo" class="HuiTab">
        	<!--导航条信息-->
            <div class="tabBar clearfix">
                <a href="showEmployees"><span>基础信息</span></a>
                <a href="showCompany"><span>系统管理</span></a>
                <a href="stockOrderShow"><span>采购管理</span></a>
                <span class="current">销售管理</span>
                <a href="storage.jsp"><span>库存管理</span></a> 
            </div>
            <!--销售管理侧边栏 -->
            <div class="tabCon fl" id="col4" style="display:block">
                <ul id="Huifold1" class="Huifold" >
                    <li class="item">
                    	<h4><a href="showSell">销售订单</a></h4>
                    </li>
                    <li class="item">
                    	<h4><a href="showSellOutHouseAll">销售出库</a></h4>
                    </li>
                    <li class="item">
                    	<h4><a href="showSellBackHouseAll">销售退货</a></h4>
                    </li>
                    <li class="item">
                    	<h4><a href="showGetMoney">销售收款</a></h4> 
                    </li>
                </ul>
            </div>
     		<!--基础信息内容（若对应模块下有二级菜单，需要自行添加） -->
            <div class="right fl"><!-- 销售订单 -->
            	<div class="div-application">
                    <div class="div-title">添加销售订单</div>
                    <div class="div-table">
                        <form action="addSell" method="post">
                        	<table class="table table-border table-bordered table-hover">
                                <tr class="text-c">
                                    <td class="text-r">商品编号/名称：</td>
                                    <td>
                                        <select class="select" size="1" name="addSellGoodsId">
                                            <option value="0" selected>&nbsp;&nbsp;</option>
                                            <option value="1">清扬</option>
                                            <option value="2">好时薯片</option>
                                            <option value="3">乐扣</option>
                                        </select>
                                    </td>
                                    <td class="text-r">销售单价：</td>
                                    <td>
                                        <input type="text" class="input-text" name="addSellSinglePrice"/>
                                    </td>
                                </tr>
                                <tr class="text-c">
                                    <td class="text-r">数量：</td>
                                    <td>
                                        <input type="text" class="input-text" name="addSellCounts"/>
                                    </td>
                                    <td class="text-r"> 销售时间：</td>
                                    <td>
                                        <input type="text" class="input-text datetimepicker1" value=""  name="addSellTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
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
                
                    <div class="div-title">销售订单信息</div>
                    <div class="div-table">
                        <table class="table table-border table-bordered table-hover">
                            <tr class="text-c">
                                <td>销售单编号</td>
                                <td>商品编号</td>
                                <td>商品名称</td>
                                <td>销售单价</td>
                                <td>数量</td>
                                <td>销售时间</td>
                                <td></td>
                           </tr>
                           <c:forEach items="${sellList }" var="sell" varStatus="status">
                            	<tr class="text-c alterTr">
	                                <td class="alterTd"><c:out value="${sell.sellId }"/></td>
	                                <td class="alterTd"><c:out value="${sell.goods.goodsId }"/></td>
	                                <td class="alterTd"><c:out value="${sell.goods.goodsName }"/></td>
	                                <td class="alterTd"><c:out value="${sell.sellSinglePrice }"/></td>
	                                <td class="alterTd"><c:out value="${sell.counts}"/></td>
	                                <td class="alterTd"><c:out value="${sell.sellTime }"/></td>
	                                <td>
	                                	<input type="hidden" class="alterInput" value="${sell.sellId }"/>
	                                    <input class="btn btn-primary radius alter" type="button" value="编辑"/>
	                                    <a class="btn btn-primary radius" href="deleteSell?deleteSellId=${sell.sellId }">删除</a>
	                                </td>
                            	</tr>
                           </c:forEach>
                        </table>
                    </div>
                </div><!--end div-application-->
                <div id="editorform-sell"><!-- start editorform -->
				    <form action="editorSell" method="post" class="form form-horizontal responsive alterBox" >
				        <div class="row cl">
				            <label class="form-label col-xs-3">销售单编号：</label>
				            <div class="formControls col-xs-8">
				            	<input type="text" class="input-text"  disabled/>
				        	</div>
				        </div> 
				        <div class="row cl">
				            <label class="form-label col-xs-3">商品编号：</label>
				            <div class="formControls col-xs-8">
				            	<input type="text" class="input-text" name="editorSellGoodsId" disabled/>
				        	</div>
				        </div> 
				        <div class="row cl">
				            <label class="form-label col-xs-3">商品名称：</label>
				            <div class="formControls col-xs-8">
				            	<input type="text" class="input-text" name="editorSellGoodsName" disabled/>
				            </div>
				        </div>	 
				        <div class="row cl">
				            <label class="form-label col-xs-3">销售单价：</label>
				            <div class="formControls col-xs-8">
				            	<input type="text" class="input-text" name="editorSellSinglePrice"/>
				            </div>
				        </div>	 
				        <div class="row cl">
				            <label class="form-label col-xs-3">数量：</label>
				            <div class="formControls col-xs-8">
				                <input type="text" class="input-text" name="editorSellCounts"/>
				            </div>
				        </div>
				        <div class="row cl">
				            <label class="form-label col-xs-3">销售日期：</label>
				            <div class="formControls col-xs-8">
				            	<input type="text" class="input-text datetimepicker1" value=""  name="editorSellTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
				            </div>
				        </div>	 
				        <div class="row cl">
				            <div class="col-xs-8 col-xs-offset-3">
				            	<input type="hidden" class="input-hidden" name="editorSellId" />
				            	<input class="btn btn-primary alterSubmit" id="editorSellSubmit" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"/>
				            </div>
				        </div>
				    </form>
				</div><!-- end editorform -->
            </div><!--end of right fl-->
            <div class="right fl"><!-- 销售出库 -->
           	 	<div class="div-application">
                    <div class="div-title"> 添加销售出库订单 </div>
                    <div class="div-table">
                        <form action="addSellOutHouse">
                        	<table class="table table-border table-bordered table-hover">
                                <tr class="text-c">
                                    <td class="text-r">销售单编号/商品编号/商品名称： </td>
                                    <td colspan="3">
                                        <select class="select" size="1" name="addSellOutHouseSellId">
	                                        <c:forEach items="${sellList}" var="sell" varStatus="status">
	                                            <option value="${sell.sellId }">销售单编号:${sell.sellId }/商品编号:${sell.goods.goodsId }/商品名称：${sell.goods.goodsName }</option>
	                                        </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr class="text-c">
                                    <td class="text-r">
                                        	销售出库数量：
                                    </td>
                                    <td>
                                        <input type="text" class="input-text" name="addSellOutHouseCount"/>
                                    </td>
                                    <td class="text-r">
                                       	 销售出库日期：
                                    </td>
                                    <td >
                                       <input type="text" class="input-text datetimepicker1" value=""  name="addSellOutHouseDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                                    </td>
                                </tr>
                                <tr class="text-c">
                                    <td class="text-r" colspan="4">
                                       <input class="btn btn-primary radius" type="submit" value="提交">
                                    </td>
                                </tr>
                        	</table>
                        </form>
                    </div>
                
                    <div class="div-title">销售出库单信息</div>
                    <div class="div-table">
                        <table class="table table-border table-bordered table-hover">
                            <tr class="text-c">
                                <td>销售出库单编号</td>
                                <td>销售单编号</td>
                                <td>商品编号</td>
                                <td>商品名称</td>
                                <td>销售出库数量</td>
                                <td>销售出库日期</td>
                                <td></td>
	                        </tr>
                            <c:forEach items="${sellOutHouseList}" var="sellOutHouse" varStatus="status">
                            	<tr class="text-c alterTr">
	                                <td class="alterTd">${sellOutHouse.sellOutHouseId }</td>
	                                <td class="alterTd">${sellOutHouse.sell.sellId }</td>
	                                <td class="alterTd">${sellOutHouse.sell.goods.goodsId}</td>
	                                <td class="alterTd">${sellOutHouse.sell.goods.goodsName}</td>
	                                <td class="alterTd">${sellOutHouse.counts }</td>
	                                <td class="alterTd">${sellOutHouse.sellDate }</td>
	                                <td>
	                                	<input type="hidden" class="alterInput" value="${sellOutHouse.sellOutHouseId }"/>
	                                    <input class="btn btn-primary radius alter" type="button" value="编辑"/>
	                                    <a class="btn btn-primary radius" href="deleteSellOutHouse?deleteSellOutHouseId=${sellOutHouse.sellOutHouseId }">删除</a>
	                                </td>
                            	</tr>
                            </c:forEach>
                        </table>
                    </div>
                </div><!--end div-application-->
                <div id="editorform-sellOutHouse"><!-- start editorform -->
					<form action="editorSellOutHouse" method="post" class="form form-horizontal responsive alterBox" >
						<div class="row cl">
							<label class="form-label col-xs-3">销售出库单编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">销售单编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">商品编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">商品名称：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">销售出库数量：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSellOutHouseCount"/>
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">销售出库日期：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text datetimepicker1" value=""  name="editorSellOutHouseDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
							</div>
						</div>
						<div class="row cl">
							<div class="col-xs-8 col-xs-offset-3">
								<input type="hidden" class="input-hidden" name="editorSellOutHouseId" />
								<input class="btn btn-primary alterSubmit" type="submit" id="editorSellOutHouseSubmit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"/>
							</div>
						</div>
					</form>
				</div><!-- end editorform -->
            </div>
            <div class="right fl"><!-- 销售退货 -->
            	<div class="div-application">
                    <div class="div-title"> 添加销售退货订单 </div>
                    <div class="div-table">
                        <form action="addSellBackHouse">
                        	<table class="table table-border table-bordered table-hover">
                                <tr class="text-c">
                                    <td class="text-r">销售单编号/商品编号/商品名称： </td>
                                    <td colspan="3">
                                        <select class="select" size="1" name="addSellBackHouseSellId">
	                                        <c:forEach items="${sellList}" var="sell" varStatus="status">
	                                            <option value="${sell.sellId }">销售单编号:${sell.sellId }/商品编号:${sell.goods.goodsId }/商品名称：${sell.goods.goodsName }</option>
	                                        </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr class="text-c">
                                    <td class="text-r">销售退货数量：</td>
                                    <td>
                                        <input type="text" class="input-text" name="addSellBackHouseCounts"/>
                                    </td>
                                    <td class="text-r"> 销售退货日期： </td>
                                    <td>
                                        <input type="text" class="input-text datetimepicker1" value=""  name="addSellBackHouseDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-r" colspan="4">
                                        <input class="btn btn-primary radius" type="submit" value="提交"/>
                                    </td>
                                </tr>
                        	</table>
                        </form>
                    </div>
                
                    <div class="div-title">销售退货单信息</div>
                    <div class="div-table">
                        <table class="table table-border table-bordered table-hover">
                            <tr class="text-c">
                                <td>销售退货单编号</td>
                                <td>销售单编号</td>
                                <td>商品编号</td>
                                <td>商品名称</td>
                                <td>销售退货数量</td>
                                <td>退货时间日期</td>
                                <td></td>
                           
                            <c:forEach items="${backHouseList}" var="backHouse" varStatus="status">
                            	<tr class="text-c alterTr">
	                                <td class="alterTd">${backHouse.sellbackSheetId }</td>
	                                <td class="alterTd">${backHouse.sell.sellId }</td>
	                                <td class="alterTd">${backHouse.sell.goods.goodsId}</td>
	                                <td class="alterTd">${backHouse.sell.goods.goodsName}</td>
	                                <td class="alterTd">${backHouse.counts }</td>
	                                <td class="alterTd">${backHouse.backGoodsTime }</td>
	                                <td>
	                                	<input type="hidden" class="alterInput" value="${backHouse.sellbackSheetId }"/>
	                                    <input class="btn btn-primary radius alter" type="button" value="编辑"/>
	                                    <a class="btn btn-primary radius" href="deleteSellBackHouse?deleteSellBackHouseId=${backHouse.sellbackSheetId }">删除</a>
	                                </td>
                            	</tr>
                            </c:forEach>
                        </table>
                    </div>
                </div><!--end div-application-->
                <div id="editorform-sellBackHouse"><!-- start editorform -->
					<form action="editorSellBackHouse" method="post" class="form form-horizontal responsive alterBox" >
						<div class="row cl">
							<label class="form-label col-xs-3">销售退货单编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">销售单编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">商品编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">商品名称：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">销售退货数量：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSellBackHouseCount"/>
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">退货时间日期：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text datetimepicker1" value=""  name="editorSellBackHouseTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
							</div>
						</div>
						<div class="row cl">
							<div class="col-xs-8 col-xs-offset-3">
								<input type="hidden" class="input-hidden" name="editorSellBackHouseId" />
								<input class="btn btn-primary alterSubmit" type="submit" id="editorSellBackHouseSubmit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"/>
							</div>
						</div>
					</form>
				</div><!-- end editorform -->
            </div>
            <div class="right fl"><!-- 销售收款 -->
           		<div class="div-application">
                    <div class="div-title"> 添加销售收款单</div>
                    <div class="div-table">
                        <form action="addGetMoney">
                        	<table class="table table-border table-bordered table-hover">
                                <tr class="text-c">
                                    <td class="text-r">
                                        	销售单编号/商品编号/商品名称：
                                    </td>
                                    <td colspan="3">
                                       <select class="select" size="1" name="addGetMoneySellId">
	                                        <c:forEach items="${sellList}" var="sell" varStatus="status">
	                                            <option value="${sell.sellId }">销售单编号:${sell.sellId }/商品编号:${sell.goods.goodsId }/商品名称：${sell.goods.goodsName }</option>
	                                        </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr class="text-c">
                                    <td class="text-r">
                                        	应收款：
                                    </td>
                                    <td>
                                        <input type="text" class="input-text" name="addGetMoneyShouldGetMoney"/>
                                    </td>
                                    <td class="text-r">
                                       	 实收款：
                                    </td>
                                    <td>
                                        <input type="text" class="input-text" name="addGetMoneyGetMoney"/> 
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-r" colspan="4">
                                        <input class="btn btn-primary radius" type="submit" value="提交"/>
                                    </td>
                                </tr>
                        	</table>
                        </form>
                    </div>
                
                    <div class="div-title">销售收款单信息</div>
                    <div class="div-table">
                        <table class="table table-border table-bordered table-hover">
                            <tr class="text-c">
                                <td>销售收款单编号</td>
                                <td>销售单编号</td>
                                <td>商品编号</td>
                                <td>商品名称</td>
                                <td>应收款</td>
                                <td>实收款</td>
                                <td></td>
                            </tr>
                            <c:forEach items="${getMoneyList}" var="getMoney" varStatus="status">
                            	<tr class="text-c alterTr">
	                                <td class="alterTd">${getMoney.getMoneySheetId }</td>
	                                <td class="alterTd">${getMoney.sell.sellId }</td>
	                                <td class="alterTd">${getMoney.sell.goods.goodsId}</td>
	                                <td class="alterTd">${getMoney.sell.goods.goodsName}</td>
	                                <td class="alterTd">${getMoney.shouldGetMoney }</td>
	                                <td class="alterTd">${getMoney.getMoney }</td>
	                                <td>
	                                	<input type="hidden" class="alterInput" value="${getMoney.getMoneySheetId }"/>
	                                    <input class="btn btn-primary radius alter" type="button" value="编辑"/>
	                                    <a class="btn btn-primary radius" href="deleteGetMoney?deleteGetMoneyId=${getMoney.getMoneySheetId }">删除</a>
	                                </td>
                            	</tr>
                            </c:forEach>
                        </table>
                    </div>
                </div><!--end div-application-->
                <div id="editorform-getMoney"><!-- start editorform -->
					<form action="editorGetMoney" method="post" class="form form-horizontal responsive alterBox" >
						<div class="row cl">
							<label class="form-label col-xs-3">销售收款单编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">销售单编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">商品编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">商品名称：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" disabled/>
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">应收款：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSellShouldGetMoney"/>
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">实收款：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSellGetMoney"/>
							</div>
						</div>
						<div class="row cl">
							<div class="col-xs-8 col-xs-offset-3">
								<input type="hidden" class="input-hidden" name="editorSellGetMoneySheetId" />
								<input class="btn btn-primary alterSubmit" type="submit" id="editorGetMoneySubmit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"/>
							</div>
						</div>
					</form>
				</div><!-- end editorform -->
            </div>
        </div><!--end of  tab_demo-->
      <script>
         $(function(){
       	  $.Huifold("#Huifold1 .item h4","#Huifold1 .item .info","fast",1,"click"); /*5个参数顺序不可打乱，分别是：相应区,隐藏显示的内容,速度,类型,事件*/
         });
      </script>
      <script>
      	$(function() {
			$.Huitab(".infos", ".right", "current", "click", "0");
		});
      </script>
      <script>
        $(function(){
        	$.Huitab("h4",".right","current","click","0");
        });
      </script>
      <script>
          total = document.documentElement.clientHeight;
          colHeight = total-32;
          document.getElementById("col4").style.height=colHeight+"px";
      </script>
    </body>
</html>