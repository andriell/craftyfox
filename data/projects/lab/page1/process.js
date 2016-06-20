/**
 * Created by Rybalko on 20.06.2016.
 */
$.addParser("lab.page1", function(data) {
    console.info("page1: " + data.getRequest().getRequestLine().getUri());

    var document = data.getData();
    var a = document.select(".sf_title a:nth-child(2)");
    var iterator = a.iterator();
    while(iterator.hasNext()) {
        var e = iterator.next();
        var href = e.attr("href");
        if (href.indexOf("viewforum") > 0) {
            var dataHttp = $.newHttpData("GET", "http://pornolab.net/forum/" + href);
            var dataHtml = $.newJsDataHtml("lab.page2");
            dataHttp.addDataListener(dataHtml);
            processor.add("process-http", dataHttp);
        }
    }
});