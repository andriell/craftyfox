$.addParser("dns.start", function (data) {
    for (var i = 1; i <= 3; i++) {
        var url = "http://www.dns-shop.ru/products" + i + ".xml";
        console.info("Add: " + url);

        var document = $.http.get(url).text();
        console.info(document);
        return;
        var a = document.select("loc");

        var iterator = a.iterator();
        while(iterator.hasNext()) {
            var e = iterator.next();
            url = e.text();
            /*if (!craftyFox.hashTimeDay(url, 2)) {
                console.info("Old url: " + url);
                continue;
            }*/
            console.info(url);
            //$.process.new("dns.product", url);
        }
    }
});
