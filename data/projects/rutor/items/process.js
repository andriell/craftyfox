/**
 * Created by Rybalko on 20.06.2016.
 */
$.addParser("rutor.items", function(data) {
    var csvWriter1 = CsvWriter("rutor.csv");
    var document = data.getData();
    var tr = document.select("#index tr.gai");
    var iterator = tr.iterator();
    while(iterator.hasNext()) {
        var element = iterator.next();
        var a = element.select("a:nth-child(3)");
        console.info(a.attr("href"));
    }
});