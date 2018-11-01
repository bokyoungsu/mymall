<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>login.jsp</h1>
	<form action="LoginMemberController" method ="post">
		<table border = "1">
			<tr>
				<td>id</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="로그인"/></td>
			</tr>
		</table>
	</form>
</body>
</html>