FROM registry.jahiduls.mint/node:16-alpine as builder

RUN npm i -g pnpm

ARG NODE_ENV
ARG PUBLIC_URL

WORKDIR /assets

COPY package.json ./
RUN NODE_ENV=$NODE_ENV pnpm install

COPY . ./
RUN NODE_ENV=$NODE_ENV,PUBLIC_URL=$PUBLIC_URL pnpm build

FROM registry.jahiduls.mint/nginx:alpine as production

COPY --from=builder /assets/build /usr/share/nginx/html
COPY docker-entrypoint.sh generate-config-js.sh /
RUN chmod +x docker-entrypoint.sh generate-config-js.sh

EXPOSE 80

ENTRYPOINT ["/docker-entrypoint.sh"]
