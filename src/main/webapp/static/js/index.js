$(() => {
    $("#logout-btn").on('click', () => {
        $.ajax({
            url: "/api/user/logout",
            method: "GET",
            dataType: "text"
        })
            .done(() => {
                alert("로그아웃 되었습니다.")
                location.reload()
            })
    })
    $("#login-btn").on('click', (event) => {
        event.preventDefault()
        $.ajax({
            url: "/api/user/login",
            method: "POST",
            data: $("#login-form").serialize(),
            dataType: "text",
            contentType: 'application/x-www-form-urlencoded'
        })
            .done(() => {
                alert("로그인 성공")
                location.replace("/user/main")
            })
            .fail((xhr, status, error) => {
                alert("로그인 실패")
                console.log(error)
            })
    })
    $("#login-mode-btn").on('click', () => {
        $("#form-area").html(`<form id="login-form" class="animate-fade-in-down">
                <p style="font-family: 'NanumMiRaeNaMu';" class="mb-4 text-2xl">마니또 매칭에 참여하시겠습니까 ? </p>
                <div class="mb-4">
                    <input
                            type="text"
                            class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                            id="username"
                            name="username"
                            placeholder="아이디"
                    />
                </div>
                <div class="mb-4">
                    <input
                            type="password"
                            class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                            id="password"
                            name="password"
                            placeholder="비밀번호"
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
            </form>`)
        $("#login-btn").on('click', (event) => {
            event.preventDefault()
            $.ajax({
                url: "/api/user/login",
                method: "POST",
                data: $("#login-form").serialize(),
                dataType: "text",
                contentType: 'application/x-www-form-urlencoded'
            })
                .done(() => {
                    alert("로그인 성공")
                    location.replace("user/main")
                })
                .fail((xhr, status, error) => {
                    alert("로그인 실패")
                    console.log(error)
                })
        })
    })
    $("#register-mode-btn").on('click', () => {
        $("#form-area").html(`<form id="register-form" class="animate-fade-in-down">
                <p style="font-family: 'NanumMiRaeNaMu';" class="mb-4 text-2xl"> 너를 좋아해 마니.. 회원가입 해줄래? </p>
                <div class="mb-4">
                    <input
                            type="text"
                            class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                            id="username"
                            name="username"
                            placeholder="아이디"
                    />
                </div>
                <div class="mb-4">
                    <input
                            type="password"
                            class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                            id="password"
                            name="password"
                            placeholder="패스워드"
                    />
                </div>
                <div class="mb-4">
                    <input
                            type="text"
                            class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                            id="name"
                            name="name"
                            placeholder="이름"
                    />
                </div>
                <div class="mb-4">
                    <input
                            type="email"
                            class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                            id="email"
                            name="email"
                            placeholder="이메일"
                    />
                </div>
                <div class="text-center pt-1 mb-12 pb-1">
                    <button
                            id="register-btn"
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
                        회원가입
                    </button>
                </div>
            </form>`)
        $("#register-btn").on('click', (event) => {
            event.preventDefault()
            $.ajax({
                url: "/api/user",
                method: "POST",
                data: $("#register-form").serialize(),
                dataType: "text",
                contentType: 'application/x-www-form-urlencoded'
            })
                .done(() => {
                    alert("회원가입 완료")
                    location.replace("")
                })
                .fail((xhr, status, error) => {
                    alert("회원가입 실패")
                    console.log(error)
                })
        })
    })

})