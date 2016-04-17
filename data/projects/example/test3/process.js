$.addParser("example.test3", function(document) {
	console.info("test3");
	var dataHttp = app.getBean("process-http-data");
	dataHttp.setMethod("GET");
	dataHttp.setUrl("http://ya.ru");
	var dataHtml = $.newJsDataHtml("example.test32");
	dataHttp.addDataListener(dataHtml);

	processor.add("process-http", dataHttp);
});

$.addParser("example.test32", function(dataHtml) {
	console.info(dataHtml.getDataHtml());
});
