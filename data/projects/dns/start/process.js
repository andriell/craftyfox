$.addParser("dns.start", function (data) {
    for (var i = 1; i <= 3; i++) {
        var url = "http://www.dns-shop.ru/products" + i + ".xml";
        console.info("Add: " + url);
        var dataHttp = $.newHttpData("GET", url);
        var dataHtml = $.newJsDataXml("dns.products");
        dataHttp.addDataListener(dataHtml);
        console.info("Add data: " + dataHttp);
        craftyFox.processor.add("process-http", dataHttp);
    }
});
