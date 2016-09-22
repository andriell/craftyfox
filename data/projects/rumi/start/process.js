$.addParser("rumi.start", function (data) {
    var url = 'http://ru-mi.com/xiaomi-redmi-3s-3gb-32gb-chernyiy';
    while(true) {
        console.info(url);
        var dataHttp = $.newHttpData("GET", url);
        var dataHtml = $.newJsDataHtml("rumi.3s");
        dataHttp.addDataListener(dataHtml);
        console.info("Add data: " + dataHttp);
        craftyFox.processor.add("process-http", dataHttp);
        console.sleep(10);
    }
});

$.addParser("rumi.3s", function (data) {
    var document = data.getData();
    var links = document.select("a.link");
    var iterator = links.iterator();
    while(iterator.hasNext()) {
        var element = iterator.next();
        console.info(element.getClass().getName());
        console.info(element.attr("href"));
    }
});