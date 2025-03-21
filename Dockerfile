FROM openjdk:21-jdk
WORKDIR /
COPY /build/libs/app.jar ./
ENTRYPOINT ["java","-jar","/app.jar"]