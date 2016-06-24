$.addParser("example.test3", function(d) {
	console.info("test3");
	var dataHttp = $.newHttpData("GET", "http://ya.ru");
	var dataHtml = $.newJsDataHtml("example.test32");
	dataHttp.addDataListener(dataHtml);

	processor.add("process-http", dataHttp);
});

$.addParser("example.test32", function(data) {
	console.info(data.getUrl());
	console.info(data.getDataHtml());
});
