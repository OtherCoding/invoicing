// JavaScript Document
//日期插件

/*修改销售单*/
$(function(){
	$("#editorform-sell").hide();
	$(".alter").each(function(index) {
        $(this).on('click',function(event){
			//alert(index)
			event.stopPropagation();//阻止冒泡
			$("#editorform-sell").show();
			//$alterParent=$(".alterTbody").eq(index)
			//alert($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq(2).text())
			$(".alterBox .row ").each(function(){
				var $index=$(this).index();		
				$(this).find(".input-text").val($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq($index).text());	
				$(this).find(".input-hidden").val($(".alter").eq(index).parents(".alterTr").find('.alterInput').val());
			});
		});
    });
	$("#editorSellSubmit").click(function(){
		return confirm("是否确认修改？");
	});
	$(".div-application:not(#editorform-sell > div)").click(function(){
		$("#editorform-sell").hide();
	});
});

/*修改销售出库单*/
$(function(){
	$("#editorform-sellOutHouse").hide();
	$(".alter").each(function(index) {
        $(this).on('click',function(event){
			//alert(index)
			event.stopPropagation();//阻止冒泡
			$("#editorform-sellOutHouse").show();
			//$alterParent=$(".alterTbody").eq(index)
			//alert($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq(2).text())
			$(".alterBox .row ").each(function(){
				var $index=$(this).index();		
				$(this).find(".input-text").val($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq($index).text());	
				$(this).find(".input-hidden").val($(".alter").eq(index).parents(".alterTr").find('.alterInput').val());
			});
		});
    });
	$("#editorSellOutHouseSubmit").click(function(){
		return confirm("是否确认修改？");
	});
	$(".div-application:not(#editorform-sellOutHouse > div)").click(function(){
		$("#editorform-sellOutHouse").hide();
	});
});

/*修改退货单*/
$(function(){
	$("#editorform-sellBackHouse").hide();
	$(".alter").each(function(index) {
        $(this).on('click',function(event){
			//alert(index)
			event.stopPropagation();//阻止冒泡
			$("#editorform-sellBackHouse").show();
			//$alterParent=$(".alterTbody").eq(index)
			//alert($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq(2).text())
			$(".alterBox .row ").each(function(){
				var $index=$(this).index();		
				$(this).find(".input-text").val($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq($index).text());	
				$(this).find(".input-hidden").val($(".alter").eq(index).parents(".alterTr").find('.alterInput').val());
			});
		});
    });
	$("#editorSellBackHouseSubmit").click(function(){
		return confirm("是否确认修改？");
	});
	$(".div-application:not(#editorform-sellBackHouse > div)").click(function(){
		$("#editorform-sellBackHouse").hide();
	});
});

/*修改收款单*/
$(function(){
	$("#editorform-getMoney").hide();
	$(".alter").each(function(index) {
        $(this).on('click',function(event){
			//alert(index)
			event.stopPropagation();//阻止冒泡
			$("#editorform-getMoney").show();
			//$alterParent=$(".alterTbody").eq(index)
			//alert($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq(2).text())
			$(".alterBox .row ").each(function(){
				var $index=$(this).index();		
				$(this).find(".input-text").val($(".alter").eq(index).parents(".alterTr").find('.alterTd').eq($index).text());	
				$(this).find(".input-hidden").val($(".alter").eq(index).parents(".alterTr").find('.alterInput').val());
			});
		});
    });
	$("#editorGetMoneySubmit").click(function(){
		return confirm("是否确认修改？");
	});
	$(".div-application:not(#editorform-getMoney > div)").click(function(){
		$("#editorform-getMoney").hide();
	});
});





