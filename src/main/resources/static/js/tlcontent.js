//准备随机验证码用于调用
function codeConfirm() {
    var generConfirmCode = Math.round(Math.random() * 8999 + 1000);
    $("#randomCode").val(generConfirmCode);
}

$(codeConfirm());

function GetPage() {
    this.doAjax = function (demand) {
        $.ajax({
            url: "/critic/getCriticList",
            type: "get",
            async: false,
            //tlid是在html里用js结合thymeleaf定义的
            data: {"demand": demand, "tlid": tlid},

            success: function (results) {
                var length = results.length;
                for (var i = 0; i < length; i++) {
                    var ct = results[i];
                    $("#criticName" + i).html(ct.criticName);
                    $("#critic" + i).html(ct.critic);
                }
                if (length < 5) {
                    for (var j = 0; j < (5 - length); j++) {
                        var newj = j + length;
                        $("#criticName" + newj).html("<span>&nbsp;</span>");
                        $("#critic" + newj).html("<span>&nbsp;</span>");
                    }
                }
            },
            error: function (err) {
                for (var i = 0; i < 5; i++) {
                    $("#criticName" + i).html("私密版块");
                    $("#critic" + i).html("请注册登录或稍后再试！");
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

function maValidForm() {
    return $("#comment").validate({
        rules: {
            //todo:增加字数限制
            critics: "required",
            confirmCode: {
                required: true,
                equalTo: "#randomCode"
            }
        },
        messages: {
            confirmCode: "请输入验证码",
            critics: "请输入内容"
        }
    });
}

$("#postCritic").click(function () {
    if (maValidForm().form()) {
        var critics = $("#critics").val();
        var data = {tlid: tlid, critic: critics};
        $.ajax({
            url: "/critic/addCritics",
            type: "post",
            async: false,
            cache: false,
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (data) {
                if (data === "unlogged") {
                    $("#postCriticsRes").html("<b style='font: red;'>评论失败！</b>");
                    $("#comment").attr("action", "/login.html");

                } else if (data === "failed") {
                    $("#postCriticsRes").html("<b style='font: red;'>评论失败！</b>");
                    window.location.reload();
                } else {
                    $("#postCriticsRes").html("<b>评论成功!</b>");
                    window.location.reload();
                }
            },
            error: function (err) {
                $("#postCriticsRes").html(err);
                window.location.reload();
            }
        });
    } else {
        codeConfirm()
    }
});
