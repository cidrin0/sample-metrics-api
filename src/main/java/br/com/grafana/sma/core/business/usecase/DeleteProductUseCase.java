package br.com.grafana.sma.core.business.usecase;

import br.com.grafana.sma.persistence.port.ProductRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteProductUseCase {

    @Autowired
    private ProductRepositoryPort productRepositoryPort;

    public void deleteProduct(UUID code) {
        System.out.println("c=DeleteProductUseCase m=deleteProduct code=" + code);
        productRepositoryPort.deleteByCode(code);
    }
}
