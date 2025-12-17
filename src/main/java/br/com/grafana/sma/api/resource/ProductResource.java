package br.com.grafana.sma.api.resource;

import br.com.grafana.sma.adapter.api.ProductAdapterApi;
import br.com.grafana.sma.api.resource.request.CreateProductRequest;
import br.com.grafana.sma.api.resource.response.ProductResponse;
import br.com.grafana.sma.api.resource.response.SearchProductsResponse;
import br.com.grafana.sma.core.business.Product;
import br.com.grafana.sma.core.business.usecase.CreateProductUseCase;
import br.com.grafana.sma.core.business.usecase.DeleteProductUseCase;
import br.com.grafana.sma.core.business.usecase.SearchProductUseCase;
import br.com.grafana.sma.core.business.usecase.SearchProductsUseCase;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/products")
public class ProductResource {

    @Autowired
    private ProductAdapterApi productAdapterApi;

    @Autowired
    private SearchProductsUseCase searchProducts;

    @Autowired
    private SearchProductUseCase searchProduct;

    @Autowired
    private CreateProductUseCase createProduct;

    @Autowired
    private DeleteProductUseCase deleteProduct;

    @GetMapping
    public ResponseEntity<@NonNull SearchProductsResponse> searchProducts() {
        System.out.println("c=ProductResource m=searchProducts");
        return ok(
                new SearchProductsResponse(
                        searchProducts.getProducts()
                                .stream()
                                .map(productAdapterApi::toResponse)
                                .collect(Collectors.toList())
                )
        );
    }

    @GetMapping("/{code}")
    public ResponseEntity<@NonNull ProductResponse> searchProduct(@PathVariable("code") UUID code) {
        System.out.println("c=ProductResource m=searchProduct");
        return ok(productAdapterApi.toResponse(searchProduct.getProduct(code)));
    }

    @PostMapping
    public ResponseEntity<@NonNull Void> createProduct(@RequestBody CreateProductRequest productRequest) {
        System.out.println("c=ProductResource m=createProduct");

        Product product = createProduct.createProduct(productAdapterApi.toDomain(productRequest));
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/{code}")
                        .buildAndExpand(product.code)
                        .toUri()
        ).build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<@NonNull Void> deleteProduct(@PathVariable("code") UUID code) {
        System.out.println("c=ProductResource m=deleteProduct");
        deleteProduct.deleteProduct(code);
        return ResponseEntity.noContent().build();
    }
}
