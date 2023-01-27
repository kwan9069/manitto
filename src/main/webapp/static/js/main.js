$(() => {
    $.ajax({
        url: "/api/user/receiver",
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

    $.ajax({
        url: "/api/user-match",
        method: "GET",
        dataType: "json"
    })
        .done((data) => {
            if (data.result === true) {
                $("#name-list-btn").attr({
                    class: "normal-btn bg-green-400 hover:bg-green-400",
                    disabled: true
                }).html("마니또를 찾으셨습니다!!")
                $("#info").append(`<br class="mt-2 "> 나의 마니또 : ${data.name} (${data.randomName})`)
            }
            if (data.result === false) {
                $("#name-list-btn").attr({
                    class: "normal-btn bg-red-400 hover:bg-red-400",
                    disabled: true
                }).html("나의 마니또를 찾지 못했습니다 T^T")
                $("#info").append(`<br class="mt-2 "> 나의 마니또 : ${data.name} (${data.randomName})`)
            }
        })

    let getCompleteNames = false;
    $("#name-list-btn").on('click', () => {
        let list = $("#name-list")
        if (!getCompleteNames) {
            $.ajax({
                url: "/api/user/list",
                method: "GET",
                dataType: "json",
                cache: false
            })
                .done((data) => {
                    data.forEach((user) => {
                        $(document).on('click', `#${user.id}`, () => {
                            if (confirm("기회는 한번뿐, 정말로 선택하시겠어요?")) {
                                $.ajax({
                                    url: "/api/user/contributor/" + user.id,
                                    method: "PUT",
                                    dataType: "json",
                                    contentType: "application/json; charset=utf-8",
                                })
                                    .done((data) => {
                                        if (data.id === user.id) {
                                            alert("축하합니다 오늘의 나의 마니또를 찾았어요!")
                                        } else {
                                            alert("아쉽게도 마니또를 찾지 못했습니다 😂")
                                        }
                                        location.reload()
                                    })
                            } else {
                                alert("다시 한번 신중하게 고민 !!")
                            }
                        })
                        list.append(`<div id="${user.id}" class="overflow-x-scroll p-2 m-2 bg-green-100 block hover hover:bg-green-200 cursor-pointer">${user.name}</div>`)
                    })
                    getCompleteNames = true
                })
        } else {
            list.toggle()
        }
    })

    let getCompleteMatches = false;
    $("#match-list-btn").on('click', () => {
        let list = $("#match-list")
        if (!getCompleteMatches) {
            $.ajax({
                url: "/api/match/list",
                method: "GET",
                dataType: "json",
                cache: false
            })
                .done((data) => {
                    data.forEach((match) => {
                        list.append(`<div id="${match.id}" onclick="location.href='/user/match-detail/${match.id}'"  class=" overflow-x-scroll p-2 m-2 bg-blue-100 block hover hover:bg-blue-200 cursor-pointer">${match.id} 회차 ${match.title}</div>`)
                    })
                    getCompleteMatches = true
                })
        } else {
            list.toggle()
        }
    })

    let getCompleteMissions = false
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