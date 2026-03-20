package br.com.grafana.sma.core.business;

import br.com.grafana.sma.core.business.domain.Price;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    public final UUID code;
    public final String name;
    public final String description;
    public final Price price;

    public Product(UUID code, String name, String description, BigDecimal price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = new Price(price);
    }

    public Product(String name, String description, BigDecimal price) {
        this.code = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = new Price(price);
    }
}
