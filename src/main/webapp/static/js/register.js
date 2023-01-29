$(() => {
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
                location.replace("login")
            })
            .fail((xhr, status, error) => {
                alert("회원가입 실패")
                console.log(error)
            })
    })
})