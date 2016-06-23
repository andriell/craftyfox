function Product(site, code) {
    var product = app.getBean("js-product");
    product.setSite(site);
    product.setCode(code);
    return product;
}
function ProductProperty(name, value) {
    var productProperty = app.getBean("js-product-property");
    productProperty.setName(name);
    productProperty.setValue(value);
    return productProperty;
}
function ProductPrice(name, value) {
    var productProperty = app.getBean("js-product-property");
    productProperty.price(name);
    productProperty.setValue(value);
    return productProperty;
}