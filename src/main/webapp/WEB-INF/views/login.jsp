<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="frame/common.jsp" %>
<html>
<head>
    <title>Manitto | Login</title>
    <script src="<c:url value="/static/js/login.js"/>"></script>
</head>
<body>
<jsp:include page="frame/header.jsp"/>
<div class="layout bg-bottom bg-no-repeat align-middle flex justify-center"
     style="background-image: url('http://nateonweb.nate.com/imgbbs/1/20160805/_20160805140340_%C7%D1%C1%A41.gif')">
    <div class="w-1/2 mt-40">

	<form id="login-form">
	    <label for="username">아이디 : </label><input class="input" type="text" id="username" name="username"> <br>
	    <label for="password">비밀번호 : </label><input class="input" type="password" id="password" name="password"><br>
	    <button id="login-btn">로그인</button>
	</form>
       
    </div>
</div>
<jsp:include page="frame/footer.jsp"/>
</body>
</html>
