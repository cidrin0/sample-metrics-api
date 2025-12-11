package br.com.grafana.sma.api.resource.response;

import br.com.grafana.sma.core.business.Product;

import java.util.List;
import java.util.stream.Collectors;

public class SearchProductsResponse {

    public final List<ProductResponse> products;

    public SearchProductsResponse(List<Product> products) {
        this.products = products.stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());

    }
}
