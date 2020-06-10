#!/usr/bin/env sh

docker rmi todos.service:local

docker build -t todo.service:local .
