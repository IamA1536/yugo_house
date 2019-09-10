$(document).ready(function(){
    $("#search_new").on( "click",function () {
        $("#search_new").attr("class", "active_home");
        $("#search_old").attr("class","search_option");
        $("#search_rent").attr("class","search_option");
        $("#search_decoration").attr("class","search_option");
        //这里应该是给搜索添加一个参数而不是指向不同路径
        $("#search_form").attr("action","/search");
    });
    $("#search_old").on( "click",function () {
        $("#search_old").attr("class", "active_home");
        $("#search_new").attr("class","search_option");
        $("#search_rent").attr("class","search_option");
        $("#search_decoration").attr("class","search_option");
        $("#search_form").attr("action","/search");
    });
    $("#search_rent").on( "click",function () {
        $("#search_rent").attr("class", "active_home");
        $("#search_new").attr("class","search_option");
        $("#search_old").attr("class","search_option");
        $("#search_decoration").attr("class","search_option");
        $("#search_form").attr("action","/search");
    });
    $("#search_decoration").on( "click",function () {
        $("#search_decoration").attr("class", "active_home");
        $("#search_new").attr("class","search_option");
        $("#search_old").attr("class","search_option");
        $("#search_rent").attr("class","search_option");
        $("#search_form").attr("action","/search");
    });
});
