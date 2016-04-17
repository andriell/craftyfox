$.addParser("example.test2", function(document) {
	console.info("test2");
	var data = app.getBean("process-js-data-html");
	data.setPageName("example.test2");
	processor.add("process-js", data);
});
