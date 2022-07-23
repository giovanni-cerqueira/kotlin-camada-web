FROM adoptopenjdk/openjdk11
EXPOSE 8080
ADD /build/libs/forum-0.0.1-SNAPSHOT.jar forum.jar
ENTRYPOINT ["java", "$JAVA_OPTS -XX:+UseContainerSupport", "-Xmx300m -Xss512k -XX:CICompilerCount=2", "-Dsverver.port=$PORT", "-Dspring.profiles.active=prod",  "-jar", "forum.jar"]