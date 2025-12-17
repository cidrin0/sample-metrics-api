package br.com.grafana.sma.core.business;

import br.com.grafana.sma.core.business.domain.Description;
import br.com.grafana.sma.core.business.domain.Name;
import br.com.grafana.sma.core.business.domain.Price;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    public final UUID code;
    public final Name name;
    public final Description description;
    public final Price price;

    public Product(UUID code, String name, String description, BigDecimal price) {
        this.code = code;
        this.name = new Name(name);
        this.description = new Description(description);
        this.price = new Price(price);
    }

    public Product(String name, String description, BigDecimal price) {
        this.code = UUID.randomUUID();
        this.name = new Name(name);
        this.description = new Description(description);
        this.price = new Price(price);
    }
}
