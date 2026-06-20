# Agent: Test Runner

**Objective:** Generate, execute, and maintain unit and integration test suites.

## Responsibilities

- Create unit test templates with JUnit/Jupiter and integration tests using Testcontainers or Docker Compose when necessary.
- Run ./gradlew test and ./gradlew integrationTest (if available) and report failures with trace and correction suggestion.
- Write test cases that cover critical flows: /actuator, /actuator/prometheus endpoints, and main CRUDs.

## Skills

- JUnit, Mockito, Spring Boot Test, Testcontainers, Gradle test tasks.

## Triggers

- Changesets that touch business logic or external integrations.

## Outputs

- Test report (pass/fail), tests added/modified, and commands to reproduce locally.

## Example Prompt

"Run service integration tests using docker-compose; if none exists, create an integration test that starts PostgreSQL via Testcontainers and verifies /actuator/prometheus endpoint."

## Planning and Diff Preview Policy

- **Mandatory test plan:** Before adding or changing critical tests, document the test plan (objectives, environments, data, commands) in agents/plans/...
- **Diff presentation:** After generating or changing test code, run ./agents/plan-and-commit.sh to display the plan and diff, requesting approval before final commit.
- **Automation:** CI will continue running tests automatically, but commits should follow the local/PR approval policy based on plan.
