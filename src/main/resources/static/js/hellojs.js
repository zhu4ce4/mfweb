$($.ajax({
    url: "/onlineNumber",
    type: "get",
    async: false,
    success: function (data) {
        alert(data);
        $("#OnlineNumber").html(data);
    }
}));

//准备随机验证码用于调用
function codeConfirm() {
    var generConfirmCode = Math.round(Math.random() * 8999 + 1000);
    $("#randomCode").val(generConfirmCode);
    // $("#randomCode").html(generConfirmCode);
}

//页面准备完成后调用上述函数,注意此处可以不用括号
$(codeConfirm());

function getResult() {
    var first = parseFloat(document.getElementById('first').value); //获取到的是string需要转换!
    var second = parseFloat(document.getElementById('second').value);

    var selected = document.getElementById('mym');
    var index = selected.selectedIndex;
    var option = selected.options[index].value;

    if (isNaN(first) || isNaN(second)) {
        alert("请输入数据后再计算!");
        return;
    }
    if (option === "add") {
        document.getElementById('result').value = first + second;   //此处必须是一个动作!
    } else if (option === "minus") {
        document.getElementById('result').value = first - second;
    } else if (option === "multiply") {
        document.getElementById('result').value = first * second;
    } else if (option === "divided") {
        if (second === 0) {
            alert("除数不能为0，请重新输入");
            return;
        }
        document.getElementById('result').value = first / second;
    }
}

function resetInput() {
    document.getElementById('first').value = '';
    document.getElementById('second').value = '';
    document.getElementById('result').value = '';
}

function compute() {
    var qishimoney = parseFloat(document.getElementById('origin').value);
    var rate = parseFloat(document.getElementById('rate').value);
    var years = parseInt(document.getElementById('years').value);
    var appendmoney = parseFloat(document.getElementById('benjin').value);
    document.getElementById('amountOfBenjin').value = qishimoney + appendmoney * years;

    var benxihe = qishimoney;
    var lixi = 0;
    var lixihe = 0;

    while (years > 0) {
        lixi = (benxihe + appendmoney) * (rate / 100);
        lixihe += lixi;
        benxihe += appendmoney + lixi;
        years--;
    }
    document.getElementById('lixihe').value = lixihe.toFixed(2);
    document.getElementById('benxihe').value = benxihe.toFixed(2);
}

function GetPage() {
    //将$.ajax做成方法并命名为doAjax以便调用，调用时提供参数demand
    this.doAjax = function (demand) {
        $.ajax({
            url: "/taoLun/getTaoLunList",
            type: "get",
            async: false,
            data: {"demand": demand},

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
                    // $("#Person" + i).html("<a href='login.html'>"+tl.name+"</a>");
                    $("#title" + i).html(tl.title);
                    $("#message" + i).html(tl.message);
                    $("#author" + i).html(tl.author);
                }
                if (length < 5) {
                    for (var j = 0; j < (5 - length); j++) {
                        // for (var j = 0; j < 1; j++) {
                        var newj = j + length;
                        $("#title" + newj).html("<span>&nbsp;</span>");
                        $("#message" + newj).html("<span>&nbsp;</span>");
                        $("#author" + newj).html("<span>&nbsp;</span>");
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
//页面加载完成随机调用取最新5条数据方法
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
// 通过new Object创建对象有个问题，就是每创建一个对象，都得重新定义属性和函数。这样代码的重用性不好
// 那么，采用另一种方式，通过function设计一种对象。 然后实例化它 。
// 这种思路很像Java里的设计一种类，但是 javascript没有类，只有对象，所以我们叫设计一种对象
function maValidForm() {
    return $("#jianyineirong").validate({
        rules: {
            title: "required",
            author: "required",
            leavemessage: "required",
            confirmCode: {
                required: true,
                equalTo: "#randomCode"
            }
        },
        messages: {
            title: "请输入标题",
            author: "请输入联系方式或作者名",
            confirmCode: "请输入验证码",
            leavemessage: "请输入内容"
        }
    });
}

$("#postTaoLun").click(function () {
    if (maValidForm().form()) {
        var title = $("#title").val();
        var author = $("#author").val();
        var content = $("#leavemessage").val();
        $.ajax({
            url: "/addTaoLun",
            type: "post",
            async: false,//同步：意思是当有返回值以后才会进行后面的js程序。
            data: {"name": title, "hao": author, "content": content},
            success: function (data) {
                var result = $.parseJSON(data);
                if (result.login === "false") {
                    $("#postTaoLunRes").html("请先注册登录");
                    alert("请先登录！");
                } else {
                    $("#postTaoLunRes").html("发帖成功");
                }
                // window.location.reload();此处不要用反而有问题，不用本行代码页面会自动刷新
            },
            error: function (err) {
                alert("发帖失败");
                $("#logResult").html(err);
                window.location.reload();
            }
        });
    } else {
        alert("提交失败");
        codeConfirm()
    }
});


function printDateTime() {
    var intYears, intMonths, intDays, intHours, intMinutes;
    var today;
    today = new Date(); //系统当前时间
    intYears = today.getFullYear(); //得到年份,getFullYear()比getYear()更普适
    intMonths = today.getMonth() + 1; //得到月份，要加1
    intDays = today.getDate(); //得到日期
    if (intDays < 10) {
        intDays = '0' + intDays;
    }
    intHours = today.getHours(); //得到小时
    if (intHours < 10) {
        intHours = '0' + intHours;
    }
    intMinutes = today.getMinutes(); //得到分钟
    if (intMinutes < 10) {
        intMinutes = '0' + intMinutes;
    }
    // var s = today.getSeconds();
    $('#datetimenow').html("当前：" + intYears + '年' + intMonths + '月' + intDays + '日' + intHours + ':' + intMinutes);
}

//todo:printdatetime后面加上括号只会执行一次，但不加括号，要等到1000*60后才执行第一次
setTimeout(printDateTime, 0);
setInterval(printDateTime, 1000 * 60);
