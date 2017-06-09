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

<link href="css/H-ui.min.css" type="text/css" rel="stylesheet" />
<link href="css/sysmanager.css" type="text/css" rel="stylesheet" />
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/html5shiv.js"></script>
<script src="js/H-ui.min.js"></script>
</head>
<style>
.infos{
	cursor:pointer;
}
</style>

<body>
	<div id="tab_demo" class="HuiTab">
		<!--导航条信息-->
		<div class="tabBar clearfix">
			<a href="showEmployees"><span>基础信息</span></a> 
			<span class="current">系统管理</span> 
			<a href="stockOrderShow"><span>采购管理</span></a>
			<a href="showSell"><span>销售管理</span></a>
			<a href="storage.jsp"><span>库存管理</span></a>
		</div>
	
		<!--系统管理侧边栏 -->
		<div class="tabCon fl" id="col2" style="display:block">
			<ul id="Huifold1" class="Huifold">
				<li class="item">
					<h4 class="control">管理员管理<b>+</b></h4> <!--<div class="info">二级菜单，如果添加二级菜单需要添加对应的表</div>-->
					<div class="info"> 
					<a href="showManager"><font class="infos">管理员信息</font></a><br>
					<font class="infos">添加管理员</font><br>
					<font class="infos">删除管理员</font><br> 
					</div>
				</li>
				<li class="item">
					<h4 class="control">公司信息管理<b>+</b></h4> <!--<div class="info">二级菜单，如果添加二级菜单需要添加对应的表</div>-->
					<div class="info"> 
					<a href="showCompany"><font class="infos">公司信息</font></a><br>
					<font class="infos">修改信息</font><br>
					</div>
				</li>
			</ul>
		</div>

	
		<!--基础信息内容（若对应模块下有二级菜单，需要自行添加） -->
		
		<div class="right fl rightControl">
			<div class="panel-body">
				<table class="table table-border table-bordered table-striped mt-20">
					<thead>
						<tr class="text-c">
							<th>账户名</th>
							<th>拥有者</th>
							<th>职位</th>
							<th>权限</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${managers}" var="manager">
							<tr class="text-c">
								<td>${manager.managerName}</td>
								<td>${manager.emp.empName}</td>
								<td>${manager.emp.job}</td>
								<td>${manager.permission }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 添加 -->
		<div class="right fl">
			<form action="addManager" method="post" class="form form-horizontal responsive " style="width:350px">
        <div class="row cl">
          <label class="form-label col-xs-3">账户名：</label>
          <div class="formControls col-xs-8">
            <input type="text" class="input-text"  name="managerName">
          </div>
        </div>
        <div class="row cl">
          <label class="form-label col-xs-3">密码：</label>
          <div class="formControls col-xs-8">
            <input type="text" class="input-text" name="managerPwd">
          </div>
        </div>	
         <div class="row cl">
	          <label class="form-label col-xs-3">权限：</label>
	           <div class="formControls col-xs-8"> <span class="select-box">
            <select class="select" size="1"  name="permission">
            		<option value="0">0</option>
            		<option value="1">1</option>
            </select>
            </span> </div>
        </div>	 
        <div class="row cl">
          <label class="form-label col-xs-3">拥有者：</label>
          <div class="formControls col-xs-8"> <span class="select-box">
            <select class="select" size="1"  name="empNo">
            	<c:forEach items="${employees}" var="employee">
            		<option value="${employee.empNo}">${employee.empName}</option>
            	</c:forEach>
            </select>
            </span> </div>
        </div>
         <div class="row cl">
          <input type="submit" class="text-c btn btn-primary radius" value="提交" style="margin-left:150px"/>
        </div>	
       </form>
       
        </div>
