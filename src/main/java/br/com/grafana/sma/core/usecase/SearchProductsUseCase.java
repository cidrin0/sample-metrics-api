package br.com.grafana.sma.core.usecase;

import br.com.grafana.sma.core.business.Product;
import br.com.grafana.sma.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchProductsUseCase {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.searchProducts()
                .stream().map(Product::new)
                .collect(Collectors.toList());
    }

}
