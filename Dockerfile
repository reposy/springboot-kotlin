# 1. OpenJDK 이미지 사용
FROM openjdk:21-jdk-slim

# 2. 빌드된 JAR 파일을 /app 디렉터리로 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app/app.jar

# 3. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]