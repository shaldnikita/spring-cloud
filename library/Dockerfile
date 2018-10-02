FROM openjdk:10
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/library.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/library.jar"]

EXPOSE 9000