<!-- 删除管理员 -->
		<div class="right fl">
			<div class="panel-body">
				<form action="deleteManager">
				<table class="table table-border table-bordered table-striped mt-20">
					<thead>
						<tr class="text-c">
							<th>账户名</th>
							<th>拥有者</th>
							<th>职位</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${managers}" var="manager">
							<tr class="text-c">
								<td>${manager.managerName}</td>
								<td>${manager.emp.empName}</td>
								<td>${manager.emp.job}</td>
								<td>
								<input type="hidden" value="${manager.managerId}" name="managerId"/>
								<input type="submit" class="text-c btn btn-primary radius" value="提交"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</form>
			</div>
		</div>
		<div class="right fl rightControl">
		<div class="panel-body">
				<table class="table table-border table-bordered table-striped mt-20">
					<thead>
						<tr class="text-c">
							<th>公司名</th>
							<th>联系电话</th>
							<th>传真</th>
							<th>联系地址</th>
							<th>法人代表</th>
							<th>公司账户</th>
							<th>公司邮箱</th>
							<th>网址</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${companys}" var="company">
							<tr class="text-c">
								<td>${company.companyName}</td>
								<td>${company.companyTel}</td>
								<td>${company.companyFax}</td>
								<td>${company.companyAddress}</td>
								<td>${company.companyLegalPerson}</td>
								<td>${company.companyAccount}</td>
								<td>${company.companyEmail}</td>
								<td>${company.companyUrl}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 修改公司信息 -->
		<div class="right fl rightControl">
		<div class="panel-body">
				<table class="table table-border table-bordered table-striped mt-20 alterTable">
					<thead>
						<tr class="text-c">
							<th>公司名</th>
							<th>联系电话</th>
							<th>传真</th>
							<th>联系地址</th>
							<th>法人代表</th>
							<th>公司账户</th>
							<th>公司邮箱</th>
							<th>网址</th>
							<th>编辑</th>
						</tr>
					</thead>
					<tbody class="alterTbody">
						<c:forEach items="${companys}" var="company">
							<tr class="text-c alterTr">
								<td class="alterTd">${company.companyName}</td>
								<td class="alterTd">${company.companyTel}</td>
								<td class="alterTd">${company.companyFax}</td>
								<td class="alterTd">${company.companyAddress}</td>
								<td class="alterTd">${company.companyLegalPerson}</td>
								<td class="alterTd">${company.companyAccount}</td>
								<td class="alterTd">${company.companyEmail}</td>
								<td class="alterTd">${company.companyUrl}</td>
								<td>
								<input type="hidden" value="${company.companyId}" class="alterInput"/>
								<input type="button" class="text-c btn btn-primary radius alter" value="修改"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<form action="alterCompany" method="post" class="form form-horizontal responsive alterBox" >
  	 <div class="row cl">
          <label class="form-label col-xs-3">公司名：</label>
          <div class="formControls col-xs-8">
            <input type="text" class="input-text" name="companyName" disabled>
          </div>
        </div> 
        <div class="row cl">
          <label class="form-label col-xs-3">联系电话：</label>
          <div class="formControls col-xs-8">
            <input type="text" class="input-text" name="companyTel">
          </div>
        </div>	 
        <div class="row cl">
          <label class="form-label col-xs-3">传真：</label>
          <div class="formControls col-xs-8">
            <input type="text" class="input-text" name="companyFax">
          </div>
        </div>	 
        <div class="row cl">
          <label class="form-label col-xs-3">联系地址：</label>
          <div class="formControls col-xs-8">
            <input type="text" class="input-text" name="companyAddress">
          </div>
        </div>	 
        <div class="row cl">
          <label class="form-label col-xs-3">法人代表：</label>
          <div class="formControls col-xs-8">
            <input type="text" class="input-text" name="companyLegalPerson" disabled>
          </div>
        </div>	 
        <div class="row cl">
          <label class="form-label col-xs-3">公司账户：</label>
          <div class="formControls col-xs-8">
            <input type="text" class="input-text" name="companyAccount" disabled>
          </div>
        </div>	 
        <div class="row cl">
          <label class="form-label col-xs-3">公司邮箱：</label>
          <div class="formControls col-xs-8">
            <input type="text" class="input-text" name="companyEmail">
          </div>
        </div>	 
        <div class="row cl">
          <label class="form-label col-xs-3">网址：</label>
          <div class="formControls col-xs-8">
            <input type="text" class="input-text" name="companyUrl"  disabled>
          </div>
        </div>	
        <div class="row cl">
          <div class="col-xs-8 col-xs-offset-3">
          	<input type="hidden" class="input-hidden" name="companyId"/>
            <input class="btn btn-primary alterSubmit" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
          </div>
        </div>
  </form>
	<!--end of  tab_demo-->
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
		$(function() {
			$.Huitab(".control", ".rightControl", "current", "click", "0");
		});
	</script>
	<script>
	$(".alterBox").hide();
	$(".alter").each(function(index) {
        $(this).on('click',function(event){
			//alert(index)
			event.stopPropagation();
			$(".alterBox").show();
			//$alterParent=$(".alterTbody").eq(index)
			//alert($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq(2).text())
			$(".alterBox .row ").each(function(){
				var $index=$(this).index();		
				$(this).find(".input-text").val($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq($index).text());	
				$(this).find(".input-hidden").val($(".alter").eq(index).parents(".alterTr").find('.alterInput').val());
			});
		});

    });
	$(".alterSubmit").click(function(){
		return confirm("是否确认修改？");
		
		});
	$(".right").click(function(){
		
		$(".alterBox").hide();
	});
		total = document.documentElement.clientHeight;
		colHeight = total - 32;
		document.getElementById("col2").style.height = colHeight + "px";
	</script>
</body>
</html>