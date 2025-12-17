package br.com.grafana.sma.core.business.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(UUID code) {
        super("c=ProductNotFoundException code=" + code + " message=not-found");
    }
}
