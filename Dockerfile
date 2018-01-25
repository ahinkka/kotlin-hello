FROM azul/zulu-openjdk-alpine:8
MAINTAINER Atte Hinkka
EXPOSE 8080/tcp

COPY build/libs/kotlin-hello-0.1.0.jar /app.jar
ENTRYPOINT ["java"]
CMD ["-jar", "/app.jar"]