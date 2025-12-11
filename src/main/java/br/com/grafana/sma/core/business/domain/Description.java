package br.com.grafana.sma.core.business.domain;

public record Description(String content) {

    public Description {
        if (content == null
                || content.trim().length() < 2
                || content.trim().length() > 200) {
            throw new IllegalArgumentException("invalid description");
        }
    }

}
