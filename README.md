# 优购房
## 需求
### 1. 开发商通过在平台上申请发布自己楼盘信息
### 2. 用户即可随时随地了解楼盘的相关信息
### 3. 提供租房的功能
### 4. 论坛
### 5. 装修的服务
***
## 基础技术要求
### 1. 前端：原则上是要HTML5+Ajax+JS的，但是原生Js要是嫌麻烦的可以用vue.js之类的
### 2. 后台：原则上是要SSM的，但是嫌麻烦可以使用spring boot
### 3. spring data jpa整合简化jpa快速开发其实就是类似于持久层不用类的用接口的(注入)
### 4. 数据库还是经典的Mysql看着来就好，持久层用Mybatis
### 5. maven+svn
### 6. 使用百度地图，还有第三方易宝支付
***
## 其他的要求
### 1. 推荐楼盘管理和租房管理用一个界面，调用不同的数据库。
### 2. 界面可以不要从零开始写，可以用现有的。
### 3. 买东西的界面等配置可以参照宠物商店。
### 4. 这个项目数据库表很多，需要讨论一下。
### 5. 论坛直接使用模板Discuz!，和主站分开，搭载在一个(或者两个服务器上，反向代理眼神暗示)
***
## 问题及注意事项
### 1. 前端需要良好注释。。。。就是什么会显示什么
> 例如: 
\<a class="city-wather" href="www.baidu.com......./>  
\<!-- 显示城市雨水的链接 -->
### 2. 后台也是的。。。
### 3. 这里其实推荐是用git来代替SVN的，老师也没说不行，SVN也可以，但是个人感觉隔一段时间汇总一下代码集中上传效率会高一些
### 4. 实体类(接口)最好先讨论一下数据库结构再确定。。。
### 5. 还是说明一下，这个网站卖房是不可能的，顶多是预约房产，缴纳预约金之类的，因为是要签合同什么的，而且还有住房公积金之类的。。。有点复杂，这个网站实现不太现实
***
## 8.27
### 工作
1. 确认项目(完成)
2. 编写项目计划
3. git仓库创建
4. 尝试找一下有关的模板等

## 8.28
### 工作
1. 找到demo
2. 需求规约以及用例规约
3. 原型
4. 后台理解一下这个运作
5. 前端适当学一学例如bootstrap之类的

## 8.29
### 工作
1. 确定一下有关的数据库结构(或者说有关的实体类的属性)
2. 写系统设计报告(UML类图，时序图之类的)
3. 包结构做好，上传至github
4. 服务器上搭建数据库
### 表结构
* 用户管理
>user_standrad

字段名称|数据类型|长度|描述|允许空|主键
--|:--:|:--:|:--:|:--:|:--:
ID|int||用户编号|NOT NULL|是
username|varchar|30|用户名|NOT NULL|否
type|int|2|用户角色|NOT NULL|否
email|varchar|255|用户邮箱|NOT NULL|否
info|varchar|255|用户描述||否
icon|varchar|255|头像||否
sex|int|2|性别|NOT NULL|否
address|varchar|255|省市|NOT NULL|否
tele|varchar|20|电话|NOT NULL|否
>user_important

字段名称|数据类型|长度|描述|允许空|主键
--|:--:|:--:|:--:|:--:|:--:
ID|int||用户编号|NOT NULL|是
realname|varchar|255|真实姓名|NOT NULL|否
IDnumber|varchar|255|身份证号|NOT NULL|否
pw|varchar|255|用户密码|NOT NULL|否

>user_collections

字段名称|数据类型|长度|描述|允许空|主键
--|:--:|:--:|:--:|:--:|:--:
ID|int||编号|NOT NULL|是
userID|int||用户编号|NOT NULL|是
itemID|int||商品ID|NOT NULL|否
time|varchar|255|收藏时间|NOT NULL|否

* 房产/租房/装修管理
>property_building

字段名称|数据类型|长度|描述|允许空|主键
--|:--:|:--:|:--:|:--:|:--:
ID|int||编号|NOT NULL|是
buildingID|varchar|255|房产序列号|NOT NULL|否
saleStatus|int|2|销售状态|NOT NULL|否

>rent

