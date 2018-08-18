FROM java:8-jre
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/config.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/auth-service.jar"]

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8888/actuator/health || exit 1

EXPOSE 8888