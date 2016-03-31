/**
 * Описание объекта org.jsoup.nodes.Document находится по адресу http://jsoup.org/cookbook/extracting-data/selector-syntax
 * @param  document - org.jsoup.nodes.Document
 */
craftyFox.addProcess("example", function(document) {
    print(document.getClass().getName());
    var links = document.select("a.link");
    print(links.getClass().getName());
    var iterator = links.iterator();
    print(iterator.getClass().getName());
    while(iterator.hasNext()) {
        var element = iterator.next();
        print(element.getClass().getName());
        print(element.attr("href"));
    }
});

