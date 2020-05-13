FROM openjdk:8-jdk-alpine

ENV JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

RUN apk add --no-cache bash

ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

CMD java -jar /app.jar --spring.datasource.url="$URL" --spring.datasource.username="$USERNAME" --spring.datasource.password=$PASSWORD
