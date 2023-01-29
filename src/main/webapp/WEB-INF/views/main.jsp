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
<c:set var="info" value="${ sessionScope.info }"/>

<c:if test="${ info.role eq 'none' }">
    <c:set var="url" value="https://cdn.jjalbot.com/2021/12/vtF-fpufN/vtF-fpufN.gif"/>
    <c:set var="col" value="col-span-2"/>
</c:if>
<c:if test="${ info.role eq 'receiver' }">
    <c:set var="url" value="https://i.pinimg.com/originals/11/bc/3d/11bc3dd3e0f0e369e9b4613ece97fba8.gif"/>
    <c:set var="col" value=""/>
</c:if>
<c:if test="${ info.role eq 'contributor' }">
    <c:set var="url" value="http://4.bp.blogspot.com/-q9D35N0a6Cw/WxqMdNRU4WI/AAAAAAAACp0/Rh6i18z5COcoICFHlGi8h1z7A-E0DHDNQCLcBGAs/s1600/f6ec15dbf1f55fc0fddc8e4626512d33_1528440473_4686.gif"/>
    <c:set var="col" value=""/>
</c:if>
<div class="body-layout"
     style="background-image:url('${ url }')">
    <div class="w-1/2 grid grid-cols-2">
        <div class="col-span-2 text-3xl mt-12" style="font-family: 'NanumMyeongjoBold';">
            <c:if test="${ info.role eq 'none' }">
                당신은 오늘 마니또가 아니에요🤣
            </c:if>
            <c:if test="${ info.role eq 'receiver' }">
                당신의 마니또가 있어요 😊 <br>오늘의 당신만의 천사를 찾아보세요 !!
            </c:if>
            <c:if test="${ info.role eq 'contributor' }">
                당신의 마니또가 있어요 😊 <br>오늘은 당신이 '<span id="receiver"></span>' 님의 천사💕!!
            </c:if>

        </div>
        <c:if test="${ info.role eq 'none' }">
            <div class="col-span-2 h-12"></div>
        </c:if>
        <div id="info" class="col-span-2 text-3xl py-16" style="font-family: 'NanumNeuRisNeuRisCe';">나의 별명 : ${ info.randomName }</div>
        <div class="m-2 opacity-75  ${ col }">
            <button id="match-list-btn" class="normal-btn block">오늘의 매치리스트 보기</button>
            <div id="match-list" class="overflow-y-auto h-64"></div>
        </div>
        <div id="interact-area" class="opacity-75 m-2 h-72">
            <c:if test="${ info.role eq 'receiver' }">
                <button id="name-list-btn" class="normal-btn">나의 마니또는 누구?</button>
                <div id="name-list" class="overflow-y-auto h-64"></div>
            </c:if>
            <c:if test="${ info.role eq 'contributor' }">
                <button id="mission-list-btn" class="normal-btn">나의 미션 리스트</button>
                <div id="mission-list" class="overflow-y-auto h-64"></div>
            </c:if>
        </div>
        <div class="col-span-2"></div>
        <div class="col-span-2"></div>
    </div>
</div>
<jsp:include page="frame/footer.jsp"/>
</body>
</html>