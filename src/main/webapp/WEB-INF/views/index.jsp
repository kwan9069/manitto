<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="frame/common.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manitto | Welcome</title>
</head>
<body>
<h2>시작페이지</h2>
<c:if test="${ sessionScope.info == null }" >
    <a href="/user/login">로그인</a><br>
    <a href="/user/register">회원가입</a>
</c:if>
<c:if test="${ sessionScope.info != null }" >
    <a href="/user/main">메인페이지</a><br>
</c:if>
</body>
</html>