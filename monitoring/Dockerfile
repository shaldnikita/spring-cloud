FROM java:8-jre
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/monitoring.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/monitoring.jar"]

EXPOSE 4000