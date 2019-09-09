$(document).ready(function(){
    //隐藏修改头像框
    $(".black_all").hide();
    //点击修改头像
    $(".my_icon").on("click",function () {
    //    显示修改头像框
        $(".black_all").show();
    });

    //选择图片，头像预览改变
    $("#choose_user_icon").on("change",function(){
        var fileTypes = [".jpg",".png"];
        var filePath = this.value;
        if(filePath) {
            //获取文件
            var file = $("#user_icon_form").find("input")[0].files[0];

            //创建读取文件的对象
            var reader = new FileReader();

            //创建文件读取相关的变量
            var imgFile;

            //为文件读取成功设置事件
            reader.onload = function (e) {
                // alert('文件读取完成');
                imgFile = e.target.result;
                console.log(imgFile);
                $("#user_icon_in_form").attr('src', imgFile);
            };

            //正式读取文件
            reader.readAsDataURL(file);
        }
        // else{
        //         alert('请选择图片，类型为jpg或png');
        //         file.value = '';
        // }
        else{
             alert('请选择图片，类型为jpg或png');
        }
    });
//    点击提交隐藏遮罩和修改头像框，直接在前端改变头像
//    后端没写，阻拦了表单提交
    $("#submit_icon").on("click",function (e) {
        e.preventDefault();
        var imgFile = $("#user_icon_in_form").attr('src');
        $(".my_icon").attr('src', imgFile);
        $(".black_all").hide();
    });

    $("#remove").on("click",function () {
        $(".black_all").hide();
    });
});