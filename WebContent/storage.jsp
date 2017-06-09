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
    </head>	
  

    <body>
        <div id="tab_demo" class="HuiTab">
        	<!--导航条信息-->
            <div class="tabBar clearfix">
                <a href="showEmployees"><span>基础信息</span></a>
                <a href="showCompany"><span>系统管理</span></a>
                <a href="stockOrderShow"><span>采购管理</span></a>
                <a href="showSell"><span>销售管理</span>
                <span class="current">库存管理</span> 
            </div>
            <!--库存管理侧边栏 -->
            <div class="tabCon fl" id="col5" style="display:block">
                <ul id="Huifold1" class="Huifold" >
                    <li class="item">
                    	<h4><a>入库管理</a></h4>
                    </li>
                    <li class="item">
                    	<h4><a>出库管理</a></h4>
                    </li>
                </ul>
            </div>
     		<!--基础信息内容（若对应模块下有二级菜单，需要自行添加） -->
            <div class="right fl"><!-- 销售订单 -->
            	<div class="div-application">
                    <div class="div-title">入库管理信息</div>
                    <div class="div-table">
                        <!--***********************************************************************************************-->
                        
                        <iframe style="position:relative" src="storagein.jsp" height="800px" width="1000px" frameborder="0" scrolling="no"></iframe>
                    </div>
                </div><!--end div-application-->
            </div><!--end of right fl-->
            <div class="right fl"><!-- 销售出库 -->
           	 	<div class="div-application">
                    <div class="div-title">出库管理信息</div>
                    <div class="div-table">
                        <!--***********************************************************************************************-->
                        <iframe style="position:relative" src="storageout.jsp" height="800px" width="1000px" frameborder="0" scrolling="no"></iframe>
                    </div>
                </div><!--end div-application-->
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
          document.getElementById("col5").style.height=colHeight+"px";
      </script>
    </body>
</html>