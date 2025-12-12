package br.com.grafana.sma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
public class SampleMetricsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleMetricsApplication.class, args);
    }

}
