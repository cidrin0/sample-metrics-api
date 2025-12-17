package br.com.grafana.sma.api.resource.response;

import java.util.List;

public class SearchProductsResponse {

    public final List<ProductResponse> products;

    public SearchProductsResponse(List<ProductResponse> products) {
        this.products = products;
    }
}