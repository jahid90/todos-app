#!/usr/bin/env sh

docker rmi todos:local

docker build -t todos:local .
