$.addParser("example.test2", function(d) {
	console.info("test2");
	var data = app.getBean("process-js-data-html");
	data.setPageName("example.test2");
	craftyFox.processor.add("process-js", data);
});
