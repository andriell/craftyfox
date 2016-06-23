function Product(site, code) {
    var product = app.getBean("js-product");
    product.setSite(site);
    product.setCode(code);
    var fileWriter = {
        "product": product,
        "write": function (s) {
            fileWriter.writer.write("" + s);
        },
        "newLine": function () {
            fileWriter.writer.newLine();
        },
        "flush": function () {
            fileWriter.writer.flush();
        },
        "close": function () {
            fileWriter.writer.flush();
            fileWriter.writer.close();
        }
    };
    return fileWriter;
}
