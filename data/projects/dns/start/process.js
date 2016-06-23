/**
 * Created by Rybalko on 20.06.2016.
 */
$.addParser("dns.start", function (data) {
    for (var i = 1; i <= 3; i++) {
        var dataHttp = $.newHttpData("GET", "http://www.dns-shop.ru/products" + i + ".xml");
        var dataHtml = $.newJsDataXml("dns.products");
        dataHttp.addDataListener(dataHtml);
        processor.add("process-http", dataHttp);
    }
});
