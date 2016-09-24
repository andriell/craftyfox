/**
 * Created by Rybalko on 20.06.2016.
 */

var rutorCsvWriter = CsvWriter("rutor.csv");
var rutorCount = 0;
$.process.listener("rutor.items", function(data) {
    console.info("Run: " + (rutorCount++) + " " + data.getUrl());
    var document = data.getData();
    var tr = document.select("#index tr.gai, #index tr.tum");
    var iterator = tr.iterator();
    while(iterator.hasNext()) {
        var e = iterator.next();
        var a = e.select("a:nth-child(3)");
        rutorCsvWriter.writeLine([a.text(), a.attr("href"), e.select(".green").text()]);
    }
    rutorCsvWriter.flush();
});
