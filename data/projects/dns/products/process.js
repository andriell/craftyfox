/**
 * Created by Rybalko on 20.06.2016.
 */
$.addParser("dns.products", function (data) {
    console.info("products: " + data.getRequest().getRequestLine().getUri());

    var document = data.getData();
    var a = document.select("loc");
    var iterator = a.iterator();
    while(iterator.hasNext()) {
        var e = iterator.next();
        console.info(e.text());
    }
});
