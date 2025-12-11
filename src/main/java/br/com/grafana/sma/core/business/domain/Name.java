package br.com.grafana.sma.core.business.domain;

public record Name(String content) {

    public Name {
        if (content == null
                || content.trim().length() < 2
                || content.trim().length() > 70) {
            throw new IllegalArgumentException("invalid name");
        }
    }
}
