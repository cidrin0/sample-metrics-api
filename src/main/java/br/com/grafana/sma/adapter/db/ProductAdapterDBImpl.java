package br.com.grafana.sma.adapter.db;

import br.com.grafana.sma.adapter.ProductAdapter;
import br.com.grafana.sma.core.business.Product;
import br.com.grafana.sma.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductAdapterDBImpl implements ProductAdapter {

    @Override
    public Product toDomain(ProductEntity productEntity) {
        System.out.println("c=ProductAdapterDBImpl m=toDomain");
        return new Product(productEntity);
    }
}
