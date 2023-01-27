<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="frame/common.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="<c:url value="/static/js/comment.js"/>"></script>
    <script>
        $(() => {
            $.ajax({
                url: "/api/comment/${ receiverInfo.matchId }",
                method: "GET",
                dataType: "json"
            })
                .done((data) => {
                    let list = $("#commentlist")
                    data.forEach(comment => {
                        list.append(`<div id="${"${comment.writer}"}" class="overflow-x-scroll p-2 m-2 bg-pink-100 block hover hover:bg-pink-200 cursor-pointer">${"${comment.content}"}"</div>`)
                    })
                })
        })
    </script>
    <title>Manitto | Match Detail</title>
</head>
<body>
<jsp:include page="frame/header.jsp"/>
<c:set var="confributorInfo" value="${ contributorInfo }"/>
<c:set var="receiverInfo" value="${ receiverInfo }"/>

<c:choose>
    <c:when test="${ sessionScope.info.role eq 'receiver' && sessionScope.info.id eq receiverInfo.id }">
        <c:set var="role" value="receiver"/>
    </c:when>
    <c:when test="${ sessionScope.info.role eq 'contributor' && sessionScope.info.id eq confributorInfo.id }">
        <c:set var="role" value="contributor"/>
    </c:when>
    <c:otherwise>
        <c:set var="role" value="none"/>
    </c:otherwise>
</c:choose>

<div class="body-layout"
     style="background-image: url('https://cdn.clien.net/web/api/file/F01/5855604/31516dd6c9ec7.gif?w=390&h=30000&gif=true&thumb=true')">

    <div class="w-1/2 grid grid-cols-2">
        <div class="col-span-2">
            <div id="info" class=" text-3xl" style="font-family: 'NanumMyeongjoBold';">
                ${ receiverInfo.randomName } 님과 <br>${ confributorInfo.randomName } 님의 마니또 😍
            </div>
        </div>
        <div class="col-span-2 text-4xl" style="font-family: 'NanumNeuRisNeuRisCe';">
            <c:if test="${ role eq 'none' }">
                당신은 오늘 마니또가 아니에요 🥹<br>
                그래도 댓글로 익명의 상대와 소통해봐요 !
            </c:if>
            <c:if test="${ role eq 'receiver' }">
                당신의 마니또가 있어요 😊 <br>
                오늘의 당신만의 천사를 찾아보세요 !!
            </c:if>
            <c:if test="${ role eq 'contributor' }">
                당신의 마니또가 있어요 😊 <br>
                오늘은 당신이 '${ receiverInfo.name }' 님의 천사💕!!
            </c:if>
        </div>
        <div class="col-span-2">
            <form id="comment-form">
                <input type="hidden" id="userId" name="userId" value="${sessionScope.info.id }">
                <input type="hidden" id="matchId" name="matchId" value="${receiverInfo.matchId }">
                <input type="hidden" id="writer" name="writer" value="${sessionScope.info.randomName }">
                <input class="form-control w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                       rows="2" cols="50" id="content" name="content" placeholder="코멘트... 무플방지!!">
                <button id="comment-btn" class="normal-btn">등록</button>

            </form>
        </div>
        <div id="commentlist" class="m-2 opacity-75">

        </div>
    </div>
</div>
<jsp:include page="frame/footer.jsp"/>
</body>
</html>