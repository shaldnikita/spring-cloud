FROM java:8-jre
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry.jar"]

EXPOSE 4000