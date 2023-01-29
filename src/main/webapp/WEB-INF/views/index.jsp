<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="frame/common.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manitto | Welcome</title>
    <script src="/static/js/index.js"></script>
</head>
<body>
<jsp:include page="frame/header.jsp"/>
<div class="body-layout"
     style="background-image: url('http://nateonweb.nate.com/imgbbs/1/20160805/_20160805140340_%C7%D1%C1%A41.gif')">
    <div class="w-1/2 grid grid-cols-2">
        <c:if test="${ sessionScope.info == null }">
            <div class="m-2">
                <button id="login-mode-btn" class="normal-btn">로그인 하기</button>
            </div>
            <div class="m-2">
                <button id="register-mode-btn" class="normal-btn">회원가입 하기</button>
            </div>
        </c:if>
        <c:if test="${ sessionScope.info != null }">
            <div class="m-2 col-span-2">

            </div>
            <div class="m-2 col-span-2">
                <button onclick="location.href='/user/main'" class="normal-btn w-1/2 mx-auto block">메인페이지</button>
                <button id="logout-btn" class="normal-btn w-1/2 mx-auto block">로그아웃</button>
            </div>
        </c:if>
        <c:if test="${ sessionScope.info == null }">
            <div id="form-area" class="col-span-2 opacity-75 animate-fade-in-down">
                <form id="login-form" class="animate-fade-in-down">
                    <p style="font-family: 'NanumMiRaeNaMu';" class="mb-4 text-2xl">마니또 매칭에 참여하시겠습니까 ? </p>
                    <div class="mb-4">
                        <input
                                type="text"
                                class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                id="username"
                                name="username"
                                placeholder="Username"
                        />
                    </div>
                    <div class="mb-4">
                        <input
                                type="password"
                                class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                id="password"
                                name="password"
                                placeholder="Password"
                        />
                    </div>
                    <div class="text-center pt-1 mb-12 pb-1">
                        <button
                                id="login-btn"
                                class="btn"
                                type="button"
                                style="
                        background: linear-gradient(
                          to right,
                          #ee7724,
                          #d8363a,
                          #dd3675,
                          #b44593
                        );
                      "
                        >
                            로그인
                        </button>
                    </div>
                </form>
            </div>
        </c:if>
        <div id="form-area" class="col-span-2 opacity-75">
        </div>
        <div class="col-span-2"></div>
    </div>
</div>
<jsp:include page="frame/footer.jsp"/>
</body>

</html>