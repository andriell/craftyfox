/**
 * Created by Rybalko on 20.06.2016.
 */
var labCsvWriter = CsvWriter("lab.csv");

$.addParser("lab.page2", function(data) {
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
});
