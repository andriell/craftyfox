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

function ProductPrice(price, currency) {
    var productProperty = app.getBean("js-product-property");
    productProperty.price(price, currency);
    return productProperty;
}