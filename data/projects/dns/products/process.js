$.addParser("dns.products", function (data) {
    console.info("products: " + data.getUrl());

    var document = data.getData();
    var a = document.select("loc");
    var iterator = a.iterator();
    while(iterator.hasNext()) {
        var e = iterator.next();

        var dataHttp = $.newHttpData("GET", e.text());
        var dataHtml = $.newJsDataHtml("dns.product");
        dataHttp.addDataListener(dataHtml);
        //processor.add("process-http", dataHttp);
    }
});
