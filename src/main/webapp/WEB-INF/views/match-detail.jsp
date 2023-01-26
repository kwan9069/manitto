<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="frame/common.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="<c:url value="/static/js/comment.js"/>"></script>
    <title>Manitto | </title>
</head>
<body>
<jsp:include page="frame/header.jsp"/>
<div class="layout bg-bottom bg-no-repeat align-middle flex justify-center"
     style="">
    <div>
    - 매치 자세정보들(매치 DTo에 해당하는 모든 내용들을 적절하게 배치)<br>
    <c:choose>
    <c:when test="${sessionScope.info.role eq 'none'}">   </c:when>
    <c:when test="${sessionScope.info.role eq 'receiver'}">  <button></button> </c:when>
    <c:when test="${sessionScope.info.role eq 'contributor'}">   </c:when>
    </c:choose>
    
    - none 일때 : <br>
    - reciver 일떄 : (정답 맞히기 페이지 버튼 ajax 유저리스트 가져오기)<br>
    - contributor : 당신은 ## 의 천사입니다. 미션을 수행하여 보상을 받으세요(Mission 같이)<br>
    
    - 코멘트 필요(코멘트 폼)
    - 코멘트 리스트(페이지))
    </div>
    <br>
	<div>
    <form id="commnet-form">
    <input type="text" id="content" name="content"> 
    <input type="hidden" id="userId" name="userId" value="${sesseionScope.info.id }">
    <!-- request.setAttribute("matchId","matchId")  match 테이블 id값-->
    <input type="hidden" id="matchId" name="matchId" value="${match.id }">
  	 ${sesseionScope.info.random_name }
    <input type="hidden" id="writer" name="writer" value="${sesseionScope.info.random_name }">
    
    <input type="submit" id="comment-btn" value="등록">
    </form>
 	</div>
 	
	
	
</div>
    
     
<jsp:include page="frame/footer.jsp"/>
</body>
</html>