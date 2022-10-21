FROM openjdk:11
ARG JAR_FILE=target/*.*ar
COPY ${JAR_FILE} heroku-app-0.0.1-SNAPSHOT.*ar
ENTRYPOINT ["java", "-war", "/heroku-app-0.0.1-SNAPSHOT.war "]