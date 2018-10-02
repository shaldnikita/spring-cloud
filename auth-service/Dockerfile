FROM openjdk:10
MAINTAINER Nikita Shaldenkov <shaldnikita2@yandex.ru>

ADD ./target/auth-service.jar /app/
CMD ["java", "-Xmx200m", "-Dspring.profiles.active=prod","-jar", "/app/auth-service.jar"]

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8888/actuator/health || exit 1

EXPOSE 5000