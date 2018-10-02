FROM openjdk:10
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/users-service.jar /app/
CMD ["java", "-Xmx200m", "-Dspring.profiles.active=prod","-jar", "/app/users-service.jar"]

EXPOSE 8761