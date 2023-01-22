$(() => {
    $("#register-btn").on('click', () => {
        let creteDto = {
            username: $("#username").val(),
            password: $("#password").val(),
            name: $("#name").val(),
            email: $("#email").val()
        }
        $.ajax({
            url: "/api/user",
            data: creteDto.serialize(),
            method: "POST",
            dataType: "json"
        })
            .done((body) => {
                alert("회원가입 완료")
                location.replace("user/login")
            })
            .fail((xhr, status, error) => {
                alert("회원가입 실패")
            })
    })
})