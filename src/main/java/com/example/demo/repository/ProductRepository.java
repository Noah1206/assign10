package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>// Entity는 Jpa가 관리할 객체의 타입이고, Long은 이 객체를 식별하는 id 데이터의 타입이다.
{ // 엔티티 클래스와 데이터베이스 테이블은 @Entity를 통해 JpaRepositoy를 extends로 repository에 연결해서, jpa를 사용한다. DB와 맵핑할 객체인지를 확인후 데이터베이스 테이블과 Entity 데이터 필드들과 맵핑한다.
}
