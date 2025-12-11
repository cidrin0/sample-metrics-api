package br.com.grafana.sma.core.business;

import br.com.grafana.sma.core.business.domain.Description;
import br.com.grafana.sma.core.business.domain.Name;
import br.com.grafana.sma.core.business.domain.Price;
import br.com.grafana.sma.persistence.entity.ProductEntity;

public class Product {

    public final Name name;
    public final Description description;
    public final Price price;

    public Product(ProductEntity productEntity) {
        this.name = new Name(productEntity.name);
        this.description = new Description(productEntity.description);
        this.price = new Price(productEntity.price);
    }
}
