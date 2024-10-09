# JDK 21을 포함한 공식 OpenJDK 이미지 사용
FROM openjdk:21-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# 현재 디렉토리의 내용을 컨테이너의 /app 디렉토리에 복사
COPY . .

# Gradle 빌드 실행
RUN ./gradlew build

# 애플리케이션 실행 (필요 시)
CMD ["java", "-jar", "build/libs/your-app.jar"]