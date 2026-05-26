Objetivo
- Fornecer instruções curtas e precisas para assistentes automáticos (Copilot, subagents) e desenvolvedores humanos que fizerem edições no código.

Contexto do projeto
- Projeto: Sample Spring Boot Metrics API
- Linguagem / runtime: Java 21, Spring Boot 4, Gradle
- Ponto de entrada: src/main/java/br/com/grafana/sma/SampleMetricsApplication.java
- Endpoints importantes: /actuator, /actuator/prometheus, /swagger-ui.html

-
Arquitetura de código (locais importantes)
- Recursos REST: src/main/java/br/com/grafana/sma/api/resource (ex: ProductResource.java)
- DTOs: src/main/java/br/com/grafana/sma/api/resource/request e /response
- Casos de uso / lógica de negócio: src/main/java/br/com/grafana/sma/core/business/usecase
- Entidades e persistência: src/main/java/br/com/grafana/sma/persistence/entity e repository/port
- Adapters: src/main/java/br/com/grafana/sma/adapter (api e db)

Comandos úteis
- Build: ./gradlew build
- Rodar local (sem Docker): ./gradlew bootRun
- Rodar com Docker Compose: docker-compose up --build

Regras gerais para edições automáticas
- Priorize mudanças pequenas e reversíveis.
- Sempre executar testes unitários/integration (se existirem) antes de propor merge.
- Não introduzir credenciais ou segredos em código/commits.
- Não alterar arquivos em /config/dashboards/* sem validar JSON no Grafana JSONLint.

Estilo de código
- Siga as convenções Java padrão do projeto (formatador do IDE, sem comentários desnecessários).
- Prefira nomes claros para métodos e variáveis.

Checklist mínimo antes de PR
1. Build local: ./gradlew build (sem erros).
2. Smoke test: endpoints /actuator e /actuator/prometheus respondem 200.
3. Atualizar README.md se mudar comandos de run.
4. Remover segredos e adicionar variáveis ao .env ou secret manager.

Contato
- Mantenha mudanças pequenas e peça revisão humana em PRs que toquem infraestrutura ou segurança.

Análise rápida e ações esperadas
- Este repositório não possui CI configurado; antes de propor mudanças amplas, executar localmente:
	- `./gradlew build`
	- `./gradlew bootRun` ou `docker-compose up --build`
	- Verificar `/actuator` e `/actuator/prometheus` respondem 200
- Verifique se há testes novos e garanta cobertura mínima para alterações críticas.

O que automatizar
- Run formatter and static analysis (SpotBugs/Checkstyle) before PR.
- Run smoke tests (curl /actuator and /actuator/prometheus) in CI pipeline.

Nota: siga `CONTRIBUTING.md` quando houver (ainda a ser criado) para regras específicas de commit e PR.
