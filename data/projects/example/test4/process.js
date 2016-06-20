$.addParser("example.test4", function(d) {
	var fileWriter = app.getBean("file-writer");
	console.info(fileWriter.getClass().getName());
	fileWriter.init("test4.txt");
	fileWriter.write(100500);
	fileWriter.flush();
	fileWriter.close();
});

