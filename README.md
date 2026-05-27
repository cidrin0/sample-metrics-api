
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

## Arquivos de instruções (novo)

Este repositório inclui arquivos de instruções para automações e colaboradores:

- copilot-instructions.md — regras e checklist para assistentes automáticos.  
- .prompt.md — prompts reutilizáveis para tarefas comuns.  
- .agent.md — regras operacionais para agentes automatizados.  
- SKILL.md — visão arquitetural e pontos críticos.  
- .instructions.md — passos rápidos para rodar e validar localmente.  
- AGENTS.md — responsabilidades de agentes e gatilhos.  
- .env.example — exemplo de variáveis de ambiente (sem segredos).
- CONTRIBUTING.md — guia de contribuição e regras de PR.
- CODE_OF_CONDUCT.md — padrão de comportamento para colaboradores.

Siga as instruções nestes arquivos antes de submeter mudanças significativas.

## Análise rápida do projeto (varredura automática)

Resumo das observações realizadas em 2026-05-26:

- Estrutura: código organizado por camada (api/resource, core/usecase, persistence/entity, adapter). Bom isolamento de responsabilidades.
- Observabilidade: Micrometer + Actuator + Prometheus e Grafana já configurados e expostos em `/actuator/prometheus`.
- Segurança/configuração: credenciais inicialmente em texto foram externalizadas para `.env` (veja `.env.example`) e `.gitignore` atualizado.
- Persistência: `spring.jpa.hibernate.ddl-auto` foi alterado para `update` para evitar perda de dados em ambientes de dev/integração; recomenda-se usar migrações (Flyway/Liquibase) para ambientes controlados.
- Testes & CI: não há pipelines CI configurados e existem poucas (ou nenhuma) suites de teste automatizado no repositório. Recomenda-se adicionar testes unitários e integração, e um job CI básico (build + smoke tests).

Recomendações prioritárias (próximos passos):

1. Adicionar CI (GitHub Actions, GitLab CI) que execute `./gradlew build` e smoke tests contra o serviço em um job Docker Compose.
2. Adotar migrações de banco (Flyway ou Liquibase) em vez de `ddl-auto` em ambientes persistentes.
3. Implementar testes de integração que validem `/actuator` e `/actuator/prometheus` e fluxos principais (Create/Search/Delete products).
4. Revisar dashboards em `config/dashboards/` e versioná-los com semântica de alterações (ex: dashboard-11378-v2.json).
5. Adicionar um `CONTRIBUTING.md` com fluxo de PR, revisão e padrões.

Se desejar, posso criar os arquivos iniciais: um workflow GitHub Actions básico, `CONTRIBUTING.md`, e um setup de Flyway com um migration inicial. Deseja que eu gere esses artefatos? (responda sim para criar). 

