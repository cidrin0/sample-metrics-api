package br.com.grafana.sma.core.business.usecase;

import br.com.grafana.sma.core.business.Product;
import br.com.grafana.sma.persistence.port.ProductRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductUseCase {

    @Autowired
    private ProductRepositoryPort productRepositoryPort;

    public Product createProduct(Product product) {
        System.out.println("c=CreateProductUseCase m=createProduct");
        return productRepositoryPort.createProduct(product);
    }
}
