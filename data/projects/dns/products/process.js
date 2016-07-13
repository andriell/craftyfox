$.addParser("dns.products", function (data) {
    console.info("products: " + data.getUrl());

    var document = data.getData();
    var a = document.select("loc");
    var iterator = a.iterator();
    while(iterator.hasNext()) {
        var e = iterator.next();
        var url = e.text();


        var dataHttp = $.newHttpData("GET", url);
        var dataHtml = $.newJsDataHtml("dns.product");
        dataHttp.addDataListener(dataHtml);
        craftyFox.processor.add("process-http", dataHttp);
    }
});
