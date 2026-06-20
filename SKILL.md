# Architectural Summary

- Stack: Spring Boot 4 (Java 21), Micrometer, Prometheus, Grafana, PostgreSQL (containerized).
- Exposed metrics: /actuator/prometheus
- Grafana Dashboards: config/dashboards/*.json (provisioning via config/dashboards.yaml)

## Critical Points

- application.yaml uses jdbc:postgresql://${DATABASE_HOST}:5432/product_db
- Sensitive variables should come from .env or Docker secrets.
- Currently: spring.jpa.hibernate.ddl-auto: create-drop (dev only).

## Contracts and Flow

- API: routes defined in src/main/java/br/com/grafana/sma/api/resource (e.g., ProductResource.java).
- Requests/Responses: src/main/java/br/com/grafana/sma/api/resource/request (CreateProductRequest.java) and /response (ProductResponse.java, SearchProductsResponse.java).
- Use Cases: src/main/java/br/com/grafana/sma/core/business/usecase (CreateProductUseCase, SearchProductsUseCase, DeleteProductUseCase).
- Persistence: src/main/java/br/com/grafana/sma/persistence/entity/ProductEntity.java and repository/ (ProductRepository.java, ProductRepositoryPort*.java).
- Adapters/Ports: src/main/java/br/com/grafana/sma/adapter (ProductAdapterApi, ProductAdapterDB).
- OpenAPI: src/main/java/br/com/grafana/sma/api/config/OpenApiConfig.java.

## Useful Commands

- Build: ./gradlew build
- Docker Compose: docker-compose up --build

## Where to Look

- Main class: src/main/java/br/com/grafana/sma/SampleMetricsApplication.java
- Configuration: src/main/resources/application.yaml
- Docker orchestrator: docker-compose.yml

## Identified Technical Debt

- Lack of CI (integrate build and smoke tests).
- Absence of versioned migrations (Flyway/Liquibase) — currently JPA `ddl-auto` controls schema.
- Limited test coverage; add unit and integration tests for main use cases.

## Operational Suggestions

- Create CI job that runs `./gradlew build` and runs smoke tests in a Docker Compose service.
- Add `CONTRIBUTING.md` and `CODE_OF_CONDUCT.md` to facilitate contributions.
- Consider using `spring.profiles` to separate dev/ci/prod configurations and avoid `create-drop` in wrong profiles.
