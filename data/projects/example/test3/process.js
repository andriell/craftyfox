$.addParser("example.test3", function(document) {
	console.info("test3");
	var data = app.getBean("process-js-data-html");
	data.setPageName("example.test3");
	processor.add("process-js", data);
});
