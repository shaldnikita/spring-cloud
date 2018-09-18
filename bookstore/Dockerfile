FROM java:8-jre
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/bookstore.jar /app/
CMD ["java", "-Xmx200m", "-Dspring.profiles.active=prod","-jar", "/app/bookstore.jar"]

EXPOSE 7000