# ๐ฅ ์๋ฌ๋๋ฑํฌ (๊ธ์ต ํ๋ซํผ)

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



## ๐ ํ๋ก์ ํธ ์ ๋ณด

### ๐ ๋ฏธ๋ฆฌ๋ณด๊ธฐ ์ด๋ฏธ์ง ๋ฐ ์์ฒญ URL  
- Cleint : https://saladbanklink.netlify.app/
- Server : https://saladbank.link/
<br><br>
<img src="https://velog.velcdn.com/images/wijoonwu/post/11440b84-6663-4f14-bc4f-452441f32ca0/image.png">

### ๐ ์๊ตฌ์ฌํญ ๋ช์ธ์
- https://mango-tower-9f1.notion.site/7670e6d5a49d489f806ea2fb271d4fcb
### ๐๏ธโโ๏ธ ํ๋ก์ ํธ ๊ธฐ๊ฐ
- 22/08/24 ~ 22/09/06 (13์ผ)
### ๐ฌ ํ๋ก์ ํธ ์ค๋ช
> ํ์์ ์ ๋ณด(๋์ด,์ทจ๋ฏธ,์๋,์ง์)์ ๋ฐ๋ผ ๋ง์ถคํ ๊ธ์ต์ํ(๋์ถ,์นด๋)์ ์ถ์ฒํด์ฃผ๋ ๊ธ์ต ํ๋ซํผ์๋๋ค.


## ๐ ํ๊ตฌ์ฑ ๋ฐ ๋ด๋น ์ญํ 
### ๐ง๐ปโ๐ป ํ์ฅ ์ด์ ์(@zz1996zz)
- JWT์ ์ํ๋ฆฌํฐ๋ฅผ ์ฌ์ฉํ ๋ก๊ทธ์ธ/ํ์๊ฐ์ ๊ธฐ๋ฅ ๊ตฌํ
- ์กฐ๊ฑด์ ๋ฐ๋ฅธ ๊ธ์ต์ํ ๊ฒ์๊ฒฐ๊ณผ ์กฐํ ๊ธฐ๋ฅ ๊ตฌํ
### ๐ฉ๐ปโ๐ป ํ์ ์์ค์ฐ(@wijoonwu)
- ํ์๋ณ ๊ด์ฌ์ํ ๋ฑ๋ก,์ญ์ ,์กฐํ ๊ธฐ๋ฅ ๊ตฌํ
- ํ์๋ณ ์ฅ๋ฐ๊ตฌ๋ ๋ฑ๋ก,์ญ์ , ์กฐํ ๊ธฐ๋ฅ ๊ตฌํ
- AWS๋ฅผ ์ด์ฉํ EC2 ์๋ฒ ๋ฐฐํฌ

## ๐ป ๊ฐ๋ฐ ํ๊ฒฝ
- IDE : intelliJ IDEA
- JDK : java 11
- Project : Gradle 7.5
- Spring Boot : 2.7.3
- DataBase : MySQL 8.0.30
- EC2 Instance free tier
- Amazon Linux2 kerner 5.10

## ๐ฑ Dependency
- Spring Web
- Spring Dev Tools
- Lombok
- Spring Data JPA
- Spring Security
- Swagger
- JWT


## ๐พ DB ๋ค์ด์ด๊ทธ๋จ
<img src="https://media.discordapp.net/attachments/1009428199341555772/1016325137580167199/unknown.png?width=695&height=637">

## ๐ ํจํค์ง ๊ตฌ์กฐ 
- main
    - biz
        - domain : Entity
        - repository
        - service
    - web
        - controller
        - dto : Request, Response ๊ฐ์ฒด

## ๐ก API ๋ช์ธ์
- http://3.34.229.74/swagger-ui/index.html#/loan-controller
### โ ๋ก๊ทธ์ธ/ํ์๊ฐ์
- `GET` /duplicate
- `POST` /register
- `POST`  /login
- `GET` /do-logout
### ๐งบ ์ฅ๋ฐ๊ตฌ๋
- `DELETE` /carts
- `DELETE` /carts/card/{id}
- `DELETE` /carts/loan/{id}
- `POST` /carts/card
- `POST` /carts/loan
- `GET` /carts/card
- `GET` /carts/loan
### โญ๏ธ ๊ด์ฌ์ํ
- `DELETE` /favorites
- `DELETE` /favorites/card/{id}
- `DELETE` /favorites/loan/{id}
- `POST` /favorites/card
- `POST` /favorites/loan
- `GET` /favorites/card
- `GET` /favorites/loan
### ๐ฉ๐ปโ๐ฆฑ ํ์๊ด๋ฆฌ
- `GET` /members/my-page
- `GET` /members/recommendation
- `GET` /members/edit
- `PUT` /members/edit
### ๐ ์ํ๊ด๋ฆฌ
- `GET` /products
- `GET` /products/{id}
- `GET` /products/search
- `GET` /cards
- `GET` /loans
