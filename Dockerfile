# 1. 사용할 베이스 이미지 선택
FROM openjdk:21-jdk-slim

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 로컬에 있는 JAR 파일을 컨테이너 내부로 복사
COPY app.jar /app/app.jar

# 4. 컨테이너 시작 시 JAR 파일 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]