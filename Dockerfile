FROM registry.access.redhat.com/ubi8/openjdk-11
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
