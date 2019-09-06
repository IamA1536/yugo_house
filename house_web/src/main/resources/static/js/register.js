// 检查是否为空
function isEmpty( id ) {
    var temp = $('[name='+id+']').val();
    if (temp=="") {
        console.log(id+" is empty");
        $('#'+id).addClass('has-error');
        $('[name='+id+']').focus();
        return true;
    }
    else {
        $('#'+id).removeClass('has-error');
        return false;
    }
}

function isPswEquel(){
    var password = $('[name=pw]').val();
    var confirmpsw = $('[name=confirmpsw]').val();
    if (password!=confirmpsw){
        $('#confirmpsw').addClass('has-error');
        $('[name=confirmpsw]').focus();
        $('.warning').text("两次密码不一致");
        return false;
    }
    else{
        return true;
    }
}

$(document).ready(function () {
    $("#register_form").on("submit",function (e) {
        e.preventDefault();
        // ajax向后端传值，取到data
        var Emp = isEmpty('username') || isEmpty('address') || isEmpty('tele') || isEmpty('email') || isEmpty('pw') || isEmpty('confirmpsw');
        if(!Emp && isPswEquel()){
            var details = $("#loginForm").serialize();
            $.post('#', details, function(data){
                $('.warning').text(data);
            });
        }
    });
});