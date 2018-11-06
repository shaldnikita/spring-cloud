FROM openjdk:10
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/costs-service.jar /app/
CMD ["java", "-Xmx200m", "-Dspring.profiles.active=prod","-jar", "/app/costs-service.jar"]

EXPOSE 7000