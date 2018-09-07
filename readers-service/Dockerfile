FROM java:8-jre
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/readers-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/readers-service.jar"]

EXPOSE 8761