# DEBUG 세션
#FROM amazoncorretto:17
#ENV JAR_FILE_NAME=backend-0.0.1-SNAPSHOT.jar
#ENV JAR_FILE_PATH=build/libs/${JAR_FILE_NAME}
#COPY ${JAR_FILE_PATH} .
#ENTRYPOINT ["java", "-Xdebug", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar","backend-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["./entrypoint.sh"]

# RUN 세션
FROM openjdk:17-slim-buster AS base
ENV JAR_FILE_NAME=backend-0.0.1-SNAPSHOT.jar
ENV JAR_FILE_PATH=/home/deploy/app/backend/build/libs/${JAR_FILE_NAME}


FROM base as builder

RUN apt-get -qq update > /dev/null && \
    DEBIAN_FRONTEND=noninteractive apt-get -yq --no-install-recommends install build-essential unzip procps > /dev/null

RUN useradd --uid 1000 --gid users --shell /bin/bash --create-home deploy
USER deploy

RUN mkdir -p /home/deploy/app/backend
WORKDIR /home/deploy/app/backend
COPY --chown=deploy:users . .
RUN ./gradlew build -x test --parallel


FROM base AS production
RUN useradd --uid 1000 --gid users --shell /bin/bash --create-home deploy
USER deploy

RUN mkdir -p /home/deploy/app/backend
WORKDIR /home/deploy/app/backend
COPY --chown=deploy:users --from=builder ${JAR_FILE_PATH} ${JAR_FILE_PATH}
COPY --chown=deploy:users entrypoint.sh entrypoint.sh
EXPOSE 8080 5005 5006

CMD ["sh", "entrypoint.sh"]