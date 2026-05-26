Resumo arquitetural
- Stack: Spring Boot 4 (Java 21), Micrometer, Prometheus, Grafana, PostgreSQL (containerizado).
- Métricas expostas: /actuator/prometheus
- Dashboards Grafana: config/dashboards/*.json (provisionamento via config/dashboards.yaml)

Pontos críticos
- application.yaml usa jdbc:postgresql://${DATABASE_HOST}:5432/product_db
- Variáveis sensíveis devem vir de .env ou Docker secrets.
- Atualmente: spring.jpa.hibernate.ddl-auto: create-drop (apenas dev).

Contratos e fluxo
- API: rotas definidas em src/main/java/br/com/grafana/sma/api/resource (ex: ProductResource.java).
- Requests/Responses: src/main/java/br/com/grafana/sma/api/resource/request (CreateProductRequest.java) e /response (ProductResponse.java, SearchProductsResponse.java).
- Casos de uso: src/main/java/br/com/grafana/sma/core/business/usecase (CreateProductUseCase, SearchProductsUseCase, DeleteProductUseCase).
- Persistência: src/main/java/br/com/grafana/sma/persistence/entity/ProductEntity.java e repository/ (ProductRepository.java, ProductRepositoryPort*.java).
- Adapters/ports: src/main/java/br/com/grafana/sma/adapter (ProductAdapterApi, ProductAdapterDB).
- OpenAPI: src/main/java/br/com/grafana/sma/api/config/OpenApiConfig.java.

Comandos úteis
- Build: ./gradlew build
- Docker Compose: docker-compose up --build

Where to look
- Classe principal: src/main/java/br/com/grafana/sma/SampleMetricsApplication.java
- Configurações: src/main/resources/application.yaml
- Docker orchestrator: docker-compose.yml

Dívidas técnicas identificadas
- Falta de CI (integrar build e smoke tests).  
- Ausência de migrations versionadas (Flyway/Liquibase) — atualmente JPA `ddl-auto` controla schema.  
- Cobertura de testes limitada; adicionar testes unitários e integração para os usecases principais.  

Sugestões operacionais
- Criar job CI que execute `./gradlew build` e rode smoke tests em um serviço Docker Compose.  
- Adicionar `CONTRIBUTING.md` e `CODE_OF_CONDUCT.md` para facilitar contribuições.  
- Considerar usar `spring.profiles` para separar configurações dev/ci/prod e evitar `create-drop` em perfis errados.
