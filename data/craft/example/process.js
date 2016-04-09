/**
 * Описание объекта org.jsoup.nodes.Document находится по адресу http://jsoup.org/cookbook/extracting-data/selector-syntax
 * @param  document - org.jsoup.nodes.Document
 */
console.info(task.add("process-js", {}));
$.addProcess("example", function(document) {
	console.info(document.getClass().getName());
	var links = document.select("a.link");
	console.info(links.getClass().getName());
	var iterator = links.iterator();
	console.info(iterator.getClass().getName());
	while(iterator.hasNext()) {
		var element = iterator.next();
		console.info(element.getClass().getName());
		console.info(element.attr("href"));
	}
});
