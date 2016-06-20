/**
 * Created by Rybalko on 20.06.2016.
 */
$.addParser("rutor.start", function(d) {
    for (var i = 0; i <= 2; i++) {
        var dataHttp = $.newHttpData("GET", "http://open-tor.org/browse/" + i + "/0/0/0");
        var dataHtml = $.newJsDataHtml("rutor.items");
        dataHttp.addDataListener(dataHtml);
        processor.add("process-http", dataHttp);
    }
});
