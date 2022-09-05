# 🥗 샐러드뱅크 (금융 플랫폼)

<br>
<div align="center">
    <img src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=for-the-badge&logo=IntelliJ IDEA&logoColor=white"/>
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"/>
    <img src="https://img.shields.io/badge/spring boot-6DB33F?style=for-the-badge&logo=spring boot&logoColor=white"/>
    <img src="https://img.shields.io/badge/spring security-6DB33F?style=for-the-badge&logo=spring security&logoColor=white"/>
    <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white"/>
</div>
<div align="center">
    <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"/>
    <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black"/>
    <img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white"/>
    <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"/>
    <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"/>
</div>
<div align="center">
    <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"/>
    <img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=aws&logoColor=white"/>
</div> 

<br>

## 📜 요구사항 명세서
- https://mango-tower-9f1.notion.site/7670e6d5a49d489f806ea2fb271d4fcb


## 🏋️‍♀️ 프로젝트 기간
- 22/08/24 ~ 22/09/06 (10일)

## 🔙 백엔드 팀원 및 담당 역할
### 🧑🏻‍💻 팀장 이정수(@zz1996zz)
- JWT와 시큐리티를 사용한 로그인/회원가입 기능 구현
- 조건에 따른 금융상품 검색결과 조회 기능 구현
### 👩🏻‍💻 팀원 위준우(@wijoonwu)
- 회원별 관심상품 등록,삭제,조회 기능 구현
- 회원별 장바구니 등록,삭제, 조회 기능 구현
- AWS를 이용한 EC2 서버 배포

## 💻 개발 환경
- IDE : intelliJ IDEA
- JDK : java 11
- Project : Gradle 7.5
- Spring Boot : 2.7.3
- DataBase : MySQL 8.0.30
- EC2 Instance free tier
- Amazon Linux2 kerner 5.10

## 🌱 Dependency
- Spring Web
- Spring Dev Tools
- Lombok
- Spring Data JPA
- Spring Security
- Swagger
- JWT


## 💾 DB 다이어그램
<img src="https://media.discordapp.net/attachments/1009428199341555772/1016325137580167199/unknown.png?width=695&height=637">

## 🕋 패키지 구조 
- main
    - biz
        - domain : Entity, Enum 클래스
        - repository
        - service
    - web
        - controller
        - dto : Request, Response 객체

## 📡 API 명세서
- http://3.34.229.74/swagger-ui/index.html#/loan-controller
### ✅ 로그인/회원가입
- `GET` /duplicate
- `POST` /register
- `POST`  /login
- `GET` /do-logout
### 🧺 장바구니
- `DELETE` /carts
- `DELETE` /carts/card/{id}
- `DELETE` /carts/loan/{id}
- `POST` /carts/card
- `POST` /carts/loan
- `GET` /carts/card
- `GET` /carts/loan
### ⭐️ 관심상품
- `DELETE` /favorites
- `DELETE` /favorites/card/{id}
- `DELETE` /favorites/loan/{id}
- `POST` /favorites/card
- `POST` /favorites/loan
- `GET` /favorites/card
- `GET` /favorites/loan
### 👩🏻‍🦱 회원관리
- `GET` /members/my-page
- `GET` /members/recommendation
- `GET` /members/edit
- `PUT` /members/edit
### 🎁 상품관리
- `GET` /products
- `GET` /products/{id}
- `GET` /products/search
