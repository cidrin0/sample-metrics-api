package br.com.grafana.sma.core.business.usecase;

import br.com.grafana.sma.core.business.Product;
import br.com.grafana.sma.persistence.port.ProductRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchProductsUseCase {

    @Autowired
    private ProductRepositoryPort productRepositoryPort;

    public List<Product> getProducts() {
        System.out.println("c=SearchProductsUseCase m=getProducts");

        // do the use case thing
        return productRepositoryPort.findAllProducts();
    }

}
