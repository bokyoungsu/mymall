<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주문목록</h2>
	<form action="">
		<table border="1">
			<tr>
				<td>memberItem NO</td><td>ItemNo</td><td>itemName</td><td>itemPrice</td><td>oderDate</td>
			</tr>
			<tr>
				<c:forEach var ="list" items="${list}">		
					<td align="center">${list.no}</td>
					<td align="center">${list.item_no}</td>
					<td align="center">${list.name}</td>
					<td align="center">${list.price}</td>
					<td align="center">${list.order_date}</td>
			</tr>
				</c:forEach>
			<tr>
				<td colspan = "5" align="center">
				<c:if test="${page.prevPage}">
					<a href="${pageContext.request.contextPath}/OrderListController?pageNum=(${page.getStartPage()-1})"><</a>
				</c:if>
				<c:forEach var="i" begin="${page.getStartPage()}" end="${page.getEndPage()}">
					<c:if test="${page.getPageNum() == i}">
						${i}
					</c:if>
					<c:if test="${page.getPageNum() != i}">
						<a href="${pageContext.request.contextPath}/OrderListController?pageNum=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<c:if test="${page.nextPage}">
					<a href="${pageContext.request.contextPath}/OrderListController?pageNum=(${page.getEndPage()+1})">></a>
				</c:if>
			</tr>				
		</table>
	</form>
</body>
</html>