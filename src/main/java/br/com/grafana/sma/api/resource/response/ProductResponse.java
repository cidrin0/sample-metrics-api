package br.com.grafana.sma.api.resource.response;

import br.com.grafana.sma.core.business.Product;

public class ProductResponse {

    public final String code;
    public final String name;
    public final String description;
    public final String price;

    public ProductResponse(Product product) {
        this.code = product.code.toString();
        this.name = product.name;
        this.description = product.description;
        this.price = product.price.toPlainString();
    }
}
