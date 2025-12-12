package br.com.grafana.sma.persistence.port;

import br.com.grafana.sma.adapter.ProductAdapter;
import br.com.grafana.sma.core.business.Product;
import br.com.grafana.sma.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryPortPostgre implements ProductRepositoryPort {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAdapter productAdapter;

    @Override
    public List<Product> findAllProducts() {
        System.out.println("c=ProductRepositoryPortPostgre m=findAllProducts");

        return productRepository.findAllProducts()
                .stream().map(
                        productAdapter::toDomain
                )
                .collect(Collectors.toList());
    }
}
