$.process.register("example.test4", function(d) {
	var fileWriter1 = FileWriter("test4.txt");
	fileWriter1.write(100500);

	var fileWriter2 = FileWriter("test5.txt");
	fileWriter2.write(100501);
	
	fileWriter1.close();
	fileWriter2.close();

	var csvWriter1 = CsvWriter("1.csv");
	var csvWriter2 = CsvWriter("2.csv");

	csvWriter1.write("01");
	csvWriter1.write("02");
	csvWriter1.write("03");
	csvWriter1.newLine();
	csvWriter1.write("11");
	csvWriter1.write("12");
	csvWriter1.write("13\t0");
	csvWriter1.newLine();
	csvWriter1.write(21);
	csvWriter1.write(22);
	csvWriter1.write(23);
	csvWriter1.newLine();

	csvWriter2.writeLine(["01", "02", "03"]);
	csvWriter2.writeLine({"01": 11, "02":12, "03":"13\t0"});
	csvWriter2.write(21);
	csvWriter2.write(22);
	csvWriter2.write(23);
	csvWriter2.newLine();

	csvWriter1.close();
	csvWriter2.close();
});

