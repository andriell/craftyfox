$.process.listener("dns.start", function (data) {
    for (var i = 1; i <= 3; i++) {
        var url = "http://www.dns-shop.ru/products" + i + ".xml";
        console.info("Add: " + url);

        var document = $.http.get(url).xml();

        var a = document.select("loc");

        var iterator = a.iterator();
        while(iterator.hasNext()) {
            var e = iterator.next();
            url = e.text();
            if (!$.hashTime.day(url, 2)) {
                console.info("Old url: " + url);
                continue;
            }
            console.info(url);
            $.process.trigger("dns.product", url);
        }
    }
});
