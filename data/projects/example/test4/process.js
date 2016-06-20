$.addParser("example.test4", function(d) {
	var fileWriter = csvWriter("test4.txt");
	fileWriter.write(100500);

	var fileWriter2 = csvWriter("test5.txt");
	fileWriter2.write(100501);
	
	fileWriter.close();
	fileWriter2.close();
});

