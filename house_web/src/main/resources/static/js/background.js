function clickButton(data) {
    document.getElementById('firstState').style.display='none';
    document.getElementById('secondState').style.display='none';
    document.getElementById('thirdState').style.display='none';
    document.getElementById('fourthState').style.display='none';
    document.getElementById('fifthState').style.display='none';
    document.getElementById('sixthState').style.display='none';
    document.getElementById('seventhState').style.display='none';
    document.getElementById(data+'State').style.display='block';
}
window.onload=function(){
    //日历记事本
    layui
        .extend({
            laydateNote: 'js/layui-notebook'
        })
        .use(['laydateNote'], function() {
            //调用
            let { laydateNote } = layui
            laydateNote({
                elem: '#test-n2', //容器id,CLass
                url: '', //异步数据接口,本地浏览时可不设置
                sort: 'up', //日期排序，默认不设置不排序，up 日期升序，down 日期降序
                done(data) {
                    //回调数据，这里发送你的请求ajax
                    console.log(data)
                }
            })
        });

    // 首页的echart图表
    // 路径配置
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    // 使用
    require(
        [
            'echarts',
            'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加载
            'echarts/chart/line'
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            chartssize(document.getElementById('dataimage'),document.getElementById('linechart'));
            var myChart = ec.init(document.getElementById('linechart'));

            // 为echarts对象加载数据
            window.onresize = myChart.resize;
            myChart.setOption(
                {
                    title : {
                        text: '在线用户数量',
                        subtext: '纯属虚构'
                    },
                    tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['在线人数','最低气温']
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : true,
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            data : ["1","2","3","4","5","6","7","8","9","10"]
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            axisLabel : {
                                formatter: '{value} 人'
                            }
                        }
                    ],
                    series : [
                        {
                            name:'在线人数',
                            type:'line',
                            data: ["22","23","24","15","26","19","28","30","10","6"],
                            markPoint : {
                                data : [
                                    {type : 'max', name: '最大值'},
                                    {type : 'min', name: '最小值'}
                                ]
                            },
                            markLine : {
                                data : [
                                    {type : 'average', name: '平均值'}
                                ]
                            }
                        },
                        {
                            name:'最低气温',
                            type:'line',
                            data:[1, -2, 2, 5, 3, 2, 0, -2, 2, 5, 3, 2],
                            markPoint : {
                                data : [
                                    {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
                                ]
                            },
                            markLine : {
                                data : [
                                    {type : 'average', name : '平均值'}
                                ]
                            }
                        }
                    ]
                }
            );

            // myChart.showLoading(); //数据加载完之前先显示一段简单的loading动画

            var names = [];    //类别数组（实际用来盛放X轴坐标值）
            var nums = [];    //销量数组（实际用来盛放Y坐标值）

            $.ajax({
                url: 'json/data.json',//请求数据的地址
                type: 'get',
                dataType: 'json',        //返回数据形式为json
                // async:true,
                success: function (result) {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    $.each(result.list, function (index, item) {
                        names.push(item.catagory);    //挨个取出类别并填入类别数组                    
                        nums.push(item.data);    //挨个取出销量并填入销量数组
                    });

                    myChart.hideLoading();    //隐藏加载动画
                    myChart.setOption({        //加载数据图表
                        xAxis: {
                            data: names
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '在线人数',  //显示在上部的标题
                            data: nums
                        }]
                    });
                },
                error: function (errorMsg) {
                    //请求失败时执行该函数
                    alert("图表请求数据失败!");
                    myChart.hideLoading();
                }
            });
        }
    );
};
// 视图调整后重新渲染图表
window.addEventListener("resize", function(){
    //首页的图表
    if($('#firstState').css("display")=="block") {
        chartssize(document.getElementById('dataimage'),document.getElementById('linechart'));
        document.getElementById('linechart').resize();
    }
    //数据的图表
    if($('#seventhState').css("display")=="block") {

    }
});
//图表随浏览器变化
function chartssize (container,charts) {
    function getStyle(el, name) {
        if (window.getComputedStyle) {
            return window.getComputedStyle(el, null);
        } else {
            return el.currentStyle;
        }
    }
    var wi = getStyle(container, 'width').width;
    var hi = getStyle(container, 'height').height;
    charts.style.width = wi;
    charts.style.height = hi;
}

