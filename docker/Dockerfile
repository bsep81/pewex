FROM openjdk:11
RUN mkdir -p /usr/src/pewex
COPY pewex-0.0.1-SNAPSHOT.jar /usr/src/pewex
WORKDIR /usr/src/pewex
ENTRYPOINT ["java", "-jar", "-Dspring.datasource.url=jdbc:mysql://192.168.238.128:3306/pewex", "-Dspring.datasource.username=pewex", "-Dspring.datasource.password=pewex", "pewex-0.0.1-SNAPSHOT.jar"]
