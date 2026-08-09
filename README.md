# Logistics Engine & Order Processing Pipeline

[![Java CI](https://github.com/mairishavhoon/logistics-engine-java/actions/workflows/maven-ci.yml/badge.svg)](https://github.com/mairishavhoon/logistics-engine-java/actions)
![Java Version](https://img.shields.io/badge/Java-17%2B-blue)
![Testing](https://img.shields.io/badge/Testing-JUnit%205%20%7C%20Mockito-green)
![Build](https://img.shields.io/badge/Build-Maven-red)

## 📌 Project Overview
The **Logistics Engine** is a core business logic component designed to simulate rule-based parcel handling, rate calculation, and routing logic for logistics and supply-chain platforms. 

Rather than focusing on heavy UI layers, this repository is architected as an industrial backend service module. It demonstrates clean object-oriented design, rigorous unit testing practices, and automated continuous integration (CI) workflows standard in modern enterprise software engineering.

---

## 🎯 Objectives & Targeted Engineering Skills

This project serves as a showcase of practical software development practices, test-driven methodologies, and modern Java workflows:

* **Enterprise Testing:** Implementing robust test suites with **JUnit 5**, testing edge cases, and leveraging parameterized testing for scalable coverage.
* **Component Mocking:** Utilizing **Mockito** to isolate dependencies (e.g., external rate services, tax APIs) and verify internal logic independently.
* **Automated CI/CD Pipelines:** Setting up **GitHub Actions** to automate builds, validate dependency trees, and execute test suites automatically on every Pull Request.
* **Clean Code & Domain Design:** Writing modular, readable, and maintainable Java adhering to standard OOP principles, clean exception handling, and strong domain modeling.

---

## 🛠️ Tech Stack & Tools

* **Language:** Java 17+
* **Testing Framework:** JUnit 5 (Jupiter), AssertJ
* **Mocking Framework:** Mockito
* **Build & Dependency Management:** Apache Maven
* **Continuous Integration:** GitHub Actions

---

## 📁 Key Features & Test Scenarios

- [x] **Rate Calculation Engine:** Rule-based domestic and international shipping rate determination based on weight and destination attributes.
- [x] **Validation & Error Handling:** Comprehensive edge-case handling for invalid weights, missing package metadata, and non-supported destinations.
- [x] **Parameterized Test Suites:** Multi-scenario testing via `@ParameterizedTest` and `@CsvSource` to validate edge cases efficiently.
- [x] **Mocked Service Layer:** Mocking external boundary dependencies using `@Mock` and `@InjectMocks`.

---

## 🚀 Getting Started

### Prerequisites
* JDK 17 or higher
* Apache Maven 3.8+
* Git

### Local Build & Test Execution

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/mairishavhoon/logistics-engine-java.git](https://github.com/mairishavhoon/logistics-engine-java.git)
   cd logistics-engine-java
