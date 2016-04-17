$.addParser("example.test3", function(document) {
	console.info("test3");
	var dataHttp = app.getBean("process-http-data");
	dataHttp.setMethod("GET");
	dataHttp.setUrl("http://ya.ru");
	var data = app.getBean("process-js-data-html");
	data.setPageName("example.test32");
	dataHttp.addDataListener(data);

	processor.add("process-http", dataHttp);
});

$.addParser("example.test32", function(document) {
	console.info(document);
});
