<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="frame/common.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="/static/js/main.js"></script>
    <title>Manitto | Main</title>
</head>
<body>
<jsp:include page="frame/header.jsp"/>
<div class="layout bg-bottom bg-no-repeat align-middle flex justify-center"
     style="">
    <div class="bg-yellow-200 h-30 max-w-2xl ">
        <c:set var="info" value="${ sessionScope.info }"/>
        <div>
            <c:if test="${ info.role eq 'none' }">
                당신은 오늘 마니또가 아니에요
            </c:if>
            <c:if test="${ info.role eq 'receiver' }">
                당신의 마니또가 있어요 😊 오늘의 당신만의 천사를 찾아보세요 !!
            </c:if>
            <c:if test="${ info.role eq 'contributor' }">
                당신의 마니또가 있어요 😊 오늘은 당신이 <span id="receiver"></span>님의 천사💕!!
            </c:if>
        </div>
        <div id="interact-area">
            <c:if test="${ info.role eq 'receiver' }">
                <button id="name-list-btn" class="btn">나의 마니또는 누구?</button>
                <div id="name-list">

                </div>
            </c:if>
        </div>
        <div>
            <button onclick="location.href='match-list'" class="btn">오늘의 매치리스트 보기</button>
        </div>


        <%--    <div></div>--%>
        <%--    당신의 역할은 ${ sessionScope.info.role }입니다.</span><br>--%>
        <%--    역할에 따라서 <br>--%>
        <%--    - none 일때 : 다음 매치를 기대하세요 ! ^^, <br>--%>
        <%--    - reciver 일떄 : 당신의 마니또는 randomename 입니다 누군지 찾아볼까요? (정답 맞히기 페이지 버튼 ajax 유저리스트 가져오기)<br>--%>
        <%--    - contributor : 당신은 ## 의 천사입니다. 미션을 수행하여 보상을 받으세요(Mission 같이)<br>--%>
        <%--    <button class="btn" onclick="location.href='match-list'">매치 리스트 가기</button>--%>
        <%--    <button class="btn" onclick="">마니또 맞히기(유저리스트 보기)  버튼</button>--%>
    </div>
</div>
<jsp:include page="frame/footer.jsp"/>
</body>
</html>