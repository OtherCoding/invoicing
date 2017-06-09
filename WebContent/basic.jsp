<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>无标题文档</title>
		<!--[if lt IE 9]>
		<script type="text/javascript" src="Lib/html5shi.js"></script>
		<![endif]-->
        <link href="css/H-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="css/index.css" type="text/css" rel="stylesheet"/>
        <script src="js/jquery-1.8.3.min.js"></script>
        <script src="js/html5shiv.js"></script>
        <script src="js/H-ui.min.js"></script>
        <script src="js/basic.js"></script>    	
    </head>	
    <style type="text/css">
    	.div-application{
            width: 1000px;
            border: #f00 solid 1px;
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
            border: #f00 solid 1px;
            margin:0 auto;
        }
    </style>

    <body>
        <div id="tab_demo" class="HuiTab">
        	<!--导航条信息-->
            <div class="tabBar clearfix">
                <span class="current">基础信息</span>
                <a href="showCompany"><span>系统管理</span></a>
                <a href="stockOrderShow"><span>采购管理</span></a>
                <a href="showSell"><span>销售管理</span></a>
                <a href="storage.jsp"><span>库存管理</span></a>
            </div>
            <!--基础信息侧边栏 -->
            <div class="tabCon fl" id="col1" style="display:block">
                <ul id="Huifold1" class="Huifold" >
                    <li class="item">
                        <h4><a href="showEmployees">员工信息</a></h4>
                        <!--<div class="info">二级菜单，如果添加二级菜单需要添加对应的表</div>-->  
                    </li>
                    <li class="item">
                        <h4><a href="showSupplier">供应商信息</a></h4>
                        <!--<div class="info">二级菜单，如果添加二级菜单需要添加对应的表</div>-->  
                    </li>
                    <li class="item">
                        <h4><a href="showGoods">商品信息</a></h4>
                        <!--<div class="info">二级菜单，如果添加二级菜单需要添加对应的表</div>-->  
                    </li>
                </ul>
            </div>
     		<!--基础信息内容（若对应模块下有二级菜单，需要自行添加） -->
     		<!-- *********************************************员工信息************************************************** -->
            <div class="right fl">
            	<div class="div-application">
		            <div class="div-title">添加员工信息</div> 
					<div class="div-table">
						<form action="AddEmployees" method="post">
							<table class="table table-border table-bordered table-hover">
								<tr class="text-c">
									<td class="text-r">员工编号：</td>
									<td>
										<input type="text" class="input-text" name="addEmpNo"/>
									</td>
									<td class="text-r">员工姓名：</td>
									<td>
										<input type="text" class="input-text" name="addEmpName"/>
									</td>
								</tr>
								<tr class="text-c">
									<td class="text-r">员工薪资：</td>
									<td>
										<input type="text" class="input-text" name="addSalary"/>
									</td>
									<td class="text-r">员工职务：</td>
									<td>
										<input type="text" class="input-text" name="addJob"/> 
									</td>
								</tr>
								<tr>
									<td class="text-r">部门：</td>
									<td>
										<select class="select" size="1" name="addDeptNo">
											<option value="" selected>&nbsp;&nbsp;</option>
											<option value="1">销售部</option>
											<option value="2">采购部</option>
											<option value="3">库存部</option>
											<option value="3">人事部</option>
										</select>
									</td>
									<td></td>
									<td class="text-r">
										<input class="btn btn-primary radius" type="submit" value="提交"/>
									</td>
								</tr>
							</table>
						</form>
					</div>
	            	<div class="div-title">员工信息</div>
					<div class="div-table">
						<table class="table table-border table-bordered ">
							<tr class="text-c">
								<td>员工编号</td>
								<td>员工姓名</td>
								<td>员工薪资</td>
								<td>员工职位</td>
								<td>部门名称</td>
								<td>部门负责人</td>
							</tr>
							<c:forEach items="${employeesList}" var="employees" varStatus="status">
								<tr class="text-c alterTr">
									<td class="alterTd">${employees.empNo}</td>
									<td class="alterTd">${employees.empName}</td>
									<td class="alterTd">${employees.salary}</td>
									<td class="alterTd">${employees.job}</td>
									<td class="alterTd">${employees.dept.deptName}</td>
									<td class="alterTd">${employees.dept.deptHeader}</td>
									<td>
										<input class="btn btn-primary radius employees" type="button" value="编辑"/>
										<a class="btn btn-primary radius" href="deleteEmployees?deleteEmpNo=${employees.empNo}">删除</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div><!--end div-application-->
            
	            <!-- ***********************修改员工信息******************************** -->
	            <div id="editorform-Employees"><!-- start editorform -->
					<form action="editorEmployees" method="post" class="form form-horizontal responsive alterBox" >
						<div class="row cl">
							<label class="form-label col-xs-3">员工编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorEmpNo" />
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">员工姓名：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorEmpName" disabled />
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">员工薪资：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSalary" />
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">员工职务：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorJob" />
							</div>
						</div>
						<div class="row cl">
							<label class="form-label col-xs-3">部门名称：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" value="" name="editorDeptName" />
							</div>
						</div>	
						<div class="row cl">
							<label class="form-label col-xs-3">部门负责人：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" value="" name="editorDeptHeader" />
							</div>
						</div> 
						<div class="row cl">
							<div class="col-xs-8 col-xs-offset-3">
								<input class="btn btn-primary alterSubmit" id="editorEmployees" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" />
							</div>
						</div>
					</form>
				</div><!-- end editorform -->
			</div><!--end of right fl-->	          
             <!-- *********************************************供应商************************************************** -->
            <div class="right fl" >
				<div class="div-title">添加供应商</div>
				<div class="div-table">
					<form action="addSupplier" method="post" >
						<table class="table table-border table-bordered table-hover">
							<tr class="text-c">
								<td class="text-r">编号：</td>
								<td>
									<input type="text" class="input-text" name="addSupplierId"/>
								</td>
								<td class="text-r">名称：</td>
								<td>
									<input type="text" class="input-text" name="addSupplierName"/>
								</td>
							</tr>
							<tr class="text-c">	                                
								<td class="text-r">类别：</td>
								<td>
									<input type="text" class="input-text" name="addSupplierType"/>
								</td>
								<td class="text-r">联系人：</td>
								<td>
									<input type="text" class="input-text" name="addContacts"/> 
								</td>
							</tr>
							<tr class="text-c">	                                
								<td class="text-r">联系电话：</td>
								<td>
									<input type="text" class="input-text" name="addContactTel"/>
								</td>
								<td class="text-r">地址：</td>
								<td>
									<input type="text" class="input-text" name="addSupplierAddress"/> 
								</td>
							</tr>
							<tr class="text-c">	                                
								<td class="text-r">传真：</td>
								<td>
									<input type="text" class="input-text" name="addSupplierFax"/>
								</td>
								<td class="text-r">说明：</td>
								<td>
									<input type="text" class="input-text" name="addSupplierInfo"/> 
								</td>
							</tr>
							<tr>
								<td class="text-r">信用评价：</td>
								<td>
									<input type="text" class="input-text" name="addSupplierAssess"/> 
								</td>
								<td ></td>
								<td class="text-r">
									<input class="btn btn-primary radius" type="submit" value="提交">
								</td>
							</tr>
						</table>
					</form>
				</div>
           	 	<div class="div-title">供应商信息</div>
				<div class="div-table">
					<table class="table table-border table-bordered ">
						<tr class="text-c">
							<td>编号</td>
							<td>名称</td>
							<td>类别</td>
							<td>联系人</td>
							<td>联系电话</td>
							<td>地址</td>
							<td>传真</td>
							<td>说明</td>
							<td>信用评价</td>
							<td>编辑</td>
						</tr>
						<c:forEach items="${supplierList}" var="supplier" varStatus="status">
							<tr class="text-c">
								<td>${supplier.supplierId}</td>
								<td>${supplier.supplierName}</td>
								<td>${supplier.supplierType}</td>
								<td>${supplier.contacts}</td>
								<td>${supplier.contactTel}</td>
								<td>${supplier.supplierAddress}</td>
								<td>${supplier.supplierFax}</td>
								<td>${supplier.supplierInfo}</td>
								<td>${supplier.supplierAssess}</td>
								<td>
									<input class="btn btn-primary radius supplier" type="button" value="编辑" />
									<a class="btn btn-primary radius" href="deleteSupplier?deleteSupplierid=${supplier.supplierId}">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- *********************供应商信息的修改***************************************** -->
	            <div id="editorform-Supplier"><!-- start editorform -->
					<form action="editorSupplier" method="post" class="form form-horizontal responsive alterBox" >
						<div class="row cl">
							<label class="form-label col-xs-3">编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSupplierId" />
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">名称：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSupplierName" />
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">类别：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSupplierType" />
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">联系人：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorContacts" />
							</div>
						</div>
						<div class="row cl">
							<label class="form-label col-xs-3">联系电话：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorContactTel" />
							</div>
						</div>	
						<div class="row cl">
							<label class="form-label col-xs-3">地址：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSupplierAddress" />
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">传真：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSupplierFax" />
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">说明：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSupplierInfo" />
							</div>
						</div>
						<div class="row cl">
							<label class="form-label col-xs-3">信用评价：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSupplierAssess" />
							</div>
						</div> 
						<div class="row cl">
							<div class="col-xs-8 col-xs-offset-3">
								<input class="btn btn-primary alterSubmit" id="editorSupplier" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
							</div>
						</div>
					</form>
				</div><!-- end editorform -->
            </div><!--end of right fl-->
            
            
	
            <div class="right fl" >
            <!-- ******************添加商品信息*************************** -->         
				<div class="div-title">添加商品 </div>
				<div class="div-table">
					<form action="AddGoods" method="post">
						<table class="table table-border table-bordered table-hover">
							<tr class="text-c">
								<td class="text-r">编号：</td>
								<td>
									<input type="text" class="input-text" name="addGoodsId"/>
								</td>
								<td class="text-r">类别：</td>
								<td>
									<input type="text" class="input-text" name="addGoodsType"/>
								</td>
							</tr>
							<tr class="text-c">	                                
								<td class="text-r">名称：</td>
								<td>
									<input type="text" class="input-text" name="addGoodsName" />
								</td>
								<td class="text-r">品牌：</td>
								<td>
									<input type="text" class="input-text" name="addBrand"/> 
								</td>
							</tr>
							<tr class="text-c">	                                
								<td class="text-r">型号：</td>
								<td>
									<input type="text" class="input-text" name="addProductModel" />
								</td>
								<td class="text-r">进货价格：</td>
								<td>
									<input type="text" class="input-text" name="addCostPrice" /> 
								</td>
							</tr>
							<tr class="text-c">	                                
								<td class="text-r">销售价格：</td>
								<td>
									<input type="text" class="input-text" name="addRetailPrice"/>
								</td>
								<td class="text-r">商品简码：</td>
								<td>
									<input type="text" class="input-text" name="addGoodsCode"/> 
								</td>
							</tr>
							<tr>
								<td class="text-r">条形码：</td>
								<td>
									<input type="text" class="input-text" name="addBarCode" /> 
								</td>
								<td class="text-r">供应商编号：</td>
								<td class="text-r">
									<select class="select" size="1" name="addSupplierId">
										<option value="" selected>&nbsp;&nbsp;</option>
										<option value="1">宝洁</option>
										<option value="2">好时</option>
										<option value="3">乐扣</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="text-r" colspan="4">
									<input class="btn btn-primary radius" type="submit" value="提交" />
								</td>
							</tr>
						</table>
					</form>
				</div>        
				<!-- *********************************************商品信息************************************************** -->
				<div class="div-title">商品信息</div>
				<div class="div-table">
					<table class="table table-border table-bordered ">
						<tr class="text-c">
							<td>编号</td>
							<td>类别</td>
							<td>名称</td>	                                
							<td>品牌</td>
							<td>型号</td>
							<td>进货价格</td>
							<td>销售价格</td>
							<td>商品简码</td>
							<td>条形码</td>
							<td>供应商编号</td>
							<td>供应商名称</td>
							<td></td>
						</tr>
						<c:forEach items="${goodsList}" var="goods" varStatus="status">
							<tr class="text-c">
								<td>${goods.goodsId}</td>
								<td>${goods.goodsType.goodsType}</td>
								<td>${goods.goodsName}</td>
								<td>${goods.brand}</td>
								<td>${goods.productModel}</td>
								<td>${goods.costPrice}</td>
								<td>${goods.retailPrice}</td>
								<td>${goods.goodsCode}</td>
								<td>${goods.barCode}</td>
								<td>${goods.supplier.supplierId}</td>
								<td>${goods.supplier.supplierName}</td>
								<td>
									<input class="btn btn-primary radius goods" type="button" value="编辑" />
									<a class="btn btn-primary radius" href="deleteGoods?deletegoodsId=${goods.goodsId}">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>	          
            
				<!-- ***********************修改商品信息******************************** -->
				<div id="editorform-Goods"><!-- start editorform -->
					<form action="editorGoods" method="post" class="form form-horizontal responsive alterBox" >
						<div class="row cl">
							<label class="form-label col-xs-3">商品编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorGoodsId" />
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">类型编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorGoodsType" />
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">商品名称：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorGoodsName" />
							</div>
						</div>	 
						<div class="row cl">
							<label class="form-label col-xs-3">品牌：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorBrand" />
							</div>
						</div>
						<div class="row cl">
							<label class="form-label col-xs-3">型号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorProductModel" />
							</div>
						</div>	
						<div class="row cl">
							<label class="form-label col-xs-3">进货价格：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorCostPrice" />
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">销售价格：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorRetailPrice" />
							</div>
						</div> 
						 <div class="row cl">
							<label class="form-label col-xs-3">商品简码：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorGoodsCode" />
							</div>
						</div> 
						<div class="row cl">
							<label class="form-label col-xs-3">商品简码：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorBarCode" />
							</div>
						</div>
						<div class="row cl">
							<label class="form-label col-xs-3">供应商编号：</label>
							<div class="formControls col-xs-8">
								<input type="text" class="input-text" name="editorSupplierId" />
							</div>
						</div>
						<div class="row cl">
							<div class="col-xs-8 col-xs-offset-3">
								<input class="btn btn-primary alterSubmit" id="editorGoods" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" />
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
            $(function(){
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
            document.getElementById("col1").style.height=colHeight+"px";
        </script>
    </body>
</html>