# ① 프로젝트 소개
주제 및 주요 기능
: 상품 CRUD 관리 프로그램 및 상품 추가, 상품 전체 읽기, 특정 상품 읽기, 상품 업데이트 기능, 상품 삭제

Entity 필드 구조 : 
id : Long
name : String
description : String
category : String
date : Integer
price : Integer

프로젝트 구조 및 개발환경 

src/
    main/
        java/
            com.example.demo/
                            controller/
                                        ProductController
                            dto/
                                ProductRequest
                                ProductResponse
                            entity/
                                    Product
                            repository/
                                        ProductRepository
                            service/
                                    ProductService
                            DemoApplication

개발환경 : JDK 17 이상, Gradle, Spring Boot

GitHub Repository URL : https://github.com/2026-2-WebService/assign09-c01-22500698
Render Deployment URL : https://assign09.onrender.com
② Database SQL Practice
기존 Table 조회 및 데이터 추가 결과
![스크린샷 2026-10-30 오후 10.56.32.png](../../../../Desktop/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202026-10-30%20%EC%98%A4%ED%9B%84%2010.56.32.png)
![스크린샷 2026-10-30 오후 11.02.05 1.png](../../../../Desktop/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202026-10-30%20%EC%98%A4%ED%9B%84%2011.02.05%201.png)
새 Table 생성 SQL
![CREATE.png](../../../../Desktop/CREATE.png)
INSERT / UPDATE / DELETE / SELECT SQL과 실행 결과
![INSERT.png](../../../../Desktop/INSERT.png)
![UPDATE.png](../../../../Desktop/UPDATE.png)
![DELETE.png](../../../../Desktop/DELETE.png)
![SELECT.png](../../../../Desktop/SELECT.png)
DBeaver 실행 화면 또는 결과
③ Spring Data JPA 구현
Entity 및 JpaRepository 설명
: 데이터 필드인 id, name, description, category, date, price가 있고, 각 생성자와, 내용을 수정할때 사용하는 update함수와, 각 필드 데이터에 접근 가능하게 해주는 getter들이 존재한다.
Jpa Repository는 sql을 직접 적지 않고도, 데이터를 삭제, 추가, 수정 등의 작업을 편리하게 할 수 있게 도와주는 인터페이스이다.
사용한 Annotation의 역할
@Entity는 entity임을 나타낸다.
@Column는 엔티티의 필드와 데이터베이스의 컬럼을 매핑하는 것을 나타낸다.
@Table은 매핑될 데이터베이스의 테이블 이름을 나타낸다.
@ID는 각 엔티티를 구별가능하게 도와주는 키를 나타낸다.
@GeneratedValue는 기본키를 자동으로 생성한다.

REST API Endpoint 목록 및 요청·응답 JSON
POST /api/products 상품 등록
요청 : 
{
"name": "키보드",
"description": "기계식 키보드",
"category": "전자기기",
"date": 2026,
"price": 50000
}
응답 :
{
"id": 1,
"name": "키보드",
"description": "기계식 키보드",
"category": "전자기기",
"date": 2026,
"price": 50000
}
GET /api/products 전체 상품 조회
응답 :
[
{
"id": 1,
"name": "키보드",
"description": "기계식 키보드",
"category": "전자기기",
"date": 2026,
"price": 50000
},
{
"id": 2,
"name": "마우스",
"description": "무선 마우스",
"category": "전자기기",
"date": 2026,
"price": 20000
}
]
GET	/api/products/{id} 특정 상품 조회
응답 :
{
"id": 1,
"name": "키보드",
"description": "기계식 키보드",
"category": "전자기기",
"date": 2026,
"price": 50000
}
PUT	/api/products/{id} 상품 수정
요청 :
{
"name": "게이밍 키보드",
"description": "RGB 기계식 키보드",
"category": "전자기기",
"date": 2026,
"price": 70000
}
응답 :
{
"id": 1,
"name": "게이밍 키보드",
"description": "RGB 기계식 키보드",
"category": "전자기기",
"date": 2026,
"price": 70000
}
DELETE /api/products/{id} 상품 삭제


