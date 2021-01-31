[![master](https://github.com/jahid90/todo-web/workflows/Node.js%20CI/badge.svg?branch=master)](https://github.com/jahid90/todo-web/actions?query=workflow%3A%22Node.js+CI%22+branch%3Amaster)
[![pull_requests](https://github.com/jahid90/todo-web/workflows/Node.js%20CI/badge.svg?event=pull_request)](https://github.com/jahid90/todo-web/actions?query=workflow%3A%22Node.js+CI%22+event%3Apull_request)

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## React Todo App

An app frontend written using ReactJS. Relies on a backend service for storing and retrieving todos, available in the same docker network at the hostname: `todos-service`.

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

#### Web

The app exposes port 80 on the docker container. The `docker-compose.yml` can be edited to expose a corresponding port on the host.

Alternatively, a reverse proxy container exposing port 80 on the host (such as `nginx`) can be setup to forward requests to a sub-domain (`todos.domain.local`) to the `todos-web` container. Once an `/etc/hosts` entry is made, the app can be accessed at [http://todos.domain.local](http://todos.domain.local).
