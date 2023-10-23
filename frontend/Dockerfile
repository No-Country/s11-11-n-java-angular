# Stage 1
FROM node:18-alpine AS build
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --prod
RUN ls -alt

# Stage 2
FROM nginx:1.24.0-alpine
COPY --from=build /usr/src/app/dist/quantumgamer /usr/share/nginx/html
COPY --from=build /usr/src/app/nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 4000
