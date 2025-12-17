package br.com.grafana.sma.core.business.usecase;

import br.com.grafana.sma.core.business.Product;
import br.com.grafana.sma.core.business.exception.ProductNotFoundException;
import br.com.grafana.sma.persistence.port.ProductRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SearchProductUseCase {

    @Autowired
    private ProductRepositoryPort productRepositoryPort;

    public Product getProduct(UUID code) {
        System.out.println("c=SearchProductUseCase m=getProduct code=" + code.toString());
        return productRepositoryPort.findByCode(code).orElseThrow(() -> new ProductNotFoundException(code));
    }
}
