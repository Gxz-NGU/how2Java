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
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ois}" var="oi" varStatus="st">
		<tr>
			<td>${oi.product.getName()}</td>
			<td>${oi.product.getPrice()}</td>
			<td>${oi.getNumber()}</td>
			<td>${oi.product.getPrice()*oi.getNumber()}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>