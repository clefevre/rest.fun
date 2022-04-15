#####################################################################
# Builds a docker image with the Rest.Fun Application pre-installed #
#####################################################################

# creating the builder to split fat jar into layers
FROM azul/zulu-openjdk:17.0.0

MAINTAINER Christopher lefevre <christopher.lefevre@gmail.com>

# Create a non-root user
RUN useradd -ms /bin/bash microservice
USER microservice
WORKDIR /home/microservice

COPY artifacts/${projectName}.jar microservice.jar
#Extract the Jar so that we can have separated Library and Code layers
RUN java -Djarmode=layertools -jar microservice.jar extract

# set JVM options
ENV JDK_JAVA_OPTIONS '-server \
                      -XX:+UnlockExperimentalVMOptions \
                      -XX:+UseContainerSupport \
                      -XX:+ScavengeBeforeFullGC \
                      -XX:+UseSerialGC \
                      -XX:MinHeapFreeRatio=20 \
                      -XX:MaxHeapFreeRatio=40 \
                      -XX:GCTimeRatio=4 \
                      -XX:AdaptiveSizePolicyWeight=90 \
                      -Dsun.net.inetaddr.ttl=30'

# Switch to the root user
USER root

# Create a layer for each set of files, in increasing volatility
COPY --from=builder /home/microservice/dependencies/ /opt/microservice/
COPY --from=builder /home/microservice/spring-boot-loader/ /opt/microservice/
COPY --from=builder /home/microservice/snapshot-dependencies/ /opt/microservice/
COPY --from=builder /home/microservice/application/ /opt/microservice/

# expose the HTTP port that the application will be listening on
EXPOSE 8080

# set the working directory to where the the service jar file was copied
WORKDIR /opt/microservice/

# start the init service
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

# Switch to the non-root user just in case it got changed upstream
USER microservice
