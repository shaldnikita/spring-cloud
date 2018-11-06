FROM openjdk:10
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/cashspender.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/cashspender.jar"]

EXPOSE 9000