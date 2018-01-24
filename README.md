# Kotlin hello

Small POC Spring Kotlin app, packaged and all in a Docker container.

The runnable jar is at `build/libs/kotlin-hello-0.1.0.jar`.

The app with a database server can be deployed locally using `docker-compose up`.


# How to build

`gradle build`
`docker-compose build`


# How to run

Start the containers:
`docker-compose up`

Create and set up the database user; password should be set to "hello123" for the app to work:
`docker exec -i -t kotlin-hello-db su postgres -c 'createuser -P hello'`

Create the required database:
`docker exec -i -t kotlin-hello-db su postgres -c 'createdb kotlin-hello'`
