$.addParser("example.http", function(d) {
	var url = 'https://pegast.ru/pegasys/ajax_search?section=default&returnLocation=76&fromCity=76&toCountry=164&package=all&datesArray=24.09.2016%2C27.09.2016%2C01.10.2016%2C04.10.2016%2C08.10.2016%2C13.10.2016%2C15.10.2016%2C16.10.2016%2C18.10.2016%2C19.10.2016%2C21.10.2016%2C22.10.2016&durationArray=9%2C10%2C11%2C12&adults=2&childNumber=0&childAge%5B%5D=&childAge%5B%5D=&childAge%5B%5D=&childAge%5B%5D=&childAge%5B%5D=&locations%5B%5D=349&locationAreas%5B%5D=3091521&locationAreas%5B%5D=3093507&locationAreas%5B%5D=3324616&locationAreas%5B%5D=6221161&locationAreas%5B%5D=6221165&locationAreas%5B%5D=6221167&locationAreas%5B%5D=6221169&locationAreas%5B%5D=6221171&locationAreas%5B%5D=6221173&locationAreas%5B%5D=6221232&locationAreas%5B%5D=6221235&locationAreas%5B%5D=6221237&locationAreas%5B%5D=6221239&locationAreas%5B%5D=6221241&locationAreas%5B%5D=6221243&locationAreas%5B%5D=6221265&locationAreas%5B%5D=6221271&locationAreas%5B%5D=6221275&locationAreas%5B%5D=6221282&locationAreas%5B%5D=6221284&locationAreas%5B%5D=6320302&locationAreas%5B%5D=95596560&locationAreas%5B%5D=135564895&hotels_available=on&departureFlightClassType=Economy&flights_available=on&currency=36';
	var request = $.http.get(url)
		//.setHeader("Cookie", "departureCity=eyJ0b3duIjoxNDAsImNvdW50cnkiOm51bGx9")
		.setHeader("X-Requested-With", "XMLHttpRequest");
	$.http.client.addCookie("departureCity", "eyJ0b3duIjoxNDAsImNvdW50cnkiOm51bGx9", "pegast.ru", "/");
	var response = $.http.execute(request);

	console.info(response.requestHeaders());
	console.info(response.responseHeaders());
	console.info(response.url());
	console.info("");
	console.info(response.text());
});
