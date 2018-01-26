# Kotlin hello

Small POC Spring Kotlin app, packaged and all in a Docker container.

The runnable jar is at `build/libs/kotlin-hello-0.1.0.jar`.

The app along with a database server can be deployed locally using `docker-compose up`.


## How to build

`gradle build`

`docker-compose build`


## How to run

Start the containers and their network:

`docker-compose up`

Create and set up the database user; password should be set to "hello123" for the app to work:

`docker exec -i -t kotlin-hello-db su postgres -c 'createuser -P hello'`

Create the required database:

`docker exec -i -t kotlin-hello-db su postgres -c 'createdb kotlin-hello'`


## How to connect to

List ports mapped within the app and use that for the HTTP request:

`docker container port kotlinhello_app_1`

`curl "http://localhost:$PORT/greeting?name=foo`


Or as one line:

`PORT=$(docker container port kotlinhello_app_1 | cut -d':' -f2|head -1) curl "http://localhost:$PORT/greeting?name=foo"`

`PORT=$(docker container port kotlinhello_app_1 | cut -d':' -f2|head -1) curl "http://localhost:$PORT/greeting?name=bar"`
