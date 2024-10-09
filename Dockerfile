# OpenJDK 21을 포함한 공식 이미지 사용
FROM openjdk:21-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# EC2의 /home/ubuntu/sypg/app.jar 파일을 컨테이너의 /app 디렉토리에 복사
COPY /home/ubuntu/sypg/app.jar app.jar

# 애플리케이션 실행
CMD ["java", "-jar", "app.jar"]