<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="frame/common.jsp" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/static/js/register.js"/>"></script>
</head>
<body>
<jsp:include page="frame/header.jsp" /><br>
<div>
    <form id="register-form">
        <label for="username">아이디 : </label><input type="text" id="username" name="username"> <br>
        <label for="password">비밀번호 : </label><input type="password" id="password" name="password"><br>
        <label for="name">이름</label><input type="text" id="name" name="name"><br>
        <label for="email">이메일</label><input type="email" id="email" name="email"><br>
        <button id="register-btn">회원가입</button>
    </form>
</div>
</body>
</html>

