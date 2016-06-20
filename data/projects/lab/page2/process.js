/**
 * Created by Rybalko on 20.06.2016.
 */
var labCsvWriter = CsvWriter("lab.csv");

var lab = {
    "pages": [0],
    "addPage": function (href) {
        if (lab.pages.indexOf(href) < 0) {
            lab.pages.push(href);
            var dataHttp = $.newHttpData("GET", "http://pornolab.net/forum/" + href);
            var dataHtml = $.newJsDataHtml("lab.page2");
            dataHttp.addDataListener(dataHtml);
            processor.add("process-http", dataHttp);
        }
    }
};

$.addParser("lab.page2", function(data) {
    console.info("page2: " + data.getRequest().getRequestLine().getUri());

    var document = data.getData();
    var tr = document.select(".forum tr");
    var iterator = tr.iterator();
    while(iterator.hasNext()) {
        var e = iterator.next();
        var seedmed = e.select(".seedmed").text().trim();
        if (!seedmed) {
            continue;
        }
        var href = e.select("a.torTopic").attr("href");

        if (!href) {
            continue;
        }
        href = "http://pornolab.net/forum/" + href;
        labCsvWriter.writeLine([href, seedmed]);
    }
    labCsvWriter.flush();

    var pagination = document.select("#pagination a");
    iterator = pagination.iterator();
    while(iterator.hasNext()) {
        e = iterator.next();
        href = e.attr("href");
        if (href.indexOf("viewforum") >= 0) {
            lab.addPage(href);
        }
    }
    console.info(lab.pages);
});
