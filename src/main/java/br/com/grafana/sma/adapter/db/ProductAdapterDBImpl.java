package br.com.grafana.sma.adapter.db;

import br.com.grafana.sma.core.business.Product;
import br.com.grafana.sma.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductAdapterDBImpl implements ProductAdapterDB {

    @Override
    public Product toDomain(ProductEntity productEntity) {
        System.out.println("c=ProductAdapterDBImpl m=toDomain");
        return new Product(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice()
        );
    }

    @Override
    public ProductEntity toEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCode(product.code);
        productEntity.setName(product.name.content());
        productEntity.setDescription(product.description.content());
        productEntity.setPrice(product.price);
        return productEntity;
    }
}
