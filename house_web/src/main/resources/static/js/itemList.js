// 首先要得到后端的数据，应该是后端传回要显示的数据而不是全部数据，前端传给后端这是第几页
// 前端需要知道总页数
var numOfItems;
var numOfItemsThisPage;
// 一页的最大显示条数
var MAXSIZE=10;
var numOfPages  = numOfItems/MAXSIZE + 1;
// 要插入的html代码,可能不需要这个
// var itemStr;
var pageStr;
// 是不是装修，1是装修
var decoration;

// 没找到的时候插入一图片吧
if (numOfItems == 0) {
	str="";
}
else{
	// 已经是最后一页，不能排满
	if (numOfItemsThisPage < MAXSIZE){ showItems(numOfItemsThisPage); }
	// 中间页，能排满
	else {showItems(MAXSIZE)}
}

function showItems(num){
	// 插入位置
	var position = document.getElementsByTagName('');
	for(i=0;i<num;i++){
		var newItem = document.createElement('div');
		// 预览图片
		var img = document.createElement('img');
		//标题
		var title = document.createElement('h2');
		//地址 
		var address = document.createElement('span');
		// 价格，装修没有价格
		var price = document.createElement('span');
		// 装修风格，只有装修有
		var style = document.createElement('span');
		// 信息盒子
		var infoBox = document.createElement('div');
		infoBox.appendChild(title);
		infoBox.appendChild(address);
		if (decoration){infoBox.appendChild(style);}
		else{infoBox.appendChild(price);}

		// 填充条目
		newItem.appendChild(img);
		newItem.appendChild(infoBox);

		// 添加条目
		position.appendChild(newItem);
	}
}