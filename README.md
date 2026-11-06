① Entity

Q1. @Entity, @Id, @GeneratedValue는 각각 어떤 역할을 하는가?
@Entity는 객체와 데이터베이스를 맵핑하는 객체를 나타내는 어노테이션
@Id는 엔티티를 식별하는 기준
@GeneratedValue는 해당 엔티티를 생성했을때, PK값을 자동으로 추가하는 어노테이션
Q2. Entity 클래스와 데이터베이스 테이블은 어떻게 연결되는가?
엔티티 클래스와 데이터베이스 테이블은 @Entity를 통해 JPA가 연결된 DB와 맵핑할 객체인지를 확인후 데이터베이스 테이블과 Entity 데이터 필드들과 맵핑한다.
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
