#!/bin/sh -eu
./generate-config-js.sh >/usr/share/nginx/html/config.js
nginx -g "daemon off;"