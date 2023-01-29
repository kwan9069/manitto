$(() => {
    $("#check-btn").on('click', () => {
        $.ajax({
            url: "/api/user/role",
            method: "PUT",
            dataType: "text"
        })
            .done((data) => {
                $("#role-result").html(data)
                $("#main-btn").removeAttr("hidden")
            })
        $("#main-btn").on('click', () => {
            console.log("click event")
            location.replace("/user/main")
        })
    })
})