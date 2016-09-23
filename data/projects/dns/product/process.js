$.addParser("dns.product", function(data) {
    var url = data.getData();
    console.info("URL: " + url);

    var document = $.http.get(url).html();
    var product = Product("dns", document.select(".price-item-code span").text());
    product.addProperty(ProductPrice(document.select("meta[itemprop=price]").attr("content"), "RUB"));
    product.setName(document.select("h1").text());
    product.setUrl(url);
    var path = document.select(".breadcrumb").first().select("li");
    var iterator = path.iterator();
    while(iterator.hasNext()) {
        var element = iterator.next();
        product.addProperty(ProductPropertyEnum("path", element.text()));
    }
    craftyFox.processor.add("process-db", product);
    craftyFox.hashTimeUpdate(url);
});
