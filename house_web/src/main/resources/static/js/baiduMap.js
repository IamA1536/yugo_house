var mp = new BMap.Map("baidu_map");
var point = new BMap.Point(116.3964, 39.9093);
mp.centerAndZoom(point, 10);
mp.enableScrollWheelZoom();

var canvasLayer = new BMap.CanvasLayer({
    update: update
});

var marker = new BMap.Marker(point);  // 创建标注
mp.addOverlay(marker);              // 将标注添加到地图中
mp.panTo(new_point);

var geolocation = new BMap.Geolocation();
$("#bdPosition").text(r.point.lng + ',' + r.point.lat);

function update() {
    var ctx = this.canvas.getContext("2d");

    if (!ctx) {
        return;
    }

    ctx.clearRect(0, 0, ctx.canvas.width, ctx.canvas.height);

    var temp = {};
    ctx.fillStyle = "rgba(50, 50, 255, 0.7)";
    ctx.beginPath();
//     var data = [
//         new BMap.Point(116.297047, 39.979542),
//     ];

    for (var i = 0, len = data.length; i < len; i++) {
        var pixel = mp.pointToPixel(data[i]);
        ctx.fillRect(pixel.x, pixel.y, 30, 30);
    }
}

mp.addOverlay(canvasLayer);
