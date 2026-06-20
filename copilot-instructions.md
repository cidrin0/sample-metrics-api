Goal
- Provide short and precise instructions for automated assistants (Copilot, subagents) and human developers making code edits.

Project Context
- Project: Sample Spring Boot Metrics API
- Language / Runtime: Java 21, Spring Boot 4, Gradle
- Entry Point: src/main/java/br/com/grafana/sma/SampleMetricsApplication.java
- Important Endpoints: /actuator, /actuator/prometheus, /swagger-ui.html

Code Architecture (Important Locations)
- REST Resources: src/main/java/br/com/grafana/sma/api/resource (e.g., ProductResource.java)
- DTOs: src/main/java/br/com/grafana/sma/api/resource/request and /response
- Use Cases / Business Logic: src/main/java/br/com/grafana/sma/core/business/usecase
- Entities and Persistence: src/main/java/br/com/grafana/sma/persistence/entity and repository/port
- Adapters: src/main/java/br/com/grafana/sma/adapter (api and db)

Useful Commands
- Build: ./gradlew build
- Run locally (without Docker): ./gradlew bootRun
- Run with Docker Compose: docker-compose up --build

General Rules for Automated Edits
- Prioritize small and reversible changes.
- Always run unit/integration tests (if they exist) before proposing a merge.
- Do not introduce credentials or secrets in code/commits.
- Do not modify files in /config/dashboards/* without validating JSON in Grafana JSONLint.

Code Style
- Follow the project's standard Java conventions (IDE formatter, no unnecessary comments).
- Prefer clear names for methods and variables.

Minimum Checklist Before PR
1. Local build: ./gradlew build (no errors).
2. Smoke test: endpoints /actuator and /actuator/prometheus respond 200.
3. Update README.md if you change run commands.
4. Remove secrets and add variables to .env or secret manager.

Contact
- Keep changes small and request human review on PRs that touch infrastructure or security.

Quick Analysis and Expected Actions
- This repository has no CI configured; before proposing large changes, run locally:
	- `./gradlew build`
	- `./gradlew bootRun` or `docker-compose up --build`
	- Check that `/actuator` and `/actuator/prometheus` respond 200
- Check if there are new tests and ensure minimum coverage for critical changes.

What to Automate
- Run formatter and static analysis (SpotBugs/Checkstyle) before PR.
- Run smoke tests (curl /actuator and /actuator/prometheus) in CI pipeline.

Note: Follow `CONTRIBUTING.md` when available for specific commit and PR rules.
