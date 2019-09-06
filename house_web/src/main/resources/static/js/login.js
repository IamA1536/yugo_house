// 检查用户名是否为空
function isUsernameEmpty() {
    var username = $('[name="username"]').val();
    if (username=="") {
        console.log("username is empty");
        $('#username').addClass('has-error');
        $('.warning').text("请输入用户名");
        $('[name="username"]').focus();
        return true;
    }
    else {
        $('#username').removeClass('has-error');
        return false;
    }
}
// 检查密码是否为空
function isPasswordEmpty(){
    var password = $('[name="password"]').val();
    if (password=="") {
        console.log("password is empty");
        $('#password').addClass('has-error');
        $('.warning').text("请输入密码");
        $('[name="password"]').focus();
        return true;
    }
    else {
        $('#password').removeClass('has-error');
        return false;
    }
}

$(document).ready(function () {
    console.log("ready");
    $('[name="username"]').on('change',function () {
        console.log("you input" + this.value);
        if(!isUsernameEmpty() && !isPasswordEmpty()){
            $('.warning').text("");
        }
    });

    $('[name="password"]').on('change',function () {
        console.log("you input "+ $('[name="password"]').val());
        if(!isUsernameEmpty() && !isPasswordEmpty()){
            $('.warning').text("");
        }
    });

    $("#loginForm").on("submit",function (e) {
        e.preventDefault();
        if(!isUsernameEmpty() && !isPasswordEmpty()){
            var details = $("#loginForm").serialize();
            $.post('#', details, function(data){
                $('.warning').text(data);
            });
        }
    });
});