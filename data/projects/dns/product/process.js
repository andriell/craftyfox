$.addParser("dns.product", function(data) {
    console.info(data.getUrl());
    var document = data.getData();
    var product = Product("dns", document.select(".price-item-code span").text());
    product.addProperty(ProductPrice(document.select("meta[itemprop=price]").attr("content"), "RUB"));
    product.setName(document.select("h1").text());
    product.setUrl(data.getUrl());
    product.save();
});
