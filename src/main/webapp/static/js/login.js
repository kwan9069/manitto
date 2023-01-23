$(() => {
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
                location.replace("main")
            })
            .fail((xhr, status, error) => {
                alert("로그인 실패")
                console.log(error)
            })
    })
})