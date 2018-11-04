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
				</c:forEach>
			</tr>			
		</table>
	</form>
</body>
</html>