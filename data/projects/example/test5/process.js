$.process.register("example.test5", function(d) {
	console.info("test5");
	var dataHttp = $.newHttpData("GET", "http://ya.ru");
	var dataHtml = $.newJsDataHtml("example.test5resp");
	dataHttp.addDataListener(dataHtml);

	craftyFox.processor.add("process-http", dataHttp);
});

$.process.register("example.test5resp", function(dataHtml) {
	var product = Product("ya.ru", "test5");
	product.setUrl("http://ya.ru/");
	product.addProperty(ProductProperty("p1", 1));
	product.addProperty(ProductProperty("p2", "2"));
	product.addProperty(ProductProperty("p3", 3.5));
	product.addProperty(ProductPrice(50.5, "RUB"));
	console.info(product.save());
});