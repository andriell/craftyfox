/**
 * Created by Rybalko on 20.06.2016.
 */
$.addParser("rutor.items", function(data) {
    var csvWriter1 = CsvWriter("rutor.csv");
    var document = data.getData();
    var tr = document.select("#index tr.gai");
    var iterator = tr.iterator();
    while(iterator.hasNext()) {
        var e = iterator.next();
        var a = e.select("a:nth-child(3)");
        csvWriter1.write(a.text());
        csvWriter1.write(a.attr("href"));
        csvWriter1.write(e.select(".green").text());
        csvWriter1.newLine();
    }
    csvWriter1.close();
});