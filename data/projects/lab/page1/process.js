/**
 * Created by Rybalko on 20.06.2016.
 */
$.addParser("lab.page1", function(data) {
    var document = data.getData();
    var tr = document.select(".sf_title");
    var iterator = tr.iterator();
    while(iterator.hasNext()) {
        var e = iterator.next();
        var a = e.select("a:nth-child(3)");
        rutorCsvWriter.writeLine([a.text(), a.attr("href"), e.select(".green").text()]);
    }
    rutorCsvWriter.flush();
});