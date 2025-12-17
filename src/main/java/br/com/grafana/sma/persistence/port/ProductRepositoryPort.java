package br.com.grafana.sma.persistence.port;

import br.com.grafana.sma.core.business.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface ProductRepositoryPort {

    List<Product> findAllProducts();

    Product createProduct(Product product);

    Optional<Product> findByCode(UUID code);

    void deleteByCode(UUID code);
}
