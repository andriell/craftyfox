$.addParser("example.test4", function(d) {
	var fileWriter = app.getBean("file-writer");
	fileWriter.write(100500);
	fileWriter.flush();
	fileWriter.close();
});

