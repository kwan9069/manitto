$(() => {
    $.ajax({
        url: "/api/user-match/receiver",
        method: "GET",
        dataType: "json"
    })
        .done((data) => {
            $("#receiver").html(data.name)
        })
        .fail((xhr, status, errorThrown) => {
            alert("로그인이 필요한 서비스 입니다.")
            location.replace("/")
        })

    let getComplete = false;
    $("#name-list-btn").on('click', () => {
        let list = $("#name-list")
        if (!getComplete){
            $.ajax({
                url: "/api/user/list",
                method: "GET",
                dataType: "json"
            })
                .done((data) => {
                    data.forEach((user) => {
                        // list.append(JSON.stringify(user) + "<br>")
                        list.append(user.randomName + "<br>")
                    })
                    getComplete = true
                })
        } else {
            list.toggle()
        }
    })


})