<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="frame/common.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manitto | Welcome</title>
    <script>
        $(() => {
            $("#logout-btn").on('click', () => {
                $.ajax({
                    url: "/api/user/logout",
                    method: "GET",
                    dataType: "text"
                })
                    .done(() => {
                        alert("로그아웃 되었습니다.₩")
                        location.reload()
                    })
            })
        })
    </script>
</head>
<body>
<jsp:include page="frame/header.jsp"/>
<div class="layout bg-bottom bg-no-repeat align-middle flex justify-center"
     style="background-image: url('http://nateonweb.nate.com/imgbbs/1/20160805/_20160805140340_%C7%D1%C1%A41.gif')">
    <div class="w-1/2 mt-40">
        <c:if test="${ sessionScope.info == null }">
            <button onclick="location.href='/user/login'" class="btn w-full block">로그인 하기</button>
            <button onclick="location.href='/user/register'" class="btn w-full block">회원가입 하기</button>

        </c:if>
        <c:if test="${ sessionScope.info != null }">
            <button onclick="location.href='/user/main'" class="btn w-full block">메인 페이지</button>
            <button id="logout-btn" class="btn w-full block">로그아웃</button>
        </c:if>
    </div>
</div>
<jsp:include page="frame/footer.jsp"/>
</body>

</html>