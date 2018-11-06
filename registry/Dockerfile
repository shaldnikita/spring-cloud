FROM openjdk:10
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/registry.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry.jar"]

EXPOSE 8761