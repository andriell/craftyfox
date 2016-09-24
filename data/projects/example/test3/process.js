$.process.listener("example.test3", function(d) {
	console.info("test3");
	$.process.trigger("example.test32", "http://ya.ru");
});

$.process.listener("example.test32", function(url) {
	var request = $.http.newGetRequest(url);
	var response = $.http.execute(request);

	console.info(response.requestHeaders());
	console.info(response.responseHeaders());
	console.info(response.url());
	console.info("");
	console.info(response.text());
});
