#!/bin/sh -eu

endpoint="${TODOS_SERVICE_ENDPOINT:-http://localhost:8080}"
node_env="${NODE_ENV:-development}"

cat <<EOF
    window.env={};
    window.env.TODOS_SERVICE_ENDPOINT="$endpoint";
    window.env.NODE_ENV="$node_env";

    console.log('Environment loaded!');
EOF
