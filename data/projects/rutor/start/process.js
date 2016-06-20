/**
 * Created by Rybalko on 20.06.2016.
 */
$.addParser("rutor.start", function(d) {
    var dataHttp = $.newHttpData("GET", "http://tor-unblock.org/top");
    var dataHtml = $.newJsDataHtml("rutor.items");
    dataHttp.addDataListener(dataHtml);

    processor.add("process-http", dataHttp);
});
