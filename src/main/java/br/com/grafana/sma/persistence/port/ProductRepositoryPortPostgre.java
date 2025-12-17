package br.com.grafana.sma.persistence.port;

import br.com.grafana.sma.adapter.db.ProductAdapterDB;
import br.com.grafana.sma.core.business.Product;
import br.com.grafana.sma.persistence.entity.ProductEntity;
import br.com.grafana.sma.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryPortPostgre implements ProductRepositoryPort {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAdapterDB productAdapter;

    @Override
    public List<Product> findAllProducts() {
        System.out.println("c=ProductRepositoryPortPostgre m=findAllProducts");

        return productRepository.findAllProducts()
                .stream().map(
                        productAdapter::toDomain
                )
                .collect(Collectors.toList());
    }

    @Override
    public Product createProduct(Product product) {
        System.out.println("c=ProductRepositoryPortPostgre m=createProduct");

        ProductEntity productEntity = productRepository.save(productAdapter.toEntity(product));
        return productAdapter.toDomain(productEntity);
    }

    @Override
    public Optional<Product> findByCode(UUID code) {
        System.out.println("c=ProductRepositoryPortPostgre m=findByCode code=" + code);
        return productRepository.findByCode(code)
                .map(productAdapter::toDomain);
    }

    @Override
    @Transactional
    public void deleteByCode(UUID code) {
        System.out.println("c=ProductRepositoryPortPostgre m=deleteByCode code=" + code);
        productRepository.deleteByCode(code);
    }
}
