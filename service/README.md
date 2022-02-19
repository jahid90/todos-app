[![CI](https://github.com/jahid90/todo-service/actions/workflows/ci.yml/badge.svg)](https://github.com/jahid90/todo-service/actions/workflows/ci.yml)

# TodoService

Backend for the TodoApp. Manages CRUD operations for todo resources.

## Details

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

## APIs

```
- POST /todos
- PUT /todo/update
- DELETE /todo/{id}
- PUT /todo/toggle/{id}
- GET /todos
- GET /todos?completed={boolean}
- GET /todo/{id}
```

## Development

Checkout the package
```bash
git clone git@github.com:jahid90/todo-service.git
```

Make necessary changes and start the server
```bash
./gradlew bootRun
```