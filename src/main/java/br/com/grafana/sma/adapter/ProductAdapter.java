package br.com.grafana.sma.adapter;

import br.com.grafana.sma.core.business.Product;
import br.com.grafana.sma.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public interface ProductAdapter {

    Product toDomain(ProductEntity productEntity);
}
