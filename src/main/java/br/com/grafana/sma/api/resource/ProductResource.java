package br.com.grafana.sma.api.resource;

import br.com.grafana.sma.api.resource.response.SearchProductsResponse;
import br.com.grafana.sma.core.business.usecase.SearchProductsUseCase;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/products")
public class ProductResource {

    @Autowired
    private SearchProductsUseCase searchProducts;

    @GetMapping
    public ResponseEntity<@NonNull SearchProductsResponse> searchProducts() {
        System.out.println("c=ProductResource m=searchProducts");
        return ok(new SearchProductsResponse(searchProducts.getProducts()));
    }

}
