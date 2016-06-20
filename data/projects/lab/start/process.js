/**
 * Created by Rybalko on 20.06.2016.
 */
$.addParser("lab.start", function (d) {
    var dataHttp = $.newHttpData("GET", "http://pornolab.net/");
    var dataHtml = $.newJsDataHtml("lab.page1");
    dataHttp.addDataListener(dataHtml);
    processor.add("process-http", dataHttp);
});