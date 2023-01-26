<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../frame/header.jsp" /><br>
<h1>전체 회원 정보를 가져옵니다. </h1>
<c:forEach items="${userList}" var="member">
${member.id } : ${member.username } :${member.name } : ${member.randomName } : ${member.role }: ${member.awareRole } : ${member.isAdmin} <br> 
</c:forEach>
</body>
</html>