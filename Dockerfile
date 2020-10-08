FROM nginx:alpine

COPY ./build /usr/share/nginx/html
COPY docker-entrypoint.sh generate-config-js.sh /
RUN chmod +x docker-entrypoint.sh generate-config-js.sh

EXPOSE 80

ENTRYPOINT ["/docker-entrypoint.sh"]
