<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align="center" border="1" cellspacing="0">
	<thead>
		<tr>
			<td>商品名称</td>
			<td>单价</td>
			<td>数量</td>
			<td>小计</td>
			<td>删除操作</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ois}" var="oi" varStatus="st">
		<tr>
			<td>${oi.product.getName()}</td>
			<td>${oi.product.getPrice()}</td>
			<td>${oi.getNumber()}</td>
			<td>${oi.product.getPrice()*oi.getNumber()}</td>
			<!-- <td><a href="delete?pid=${oi.product.getId()}">删除</a></td> -->
			<td>
				<form action="delete" method="post">
					<input type="hidden" value="${oi.product.getId()}" name="pid"/>
					<input type="submit" value="delete"/>
				</form>
			</td>
		</tr>
		</c:forEach>
		<c:if test="${!empty ois}">
			<tr><td colspan="5" align="right"><a href="createOrder">创建订单</a></td>
			</tr>
		</c:if>
	</tbody>
</table>