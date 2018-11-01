<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<c:if test="${loginMember != null}">
	<a href = "LogoutMemberController">로그아웃</a>
	<a href = "ModifyMemberController?id=${loginMember}">정보수정</a><br>
	<a href = "GetMemberController?id=${loginMember}">${loginMember}</a>님 ${memberLevel}권한으로 로그인..
	<a href = "ItemListController">상품조회</a>
    <a href = "DeleteMemberController">회원탈퇴</a>
	
	</c:if>
	<c:if test="${loginMember == null}">
		<a href = "LoginMemberController">로그인</a>
	</c:if>
	<br>
	<a href="${pageContext.request.contextPath}/AddMemberController">회원가입</a>
</body>
</html>