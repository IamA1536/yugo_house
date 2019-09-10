(() => {
    const render = ({ elem: container, url = null, sort = 'default', done = () => { } }) => {
        layui.use(['laydate', 'layer', 'jquery'], function () {
            let { laydate, layer, jquery: $ } = layui

            //判断渲染容器
            if (!$(container)[0]) return layer.msg('没有找到渲染容器！', { icon: 0, time: 1000 })

            //获取数据接口
            const getData = (url) => {
                $.ajax({
                    url,
                    success(res) {
                        const { code, data } = res
                        if (code === 0) {
                            renderDate(setMark(data), data)
                        }
                    },
                    error() {
                        return layer.msg('请求数据异常', { icon: 2, time: 1000 })
                    }

                })
            }
            url && getData(url)

            //处理Mark 

            const setMark = (data) => {
                let mark = {}
                data.forEach((item) => {
                    mark[item.time] = item.value
                })
                return mark
            }

            //执行一个laydate实例
            const renderDate = (mark, data, value = new Date()) => {
                laydate.render({
                    value,
                    elem: container, //指定元素
                    position: 'static',
                    theme: 'grid',
                    mark,
                    done(time, date) {
                        let choose = data.filter((item) => {
                            return item.time === time
                        })
                        let chooseData = choose.length === 0 ? { time, value: '' } : choose[0]

                        moudle(chooseData, data)
                    }
                });
            }
            !url && renderDate(setMark(data = []), data = [])

            //清空容器
            const clear = () => {
                $(container).empty()
            }

            //弹出层
            const moudle = (chooseData, data) => {

                var index = layer.open({
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    title: '添加记录',
                    area: ['400px', 'auto'], //宽高
                    btn: ['确定', '撤销', '取消'],
                    content: `
                    <div class="text_box">
                        <form class="layui-form" action="">
                            <div class="layui-form-mid layui-word-aux">${chooseData.time}</div>
                            <div class="layui-form-item layui-form-text"> 
                                <textarea id="text_book" placeholder="请输入内容" class="layui-textarea">${chooseData.value}</textarea>
                            </div>
                        </form>
                    </div>`
                    , success: function () {
                        //   console.log(data);
                    },
                    yes() {
                        //保存
                        chooseData.value = $('#text_book').val()
                        //  console.log(chooseData, data);
                        let result = data.every((item) => {
                            return item.time !== chooseData.time
                        })
                        if (result) {
                            data.push(chooseData)
                        }
                        saveData(data, chooseData)
                        layer.close(index)
                    },
                    btn2() {
                        //撤销
                        data = data.filter((item) => {
                            return item.time !== chooseData.time
                        })
                        saveData(data, chooseData)
                    }
                })

            }

            //保存数据
            const saveData = (data, chooseData) => {
                clear()
                renderDate(setMark(data), data, chooseData.time)

                switch (sort) {
                    case 'up':
                        data.sort((v, i) => {
                            return new Date(v.time) - new Date(i.time)
                        })
                        break
                    case 'down':
                        data.sort((v, i) => {
                            return new Date(i.time) - new Date(v.time)
                        })
                        break
                }

                done(data)
            }


        });
    }




    layui.define(function (exports) {
        exports('laydateNote', render)
    })
})()

