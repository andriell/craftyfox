$.addParser("test2", function(document) {
	processor.sleep(1000);
	console.info("test2\n");
	var data = processor.newData("process-js");
	data.setCraftName("test2");
	processor.add("process-js", data);
});
