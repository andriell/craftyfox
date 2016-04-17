$.addParser("test2", function(document) {
	processor.sleep(1000);
	console.info("test2\n");
	var data = app.getBean("process-js-data-html");
	data.setPageName("test2");
	processor.add("process-js", data);
});
