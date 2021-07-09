FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD


COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/techbrewers-offerDetails-1.0.jar /app/

ENV PORT 8084

EXPOSE 8084


ENTRYPOINT ["java", "-jar", "techbrewers-offerDetails-1.0.jar"]
