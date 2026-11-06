① Entity

Q1. @Entity, @Id, @GeneratedValue는 각각 어떤 역할을 하는가?
@Entity는 객체와 데이터베이스를 맵핑하는 객체를 나타내는 어노테이션
@Id는 엔티티를 식별하는 기준
@GeneratedValue는 해당 엔티티를 생성했을때, PK값을 자동으로 추가하는 어노테이션
Q2. Entity 클래스와 데이터베이스 테이블은 어떻게 연결되는가?
엔티티 클래스와 데이터베이스 테이블은 @Entity를 통해 JpaRepositoy를 extends로 repository에 연결해서, jpa를 사용한다. DB와 맵핑할 객체인지를 확인후 데이터베이스 테이블과 Entity 데이터 필드들과 맵핑한다.
② Repository

Q3. JpaRepository<Entity, Long>에서 두 타입은 각각 무엇을 의미하는가?
Entity는 Jpa가 관리할 객체의 타입이고, Long은 이 객체를 식별하는 id 데이터의 타입이다.
Q4. JpaRepository에서 기본 제공하는 CRUD 메서드를 5개 이상 찾아 메서드명과 역할을 주석으로 작성하세요.
save() : 받아온 객체를 db에 저장한다.
deleteById() : id에 해당하는 객체를 db에서 삭제한다
findById() : id에 해당하는 객체를 db에서 찾는다.
findAll() : 해당 테이블에 있는 모든 데이터들을 db에서 가지고온다
existsById() : 해당 데이터가 실제로 존재하는지 안하는지 확인한다.
Q5. findById()의 반환 타입이 Optional인 이유는 무엇인가?
만약 id에 해당하는 데이터가 존재하지않는 null일 수도 있기 때문에, 만약 null일때 중단되지않고 null인 상태인 것을 클라이언트에게 알려줘야하기 때문에 Optional을 사용한다. 
다만 나는 orElseThrow함수를 사용해서, null일때 예외처리로서 http 상태코드를 따로 바로 반환가능하게 설정해서, 중단되지 않게 했기 때문에 findById에 객체가 존재할때는 toResponse함수로 response 형식에 맞춰서 반환되게 해서 findById의 반환타입이 Optional이 아닙니다. 
Q6. JpaRepository에서 기본 제공하는 메서드와 개발자가 직접 작성하는 Query Method의 차이는 무엇인가?
JpaRepository에서 기본 제공하는 메서드는 실제로 직접 작성하는 Query Method와 다르게, jpa가 메서드의 기능에 맞게 직접 sql 문을 작성해서 db에 반영까지 하지만, 개발자가 작성하는 쿼리 메서드는 직접 Query Method를 적는것 뿐만 아니라, 개발자가 sql문까지 직접 작성해서 DB에 변경사항을 반영해야합니다.
③ Service
Q7. save()를 호출하면 새로운 데이터 등록과 기존 데이터 수정이 어떻게 처리되는가?
save()를 호출하면, 먼저 객체가 entity로서 추가되고, jpa가 db에 추가된 객체를 db에 맵핑하여 추가한다. 또한 기존 데이터 수정은 Jpa가 관리하는 persistence context에 들어가있기 때문에, entity 객체를 불러와서 수정해도 dirty checking으로 update가 반영된다.
Q8. @Transactional과 Dirty Checking은 어떤 관계가 있는가?
@Transactional 어노테이션은, 개발자가 그걸 하고나서 데이터들을 변경하면, 그 함수 안에 있는 각각 태스크들이 한묶음의 transaction으로 포함되어서 만약에 그게 오류없이 무사히 종료된다면 commit이고, 만약 오류가 생긴다면 Rollback으로 바로 되돌린다. 그래서 commit을 하면 Persistence context안에 있는 Entity의 Dirty Checking 기능을 통해서 db에도 이 변경사항이 자동 반영된다.
작성 방법

질문과 관련된 코드에 직접 주석을 작성합니다.
기존 코드가 정상적으로 실행되도록 유지합니다.
관련 코드가 없다면 README에 그 이유를 작성합니다.
Q8은 STEP 4를 구현한 후 작성해도 됩니다.


① 프로젝트 소개

프로젝트 주제 및 주요 기능
: 상품 관리 CRUD 프로젝트
상품을 추가하고, 수정하고, 검색하고, 삭제하는 기본적인 CRUD의 기능을가지고있는 프로젝트입니다.

GitHub Repository URL : https://github.com/2026-2-WebService/assign10-c01-22500698.git
Render Deployment URL : 
② 주요 구현 내용 및 결과

Query Method 3개: 검색 조건 및 API 실행 결과
Dirty Checking: 수정 기능 구현 및 실행 결과
Auditing: 생성·수정 시간 자동 기록 결과
※ 소스 코드에 작성한 설명이나 주석을 README에 중복 작성할 필요는 없습니다. 주요 기능의 실행 결과를 중심으로 정리하세요.

③ Weekly Review

Key Learning: 새롭게 배운 내용 2~3가지
Problem & Solution: 어려웠던 점과 해결 방법
Reflection: 이번 과제를 통해 느낀 점
④ AI Usage

사용한 생성형 AI 도구 및 주요 질문
AI가 제공한 내용 중 직접 수정하거나 검증한 부분
AI 사용 비율에 대한 자기 평가
README 및 AI 사용 유의사항

README와 코드 설명 주석은 자신의 이해를 바탕으로 직접 작성해야 합니다.
생성형 AI는 개념 학습과 오류 해결에 활용할 수 있으나, 작성한 코드를 직접 설명할 수 있어야 합니다.
AI 사용률이 50% 이상인 경우 기존 평가 기준에 따라 감점될 수 있습니다.
필요시 TA가 코드 이해도를 확인하며, AI 탐지 결과만으로 감점을 확정하지 않습니다.