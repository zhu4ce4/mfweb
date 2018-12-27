function GetPage() {
    //将$.ajax做成方法并命名为doAjax以便调用，调用时提供参数demand
    this.doAjax = function (demand) {
        $.ajax({
            url: "/userProfile/getTaoLunList",
            type: "get",
            async: false,
            data: {"demand": demand,"author": author},

            success: function (results) {
                //此处应该使用ajax较好地实现免刷新页面刷新数据，用thymeleaf会刷新页面
                // if (getResult === "success") {
                //     window.location.href = "/taoLun/showTLList";
                // $("#jianyineirong").attr("action", "/taoLun/showTLList");
                //     alert(20181220);
                // }
                // $("#toRegister").css("display", "none");
                // $("#beforeLogin").attr("href", "userProfile"++".html");
                var length = results.length;
                for (var i = 0; i < length; i++) {
                    var tl = results[i];
                    //todo:在标题上面加上该文章的链接
                    $("#tlTitle" + i).html("<a href='taoLun/tlContent/" + tl.id + "'>" + tl.title + "</a>");
                }
                if (length < 5) {
                    for (var j = 0; j < (5 - length); j++) {
                        var newj = j + length;
                        $("#tlTitle" + newj).html("<span>&nbsp;</span>");
                    }
                }
            },
            error: function (err) {
                for (var i = 0; i < 5; i++) {
                    $("#title" + i).html("私密版块");
                    $("#message" + i).html("请注册登录或稍后再试！");
                    $("#author" + i).html("私密版块");
                }
            }
        })
    }
}


var page = new GetPage();
$(page.doAjax("newestFive"));

$("#firstPage").on("click", function () {
    page.doAjax("newestFive");
});

$("#lastPage").on("click", function () {
    page.doAjax("lastFive");
});
$("#nextPage").on("click", function () {
    page.doAjax("nextFive");
});
