FROM java:8-jre
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/config.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]

EXPOSE 4000