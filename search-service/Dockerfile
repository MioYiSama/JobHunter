FROM azul/prime-centos:21

WORKDIR /app

COPY target/*.jar /app/app.jar

EXPOSE 8086
CMD ["java", "-jar", "app.jar"]