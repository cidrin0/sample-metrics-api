
# Sample Spring Boot Metrics API

### **Demo project integrating Spring Boot, Micrometer, Prometheus, and Grafana**

This project is a sample application demonstrating how to expose application metrics,
using **Spring Boot Actuator**, **Prometheus** and **Grafana**. And Docker for build up components.

---

## 📌 **Features**

* Spring Boot 4 with Java 21
* Micrometer Metrics
* Prometheus scraping
* Grafana dashboards
* Docker and Docker Compose support
* OTLP registries

---

## 📦 **Dependencies Overview**

### **Runtime**

* **Actuator** → exposes `/actuator` endpoints
* **Micrometer Prometheus Registry** → exposes `/actuator/prometheus`
* **Micrometer OTLP Registry** → optional OTLP export (for future observability integrations)

### **Testing**

* `spring-boot-starter-actuator-test`
* `spring-boot-starter-webmvc-test`
* JUnit Platform

---

## 🐳 **Docker Compose Setup**

The project includes a **docker-compose.yml** that starts:

### **1. Grafana**

* Accessible at **[http://localhost:3000](http://localhost:3000)**
* Stores dashboards using a bind-mounted directory:
  `./data:/var/lib/grafana`

### **2. Prometheus**

* Accessible at **[http://localhost:9090](http://localhost:9090)**
* Configuration loaded from:
  `./config/prometheus.yml`
* Data persisted with named volume: `prometheus_data`

### **3. Metrics API (this project)**

* Built from the local Dockerfile
* Exposed at **[http://localhost:8080](http://localhost:8080)**

### **Networks & Volumes**

* Shared network: `ma-network`
* Persistent volume: `prometheus_data`

---

## ▶️ **How to Run**

### **1. Build the JAR**

```bash
./gradlew build
```

### **2. Build and Start the Stack**

```bash
docker-compose up --build
```

Before running, copy `.env.example` to `.env` and edit secrets if needed:

```bash
cp .env.example .env
# edit .env (do not commit)
```

### **3. Access the Services**

| Service     | URL                                            |
| ----------- | ---------------------------------------------- |
| Metrics API | [http://localhost:8080](http://localhost:8080) |
| Prometheus  | [http://localhost:9090](http://localhost:9090) |
| Grafana     | [http://localhost:3000](http://localhost:3000) |

Default Grafana credentials:

```
username: admin  
password: admin
```

---

## 📊 **Metrics Endpoints**

Once the application is running:

* **Spring Boot actuator root**
  [http://localhost:8080/actuator](http://localhost:8080/actuator)

* **Prometheus scrape endpoint**
  [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus)

---

## 📝 **Prometheus Configuration**

Make sure your `prometheus.yml` includes a job like:

```yaml
scrape_configs:
  - job_name: 'spring-boot-app'
    static_configs:
      - targets: ['metrics-api:8080']
```

---

## 📈 **Grafana Setup**

After Grafana starts:

1. Add Prometheus as a data source

    * URL: `http://prometheus:9090`
2. Import dashboards or create custom visualizations

You can explore built-in Micrometer dashboards or import community dashboards.

https://grafana.com/grafana/dashboards/

---

## 🚀 **Future Enhancements**

* Add custom business metrics
* Include dashboards in Grafana provisioning
* Add OTLP collector (Optional OpenTelemetry integration)
* Enable distributed tracing

---

## Instruction Files (New)

This repository includes instruction files for automation and contributors:

- copilot-instructions.md — rules and checklist for automated assistants.  
- .prompt.md — reusable prompts for common tasks.  
- .agent.md — operational rules for automated agents.  
- SKILL.md — architectural overview and critical points.  
- .instructions.md — quick steps to run and validate locally.  
- AGENTS.md — agent responsibilities and triggers.  
- .env.example — example environment variables (no secrets).
- CONTRIBUTING.md — contribution guide and PR rules.
- CODE_OF_CONDUCT.md — behavior standards for contributors.

Follow the instructions in these files before submitting significant changes.

## Quick Project Analysis (Automated Scan)

Summary of observations from 2026-05-26:

- Structure: code organized by layer (api/resource, core/usecase, persistence/entity, adapter). Good separation of concerns.
- Observability: Micrometer + Actuator + Prometheus and Grafana already configured and exposed at `/actuator/prometheus`.
- Security/Configuration: credentials initially in plain text have been externalized to `.env` (see `.env.example`) and `.gitignore` updated.
- Persistence: `spring.jpa.hibernate.ddl-auto` was changed to `update` to prevent data loss in dev/integration environments; it's recommended to use migrations (Flyway/Liquibase) for controlled environments.
- Tests & CI: no CI pipelines are configured and there are few (or no) automated test suites in the repository. It's recommended to add unit and integration tests, and a basic CI job (build + smoke tests).

Priority recommendations (next steps):

1. Add CI (GitHub Actions, GitLab CI) that runs `./gradlew build` and smoke tests against the service in a Docker Compose job.
2. Adopt database migrations (Flyway or Liquibase) instead of `ddl-auto` in persistent environments.
3. Implement integration tests that validate `/actuator` and `/actuator/prometheus` and main flows (Create/Search/Delete products).
4. Review dashboards in `config/dashboards/` and version them with change semantics (e.g., dashboard-11378-v2.json).
5. Add a `CONTRIBUTING.md` with PR flow, review, and standards.

If you wish, I can create the initial files: a basic GitHub Actions workflow, `CONTRIBUTING.md`, and a Flyway setup with an initial migration. Would you like me to generate these artifacts? (answer yes to create). 

