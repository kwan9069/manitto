$(() => {
    $("#comment-btn").on('click', (event) => {
        event.preventDefault()
        $.ajax({
            url: "/api/comment/create",
            method: "POST",
            data: $("#comment-form").serialize(),
            dataType: "text",
            contentType: 'application/x-www-form-urlencoded'
        })
            .done(() => {
                alert("등록 완료"+ $("#comment-form").serialize())
                $("#commentlist").html()
            })
            .fail((xhr, status, error) => {
                alert("등록 실패" + $("#comment-form").serialize())
                console.log(error)
            })
    })


    $("#mission-list-btn").on('click', () => {
        let list = $("#mission-list")
        if (!getCompleteMissions) {
            $.ajax({
                url: "/api/action/mission-list",
                method: "GET",
                dataType: "json",
                cache: false
            })
                .done((data) => {
                    data.forEach((action) => {
                        list.append(`<div id="${action.id}" class="overflow-x-scroll p-2 m-2 bg-pink-100 block hover hover:bg-pink-200 cursor-pointer">${action.task}</div>`)
                    })
                    getCompleteMissions = true
                })
        } else {
            list.toggle()
        }
    })
})