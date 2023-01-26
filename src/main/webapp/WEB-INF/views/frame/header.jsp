<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="<c:url value="/static/js/header.js"/>"></script>
</head>
<body>
	<a href="/"> 홈</a>
	<% if(session.getAttribute("info") != null){
	 %>
	<a href="/user/login" id="logout" >로그아웃</a>
	 <%
	 }
	 %>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#logout").on("click", function(){
			<% session.removeAttribute("info");%>
			alert("로그아웃");
		})
	});
	</script>

</body>
</html>