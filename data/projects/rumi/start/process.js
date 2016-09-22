$.addParser("rumi.start", function (data) {
    var url = 'http://ru-mi.com/xiaomi-redmi-3s-3gb-32gb-chernyiy';
    var dataHttp = $.newHttpData("GET", url);
    var dataHtml = $.newJsDataHtml("rumi.3s");
    dataHttp.addDataListener(dataHtml);
    console.info("Add data: " + dataHttp);
    craftyFox.processor.add("process-http", dataHttp);
});
