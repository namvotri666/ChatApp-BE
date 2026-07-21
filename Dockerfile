FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/ChatApp-BE-0.0.1-SNAPSHOT.jar chatapp.jar
CMD ["java", "-Duser.timezone=Asia/Ho_Chi_Minh", "-jar", "chatapp.jar"]


