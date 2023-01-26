<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="frame/common.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manitto | Matches</title>
</head>
<body>
<jsp:include page="frame/header.jsp"/>
<div class="layout bg-bottom bg-no-repeat align-middle flex justify-center"
     style="">
    <div class="bg-yellow-200 h-30 w-1/2 ">
       매치 리스트 페이
        <div id="match-list">
            MatchApiController(UserApiController) 의 @GetMapping mathList() 에 매핑되어 매치 리스트를 가져오고 그 정보를 화면에 그기
        </div>
    </div>
</div>
<jsp:include page="frame/footer.jsp"/>
</body>
</html>