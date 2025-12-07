
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

