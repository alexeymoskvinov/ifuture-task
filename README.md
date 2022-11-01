# Исследование AccountService'а 
___

A rock-paper-scissors game backend written on Java.

Tech stack: Java 17, spring-boot, PostgreSQL, Docker, Grafana

## Information about services

### - account-service:

Service for creating an account or changing the balance on an already created one, as well as for obtaining information about the account

The interface contains two requests:

1)Add amount(int accountId, int value)
http://localhost:8080/account
Json Example:
```
{
    "id": 3,
    "value": 3 
}
```

2)Get amount
http://localhost:8080/account/{id}


### - dto-lib

Service that stores shared DTO

### - test client

The service that is needed to create a load on the account-service

The interface contain one request:
Start test (rCount, wCount, idList) http://localhost:8081/test-client-start
- rCount - number of reading threads. Method getAmount(id) 
- wCount - number of writing threads. Method addAmount(id,value)
- idList - List of used id

Json Example:
```
{
    "rCount": 10,
    "wCount": 10,
    "idList":[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16] 
}
```


## How to run 

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
docker-compose up
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