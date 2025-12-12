package br.com.grafana.sma.persistence.port;

import br.com.grafana.sma.core.business.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepositoryPort {

    List<Product> findAllProducts();
}
