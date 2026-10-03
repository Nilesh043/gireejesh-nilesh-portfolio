FROM maven:3.9-eclipse-temurin-17
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q clean compile
EXPOSE 8080
CMD ["mvn", "-q", "exec:java"]