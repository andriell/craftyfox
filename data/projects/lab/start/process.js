/**
 * Created by Rybalko on 20.06.2016.
 */
$.addParser("lab.start", function (data) {
    craftyFox.httpContext.addCookie("bb_data", "1-15022644-DvmlCwj8Cp1q01B2aTqq-1841509792-1466431256-1466432539-3107363333-1", ".pornolab.net", "/forum/");
    craftyFox.httpContext.addCookie("bb_t", "a%3A1%3A%7Bi%3A311844%3Bi%3A1466422490%3B%7D", ".pornolab.net", "/forum/");
    var dataHttp = $.newHttpData("GET", "http://pornolab.net/forum/index.php");
    var dataHtml = $.newJsDataHtml("lab.page1");
    dataHttp.addDataListener(dataHtml);
    craftyFox.processor.add("process-http", dataHttp);
});
