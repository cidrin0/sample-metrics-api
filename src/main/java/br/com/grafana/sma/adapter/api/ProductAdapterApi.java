package br.com.grafana.sma.adapter.api;

import br.com.grafana.sma.api.resource.request.CreateProductRequest;
import br.com.grafana.sma.api.resource.response.ProductResponse;
import br.com.grafana.sma.core.business.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductAdapterApi {

     ProductResponse toResponse(Product product);

    Product toDomain(CreateProductRequest productRequest);
}
