$.process.register("example.test3", function(d) {
	console.info("test3");
	$.process.new("example.test32", "http://ya.ru");
});

$.process.register("example.test32", function(data) {
	var url = data.getData();
	var request = $.http.newGetRequest(url);
	var response = $.http.execute(request);

	console.info(response.requestHeaders());
	console.info(response.responseHeaders());
	console.info(response.url());
	console.info("");
	console.info(response.text());
});
