<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="frame/common.jsp" %>
<html>
<head>
    <title>Manitto | Login</title>
    <script src="<c:url value="/static/js/login.js"/>"></script>
</head>
<body>
<form id="login-form">
    <label for="username">아이디 : </label><input type="text" id="username" name="username"> <br>
    <label for="password">비밀번호 : </label><input type="password" id="password" name="password"><br>
    <button id="login-btn">로그인</button>
</form>
</body>
</html>
