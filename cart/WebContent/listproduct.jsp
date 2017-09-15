<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	</tbody>
</table>