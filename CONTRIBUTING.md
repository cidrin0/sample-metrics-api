# Contributing

Thank you for contributing to the Sample Spring Boot Metrics API project!
This document describes how you can collaborate effectively and securely.

## How to Contribute

1. Fork and clone this repository.
2. Create a feature or fix branch:
   ```bash
   git checkout -b feature/my-improvement
   ```
3. Run the build locally:
   ```bash
   ./gradlew build
   ```
4. Make your changes and add tests whenever possible.
5. Before opening the PR, run:
   - `./gradlew build`
   - `./gradlew bootRun` (when appropriate)
   - `curl -f http://localhost:8080/actuator/health`
   - `curl -f http://localhost:8080/actuator/prometheus`
6. Open a Pull Request to the `main` branch with a clear description of your changes.

## Code Standards

- Prefer clear names for classes, methods, and variables.
- Follow the project's Java conventions.
- Avoid unnecessary comments; code should be self-explanatory.
- When changing public APIs, update `OpenApiConfig.java` when necessary.

## Tests

- Add unit and integration tests whenever possible.
- Verify that existing tests continue to pass.
- If you include new endpoints or metrics, add smoke tests or corresponding validation.

## Configuration and Secrets

- Use `.env.example` as a model and never commit the `.env` file.
- Do not include credentials in code or versioned configuration files.
- Update `.gitignore` if you need to exclude new local configuration files.

## Review Request

- Explain the purpose of the PR.
- List the changed files and expected impact.
- Mention if the change requires security, architecture, or data review.

## Plan-First Policy (Agents)

Before significant code, architecture, or infrastructure changes, create a plan in agents/plans/ using agents/plans/plan-template.md. Use the ./agents/plan-and-commit.sh -p <plan> -m "message" script to review the plan and diff before committing. Commits that change infrastructure, security, or design should mention the plan in the PR and may require additional human review.

See agents/README.md for details on agents, triggers, and related policies.

