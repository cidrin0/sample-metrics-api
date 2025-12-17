package br.com.grafana.sma.adapter.api;

import br.com.grafana.sma.api.resource.request.CreateProductRequest;
import br.com.grafana.sma.api.resource.response.ProductResponse;
import br.com.grafana.sma.core.business.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductAdapterApiImpl implements ProductAdapterApi {

    @Override
    public ProductResponse toResponse(Product product) {
        return new ProductResponse(product);
    }

    @Override
    public Product toDomain(CreateProductRequest productRequest) {
        return new Product(
                productRequest.name(),
                productRequest.description(),
                productRequest.price()
        );
    }
}
