package br.com.grafana.sma.adapter.db;

import br.com.grafana.sma.core.business.Product;
import br.com.grafana.sma.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public interface ProductAdapterDB {

    Product toDomain(ProductEntity productEntity);

    ProductEntity toEntity(Product product);

}
