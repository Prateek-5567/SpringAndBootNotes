# Dockerfile Examples

## all these commands are correct as per jan 2026
# for descriptive notes refer your java notebook Prateek!.

## Docker commands
- docker build -t in28min/hello-world-docker:v1 .


## Dockerfile - 1 - Creating Docker Images

```
FROM eclipse-temurin:17-jdk-jammy
COPY target/*.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","/app.jar"]
```

## Dockerfile - 2 - Build Jar File - Multi Stage
```
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 5010
ENTRYPOINT ["java","-jar","app.jar"]
```

## Dockerfile - 3 - Caching

```
# -------- Build stage --------
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# -- Copy only pom.xml first (dependency caching)--
COPY pom.xml .
RUN mvn dependency:go-offline

# -- Copy full source AFTER deps are cached --
COPY src ./src
RUN mvn clean package -DskipTests


# -------- Runtime stage --------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
EXPOSE 5010
ENTRYPOINT ["java","-jar","app.jar"]



```
