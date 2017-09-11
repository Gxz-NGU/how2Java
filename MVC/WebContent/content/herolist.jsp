<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1" align="center">
	<tr>
		<td>count</td>
		<td>name</td>
		<td>hp</td>
		<td>damage</td>
		<td>delete</td>
	</tr>
	<c:forEach items="${heros}" var="hero" varStatus="st">
		<tr>
			<td>${st.count }</td>
			<td>${hero.getName() }</td>
			<td>${hero.getHp() }</td>
			<td>${hero.getDamage() }</td>
			<td><a href="deletehero?id=${hero.getId() }">delete</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="6" align="center">
			<a href="herolist?start=0">[首页]</a>
			<a href="herolist?start=${pre }">[上一页]</a>
			<a href="herolist?start=${next }">[下一页]</a>
			<a href="herolist?start=${last }">[末页]</a>
		</td>
	</tr>
</table>
<%--<%request.getRequestDispatcher("Login.html").forward(request, response ); --%>

<%--<%response.sendRedirect("content/Login.html"); --%>
















