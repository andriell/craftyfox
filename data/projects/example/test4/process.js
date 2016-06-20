$.addParser("example.test4", function(d) {
	var fileWriter = FileWriter("test4.txt");
	fileWriter.write(100500);

	var fileWriter2 = FileWriter("test5.txt");
	fileWriter2.write(100501);
	
	fileWriter.close();
	fileWriter2.close();
});

