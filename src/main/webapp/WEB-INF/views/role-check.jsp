<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="frame/common.jsp" %>
<html lang="en">
<head>
    <title>Manitto | Check Your Role</title>
    <script src="<c:url value="/static/js/role-check.js"/>"></script>
</head>
<body>
<h2>role check page</h2>
<button id="check-btn">역할 확인 버튼</button>
<div id="role-result">
</div>
<div>
    <button id="main-btn" hidden>메인페이지 이동</button>
</div>
</body>
</html>