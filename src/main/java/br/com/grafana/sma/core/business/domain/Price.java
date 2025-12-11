package br.com.grafana.sma.core.business.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Price(BigDecimal content) {

    public Price {
        if (content.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("price must be greater than zero");
        }
    }

    public String formatted() {
        return content.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}