字段名称|数据类型|长度|描述|允许空|主键
--|:--:|:--:|:--:|:--:|:--:
ID|int||编号|NOT NULL|是
buildingID|varchar|255|房产序列号|NOT NULL|否
area|double|20|面积|NOT NULL|否

>building

字段名称|数据类型|长度|描述|允许空|主键
--|:--:|:--:|:--:|:--:|:--:
ID|int||编号|NOT NULL|是
type|int|10|状态(买/租/楼盘)|NOT NULL|否
itemName|varchar|255|商品名|NOT NULL|否
price|double||商品价格|NOT NULL|否
img|varchar|255|商品图片链接||否
itemFrom|int||供应商ID|NOT NULL|否
info|varchar|255|商品介绍||否
address|varchar|255|楼盘地址|NOT NULL|否
decStatus|int|2|装修状况|NOT NULL|否

>decoration

字段名称|数据类型|长度|描述|允许空|主键
--|:--:|:--:|:--:|:--:|:--:
ID|int||编号|NOT NULL|是
company|varchar|25|公司名|NOT NULL|否
address|varchar|255|地址|NOT NULL|否
tele|varchar|30|联系方式|NOT NULL|否
img|varchar|255|公司图片||否
itemFrom|int||供应商ID|NOT NULL|否
info|varchar|255|商品介绍||否
style|int|10|风格||否
link|varchar|255|官网链接||否

* 论坛

>post

字段名称|数据类型|长度|描述|允许空|主键
--|:--:|:--:|:--:|:--:|:--:
ID|int||编号|NOT NULL|是
theme|varchar|255|主题|NOT NULL|否
host|varchar|255|楼主|NOT NULL|否
content|varchar|255|内容|NOT NULL|否
time|varchar|35|建立时间|NOT NULL|否

>reply

字段名称|数据类型|长度|描述|允许空|主键
--|:--:|:--:|:--:|:--:|:--:
ID|int||编号|NOT NULL|是
postID|int||主贴ID|NOT NULL|否
userID|int||回复人ID|NOT NULL|否
content|varchar|255|内容|NOT NULL|否
time|varchar|255|时间|NOT NULL|否

* 管理员
>admin

字段名称|数据类型|长度|描述|允许空|主键
--|:--:|:--:|:--:|:--:|:--:
ID|int||编号|NOT NULL|是
userID|varchar|30|账户|NOT NULL|否
pw|varchar|255|密码|NOT NULL|否

## 8.30~9.1
### 工作
1. 开始代码编写
2. 接口文件
3. 前端用户有关界面及结构搭建
4. 持久层，基本模型写好，可以读取数据(实现连接池等)
5. 后端项目结构搭建

>前端内容
* 登录界面
* 主页
* 系统管理界面

>后端项目结构
* 主体项目——yugo_house
* 持久层——house_dao
* 模型等接口及类——house_common
* web部分——house_web

## 9.2
### 工作
1. 完善接口文件
2. 前端加油
3. 后端实现数据读写
* ### 后端数据的各种值
>ID——大种类+随机数，例如:1+114514(随机生成六位数)
ID就是1114514
>\
1——楼盘
\
2——租房
\
3——装修

>type
\
用户:1(一般用户),2(开发商)
\
房产:1(楼盘),2(二手房),3(租房)

>装修风格
\
1——现代
2——中式
3——欧式
4——混搭
5——其他
## 9.3
### 工作
1. github调好，进行版本管理
2. 持久层写好，进行测试
3. 前端加油

## 9.4
### 工作
1. 持久层完成
2. controller搭建
3. 前端加油

## 9.5
### 工作
1. 前端初步界面————前端
2. 后台接受界面实现部分用户功能————刘念
3. 完成论坛———刘浩钧

## 9.6
### 工作
1. 前端加油
2. 为数据库添加数据
3. 尽量在今天完成大体项目
> 销售状态
\
1——在售
\
2——预售

## 9.7~9.8
### 工作
1. 完成并测试项目主站
2. 前端开始修改静态文件
3. 开始准备写后台站点

## 9.9
### 工作
1. 修复好主站的样式
2. 完成并开始测试后台
3. 准备开始制作PPT
