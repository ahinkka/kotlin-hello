FROM azul/zulu-openjdk-alpine:8
MAINTAINER Atte Hinkka
EXPOSE 8080/tcp


COPY build/libs/kotlin-hello-0.1.0.jar /app.jar
ENTRYPOINT ["java"]
CMD ["-jar", "/app.jar"]


# These need to be set from the outside. In case of docker-compose, in the
# .yml for dev. For prod somehow differently.
VOLUME /var/lib/postgresql/data
ENV SPRING_DATASOURCE_URL UNSET
ENV SPRING_DATASOURCE_USER UNSET
ENV SPRING_DATASOURCE_PASSWORD UNSET
