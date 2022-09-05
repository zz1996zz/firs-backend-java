# 🌱 샐러드뱅크 (금융 플랫폼)

<br>
<img src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=for-the-badge&logo=IntelliJ IDEA&logoColor=white">
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white">
<img src="https://img.shields.io/badge/spring boot-6DB33F?style=for-the-badge&logo=spring boot&logoColor=white">
<img src="https://img.shields.io/badge/spring security-6DB33F?style=for-the-badge&logo=spring security&logoColor=white">
<img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white">
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">
<img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black">
<img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=aws&logoColor=white">


<br>

## 요구사항 명세서
- https://mango-tower-9f1.notion.site/7670e6d5a49d489f806ea2fb271d4fcb

## 백엔드 팀원 및 담당 역할
### 팀장 이정수(@zz1996zz)
- 로그인/회원가입 기능
- 금융상품 정보 (대출 등) 를 검색/리스팅하는 기능 (검색 시 기간 / 내용 등으로 필터링 기능)
### 팀원 위준우(@wijoonwu)
- (회원 별) 특정 금융상품을 관심 상품으로 등록/해제하는 기능
- (회원 별) 관심 상품으로 등록해놓은 금융상품만 모아서 보는 기능
- (회원 별) 특정 금융상품을 장바구니에 담는 기능
- AWS 배포

## 개발 환경
- IDE : intelliJ IDEA
- JDK : java 11
- Project : Gradle 7.5
- Spring Boot : 2.7.3
- DataBase : MySQL 8.0.30

## Delpoyment

## Dependency
- Spring Web
- Spring Dev Tools
- Lombok
- Spring Data JPA
- Spring Security
- Swagger
- JWT

## Server Deployment Structure

## DB 다이어그램
<img src="https://media.discordapp.net/attachments/1009428199341555772/1016325137580167199/unknown.png?width=695&height=637">

## 패키지 구조 
- main
    - biz
        - domain : Entity, Enum 클래스
        - repository
        - service
    - web
        - controller
        - dto : Request, Response 객체

## API 명세서

http://3.34.229.74/swagger-ui/index.html#/loan-controller
