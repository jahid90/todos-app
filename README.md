[![service](https://github.com/jahid90/todos-app/actions/workflows/service.yml/badge.svg)](https://github.com/jahid90/todos-app/actions/workflows/service.yml)
[![client](https://github.com/jahid90/todos-app/actions/workflows/client.yml/badge.svg)](https://github.com/jahid90/todos-app/actions/workflows/client.yml)

# Todos App
A todos management app with a spring backend and a react frontend.

## Service

Backend for the TodoApp. Manages CRUD operations for todo resources.

### Details

- REST service built with SpringBoot
- Data store is MongoDB
- Resources fetched from store are cached using SpringCache
- Uses a home-grown CQRS pattern implementation
- Write endpoints generate suitable commands and submit to the command bus
- The command bus delivers them to the command processor which invokes them asynchronously
- The commands use a service to make the changes
- The service delegates writes/updates to the repository
- The service is decorated with a cache
- Read endpoints generate queries and submit them to the query processor
- The query processor delegates to the service

### APIs

```
- POST /todos
- PUT /todo/update
- DELETE /todo/{id}
- PUT /todo/toggle/{id}
- GET /todos
- GET /todos?completed={boolean}
- GET /todo/{id}
```

### Development

Checkout the package
```bash
git clone git@github.com:jahid90/todos-app.git
```

Make necessary changes and start the server
```bash
cd service
./gradlew bootRun
```

## Web Client

An app frontend written using ReactJS. Relies on a backend service for storing and retrieving todos.

### Usage

#### Build the app

```shell
pnpm build
```

#### Build a docker image

```shell
pnpm docker:build
```

#### Launch the app

```shell
pnpm docker:start
```

#### To stop the app

```shell
pnpm docker:stop
```

Note: `npm`/`yarn` can also be used instead of `pnpm`.

The app exposes port 80 on the docker container.
