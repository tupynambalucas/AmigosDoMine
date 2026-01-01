FROM eclipse-temurin:21-jre-alpine

LABEL maintainer="Amigos Do Mine Team"

RUN apk add --no-cache curl bash eudev-libs

RUN addgroup -S minecraft && adduser -S minecraft -G minecraft

WORKDIR /data
EXPOSE 25565

CMD ["sh", "-c", "exec java -Xms${MC_MIN_MEM} -Xmx${MC_MAX_MEM} -XX:+UseG1GC -jar ${MC_JAR_NAME} nogui"]