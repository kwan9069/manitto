<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="frame/common.jsp" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/static/js/register.js"/>"></script>
</head>
<body>

<jsp:include page="frame/header.jsp"/>
<div class="layout bg-bottom bg-no-repeat align-middle flex justify-center"
     style="background-image: url('http://nateonweb.nate.com/imgbbs/1/20160805/_20160805140340_%C7%D1%C1%A41.gif')">
    <div class="w-1/2 mt-40">
    
    <form id="register-form">
        <label for="username">아이디 : </label><input type="text" id="username" name="username"> <br>
        <label for="password">비밀번호 : </label><input type="password" id="password" name="password"><br>
        <label for="name">이름 : </label><input type="text" id="name" name="name"><br>
        <label for="email">이메일 : </label><input type="email" id="email" name="email"><br>
        <button id="register-btn">회원가입</button>
    </form>
       
    </div>
</div>
<jsp:include page="frame/footer.jsp"/>

</body>
</html>