JPA Entity와 MariaDB Table 비교

JPA Entity는 단순한 Java 인텔리제에서 만든 객체이고, JPA를 통해 맵핑된다. 또한 MariaDB Table은 실제 데이터베이스에 데이터가 저장되는 곳입니다.
④ JPA와 SQL 비교
save(), findAll(), findById(), deleteById() 사용 결과
![save().png](../../../../Desktop/save%28%29.png)
![findAll.png](../../../../Desktop/findAll.png)
![findById.png](../../../../Desktop/findById.png)
![delete().png](../../../../Desktop/delete%28%29.png)
실제 Hibernate SQL 확인
![Hibernate SQL.png](../../../../Desktop/Hibernate%20SQL.png)
SQL을 직접 작성하는 방식과 JPA 방식의 차이
SQL을 직접 작성하는 방식은 직접 코드를 적으면서 복잡한 기능을 구현할때와 자세하게 조작할때는 좋지만,
JPA 방식을 사용하면, 자동으로 바로 entity가 매핑되고, Hibernate가 필요한 SQL문을 자동으로 생성하면서 간편하게 데이터를 처리 가능하게 사용할 수 있다.
⑤ 배포 및 환경 설정

IntelliJ 및 Render 환경변수 설정 방법(변수명만 기록)
DB_URL
DB_PASSWORD
DB_USERNAME

Render 배포 과정
github에 개인 레포를 한개 생성한다. 그후 레포주소와 연결한후에 푸시하고, render와 개인 레포를 연결하고, 환경변수를 render에 저장한다. 그리고 재배포를 하면 배포가 된다.
배포 URL의 CRUD 테스트 결과
![스크린샷 2026-10-30 오후 11.38.52.png](../../../../Desktop/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202026-10-30%20%EC%98%A4%ED%9B%84%2011.38.52.png)
MariaDB 데이터 저장 확인
![스크린샷 2026-10-30 오후 11.40.04.png](../../../../Desktop/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202026-10-30%20%EC%98%A4%ED%9B%84%2011.40.04.png)
발생한 문제와 해결 방법
create method로 response로 가지고올때는 id가 숫자로 잘 나왔는데, findAll로 데이터를 나타낼때는 id가 전부 null로 되어있어서 뭐가 문제인지 봤더니 response 데이터로 변환하는 함수 안에 id 부분을 null로 고정시킨 것이 문제여서, request.id()로 수정한뒤, 깃헙에 푸시하고 재배포 진행했다. 
⑥ Weekly Report

Key Learning: 새롭게 이해한 내용 3가지
JPA를 사용하면, SQL문을 굳이 복잡하게 적지 않아도 간단하게 데이터를 처리 할 수 있다.
DB를 실제로 연결할때는 db url를 사용해서 환경변수로 연결해야한다. 
@Entity 를 사용해서, 데이터베이스의 사용할 테이블을 어노테이션을 추가함으로서 만들 수 있다. 
Problem & Solution: 문제 1개 이상과 해결 과정
intellij를 실행하는데 계속해서 처음부터 오류가 나서 찾아보니까, ProductController가 ProductService 빈을 찾지 못했어서 나타나는 오류라고 확인했고, @Service 어노테이션을 서비스 클래스 바로위쪽에 추가했습니다. 
Code Review: 중요한 코드 1개와 동작 설명
@GeneratedValue(strategy = GenerationType.IDENTITY)
이거고, 데이터를 추가할때 식별하는 id를 계속 같은 id가 아니라 계속 값이 +1이 추가되게 하는 코드이다. 이 코드로 인해 테이블 안에 있는 데이터들을 구별가능하게된다.
AI Usage: AI 활용 내용 및 직접 수정·검증한 부분, 자신이 생각하는 AI사용률(%)
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

이 부분을 ai를 활용해서, 계속 interface가 아니라 class로 사용해서 나타나는 문제를 해결했었습니다. 5% 정도입니다.
Reflection: 추가로 공부하고 싶은 내용
crud 프로그램 뿐만 아니라 백엔드 사용자 메세지를 주고받는 것도 해보고싶습니다.