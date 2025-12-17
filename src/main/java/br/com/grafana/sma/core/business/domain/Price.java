package br.com.grafana.sma.core.business.domain;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class Price extends BigDecimal {

    public Price(BigDecimal content) {
        super(content.setScale(2, HALF_UP).toPlainString());

        if (content.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("price must be greater than zero");
        }
    }
}
