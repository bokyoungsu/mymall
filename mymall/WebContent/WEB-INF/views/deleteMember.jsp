<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete member</title>
</head>
<body>
	<h2>회원탈퇴화면 ..</h2>
	<form action="${pageContext.request.contextPath}/DeleteMemberController" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" /></td>
			</tr>
			<tr>
				<td callspan="2"><input type="submit" value="회원탈퇴"/></td>
			</tr>
		</table>
	</form>
</body>
</html>