# Student Task Manager

A simple Java 17 + Maven application for practicing Jenkins Freestyle Projects.

## Features
- Add tasks
- Complete tasks
- Remove tasks
- Count pending tasks
- Count completed tasks
- JUnit 5 tests

## Requirements
- Ubuntu/Linux
- Java 17
- Maven

## Run locally

```bash
mvn clean test
mvn clean package
java -cp target/classes com.example.TaskManager
```

## Jenkins Freestyle practice

Build step:
```bash
mvn clean test
```

Second build step:
```bash
mvn package
```

Post-build action:
```text
Archive the artifacts: target/*.jar
```
