# Исследование AccountService'а 
___

A rock-paper-scissors game backend written on Java.

Tech stack: Java 17, spring-boot, PostgreSQL, Docker, Grafana

## How to run the backend

### Maven + Spring-Boot
Prerequisites: installed docker jdk 17+, maven, git

```
cd <your project dir> 
https://github.com/alexeymoskvinov/ifuture-task
cd rock-paper-scissors
```
### To run with integration tests (started docker is needed)
```
mvn clean install -DskipTests
docker compose up
```

### To run grafana to collect statistics

go to http://localhost:3000/ 

login: admin
password: admin 

![Text](images/grafana_login.png)

Go to: Configuration -> Add data source -> Prometheus

Add http://host.docker.internal:9090 in HTTP URL and click button save & test

![Text](images/prometheus_config.png)

Go to Dashboard -> + Import and paste text from data/prometheus/config/jvm-micrometer_rev9.json

![Text](images/dashboard_add.png)

Press Load and Import

![Text](images/1_dashboard.png)

It`s info about jvm

Import second dashboard from  data/prometheus/config/micrometer-spring-throughput_rev2.json

![Text](images/2_dashboard.png)

It`s second dashboard where you can see full information about requests to client service