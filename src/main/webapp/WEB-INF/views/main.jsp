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
<div class="bg-yellow-200 h-30 w-1/2 ">
    당신의 역할은 ${ sessionScope.info.role }입니다.</span><br>
    역할에 따라서 <br>
    - none 일때 : 다음 매치를 기대하세요 ! ^^, <br>
    - reciver 일떄 : 당신의 마니또는 randomename 입니다 누군지 찾아볼까요? (정답 맞히기 페이지 버튼 ajax 유저리스트 가져오기)<br>
    - contributor : 당신은 ## 의 천사입니다. 미션을 수행하여 보상을 받으세요(Mission 같이)<br>
    <button class="btn" onclick="location.href='match-list'">매치 리스트 가기</button>
    <button class="btn" onclick="">마니또 맞히기(유저리스트 보기)  버튼</button>
</div>
</div>
<jsp:include page="frame/footer.jsp"/>
</body>
</html>