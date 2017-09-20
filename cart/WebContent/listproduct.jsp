<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="/js/jquery.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
$(function(){

	$("input.addCartButton").removeAttr("disabled");
	$("input.addCartButton").click(function(){
		$(this).attr("disabled","disabled");
		var button = $(this);
		var pid = $(this).attr("pid");
		var number = $("input.number[pid="+pid+"]").val();
		var page = "/addOrderItem";
	       $.get(
	           page,
	           {"num":number,"pid":pid},
	           function(result){
	        	   $("#addCartSuccessMessage").fadeIn(1200);
	        	   $("#addCartSuccessMessage").fadeOut(1200,function(){
	        		   button.removeAttr("disabled") ;   
	        	   });
	        	   
	        	   
	           }
	       );
		
	});

	$("#addCartSuccessMessage").hide();

	});
</script>

<c:if test="${!empty user}">
		<div>
			用户：${user.getName()}已登入
		</div>
</c:if>

<div  align="center" style="height:20px;margin:20px;" >
	<span style="color:Chartreuse" id="addCartSuccessMessage">加入购物车成功</span> 
</div>

<table align="center" border="1" cellspacing="0">
	<thead>
		<tr>
			<td>id</td>
			<td>名称</td>
			<td>价格</td>
			<td>购买</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${products}" var="product" varStatus="st">
		<tr>
			<td>${product.getId()}</td>
			<td>${product.getName()}</td>
			<td>${product.getPrice()}</td>
			<td>
			<form action="addOrderItem" method="post">
			数量<input type="text" value="1" name="number"/>
			<input type="hidden" name="pid" value="${product.getId()}"/>
			<input type="submit" value="购买"/> 
			</form>
			</td>
		</tr>
		</c:forEach>
		<tr>
    		<td colspan="4"><a href="/listOrderItem">查看购物车</a></td>
    	
    	</tr>
		
	</tbody>
</table>