$.addParser("rumi.3s", function (data) {
    var document = data.getData();
    var buttonBay = document.select("#button-cart");
    if (buttonBay.size() != 0) {
        informer.beep();
    }
});
